package com.nullxdeadbeef.readinglist.service;

import com.nullxdeadbeef.readinglist.model.Book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDAO {

    public static void insert( Book book ) {
        String sql = "INSERT INTO Books (reader_id, isbn, title, author, " +
                "description) VALUES (LAST_INSERT_ID(), ?, ?, ?, ?)";

        try(
                Connection connection = DBUtil.getConnection();
                PreparedStatement ps = connection.prepareStatement( sql )
            )
        {
            ps.setString( 1, book.getIsbn() );
            ps.setString( 2, book.getTitle() );
            ps.setString( 3, book.getAuthor() );
            ps.setString( 4, book.getDescription() );
            ps.executeUpdate();
        } catch ( SQLException ex ) {
            System.err.println( "ERROR: " + ex );
        }
    }

    public static List<Book> selectBooksFromReader( String reader ) {
        List<Book> booksOfReader = new ArrayList<>();

        String sql = "SELECT * FROM Books WHERE reader = ?";

        try(
                Connection con = DBUtil.getConnection();
                PreparedStatement ps = con.prepareStatement( sql )
                )
        {
            ps.setString( 1, reader );
            ps.executeQuery();
        } catch ( SQLException ex ) {
            System.err.println( "ERROR: " + ex );
        }

        return booksOfReader;
    }
}
