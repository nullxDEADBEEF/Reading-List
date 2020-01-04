package com.nullxdeadbeef.readinglist.controller;

import com.nullxdeadbeef.readinglist.model.Reader;
import com.nullxdeadbeef.readinglist.service.ReaderDAO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;

@Controller
public class HomeController {

    @RequestMapping( "/" )
    public String home() {
        return "index";
    }

    /**
     * adds a reader to the database and directs to reading list
     * @param session current session
     * @param username name of the reader
     * @return the redirected url
     */
    @PostMapping( "/" )
    public String redirectToReadingList( HttpSession session, String username ) {
        Reader reader = ReaderDAO.findReader( username );
        if ( reader == null ) {
            reader = new Reader( username, new ArrayList<>() );
            ReaderDAO.insert( reader );
        }

        session.setAttribute( "reader", reader );

        return "redirect:/user/" + username;
    }
}
