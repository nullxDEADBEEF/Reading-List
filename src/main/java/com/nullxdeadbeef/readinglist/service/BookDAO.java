package com.nullxdeadbeef.readinglist.service;

import com.nullxdeadbeef.readinglist.model.Book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDAO {

    /**
     * Adds a book into the database
     * @param book the book to add
     */
    public static void insert( Book book ) {
        final String sql = "INSERT INTO Books (isbn, title, author," +
                "description, reader_id) SELECT ?, ?, ?, ?, id FROM Readers WHERE reader = ?";

        try(
                Connection connection = DBUtil.getConnection();
                PreparedStatement ps = connection.prepareStatement( sql )
            )
        {
            ps.setString( 1, book.getIsbn() );
            ps.setString( 2, book.getTitle() );
            ps.setString( 3, book.getAuthor() );
            ps.setString( 4, book.getDescription() );
            ps.setString( 5, book.getReader() );
            ps.executeUpdate();
        } catch ( SQLException ex ) {
            System.err.println( "ERROR: " + ex );
        }
    }

    /**
     * returns a reading list
     * @param reader the username of the reader
     * @return reading list of specified reader
     */
    public static List<Book> selectBooksFromReader( String reader ) {
        List<Book> booksOfReader = new ArrayList<>();

        String sql = "SELECT * FROM Books WHERE reader_id = ?";

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
