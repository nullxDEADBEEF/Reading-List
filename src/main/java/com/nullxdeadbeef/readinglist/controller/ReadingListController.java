package com.nullxdeadbeef.readinglist.controller;

import com.nullxdeadbeef.readinglist.model.Book;
import com.nullxdeadbeef.readinglist.model.Reader;
import com.nullxdeadbeef.readinglist.service.BookDAO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping( "/user" )
public class ReadingListController {

    /**
     * Fetches list of books
     * @param session current session
     * @param model the data to put in our view
     * @param readerName the name of the reader
     * @param book the book to add
     * @return the web page showing the list
     */
    @RequestMapping( "/{readerName}" )
    public String readerBookList( HttpSession session, Model model, @PathVariable String readerName, Book book ) {
        // fetch reading list for the specific reader
        Reader reader = (Reader)session.getAttribute( "reader" );
        model.addAttribute( "book", book );
        model.addAttribute( "books", reader.getReadingList() );

        return "readingList";
    }

    @ModelAttribute( "book" )
    public void createBook( HttpSession session, String title, String author, String isbn, String desc ) {
        Reader reader = (Reader)session.getAttribute( "reader" );
        session.setAttribute( "book", new Book( reader.getName(), isbn, title, author, desc ) );
    }

    /**
     * Adds a book to the reading list
     * @param session current session
     * @param readerName name of the reader
     * @return the same reading list page but updated
     */
    @PostMapping( "/{readerName}" )
    public String addToReadingList( HttpSession session, @PathVariable String readerName ) {
        Book book = (Book)session.getAttribute( "book" );
        Reader reader = (Reader)session.getAttribute( "reader" );
        reader.getReadingList().add( book );
        BookDAO.insert( book );

        return "redirect:/user/{readerName}";
    }
}
