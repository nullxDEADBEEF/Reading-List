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

    @PostMapping( "/" )
    public String redirectToReadingList( HttpSession session, String username ) {
        Reader reader = new Reader( username, new ArrayList<>() );
        session.setAttribute( "reader", reader );
        ReaderDAO.insert( reader );

        return "redirect:/user/" + username;
    }
}
