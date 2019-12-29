package com.nullxdeadbeef.readinglist.controller;

import com.nullxdeadbeef.readinglist.model.Book;
import com.nullxdeadbeef.readinglist.service.BookDAO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping( "/" )
public class ReadingListController {

    @RequestMapping( "/{reader}" )
    public String readerBooks( @PathVariable( "reader" ) String reader, Model model ) {
        // fetch reading list for the specific reader
        List<Book> readingList = BookDAO.selectBooksFromReader( reader );

        if ( reader != null ) {
            model.addAttribute( "books", readingList );
        }

        return "readingList";
    }

    @PostMapping( "/{reader}" )
    public String addToReadingList(@PathVariable( "reader" ) String reader, Book book ) {
        book.setReader( reader );
        return "redirect:/{reader}";
    }
}
