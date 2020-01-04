package com.nullxdeadbeef.readinglist.service;

import com.nullxdeadbeef.readinglist.model.Reader;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ReaderDAO {

    /**
     * inserts a reader into the database
     * @param reader name of the reader
     */
    public static void insert( Reader reader ) {
        final String sql = "INSERT INTO Readers (reader) VALUES (?)";
        try (
                Connection connection = DBUtil.getConnection();
                PreparedStatement ps = connection.prepareStatement( sql )
             )
        {
            ps.setString( 1, reader.getName()  );
            ps.executeUpdate();
        } catch ( SQLException ex ) {
            System.err.println( "ERROR: " + ex );
        }
    }

    public static Reader findReader( String username ) {
        final String sql = "SELECT * FROM Readers WHERE reader = ?";
        try (
                Connection connection = DBUtil.getConnection();
                PreparedStatement ps = connection.prepareStatement( sql );
                )
        {
            ps.setString( 1, username );
            ResultSet rs = ps.executeQuery();
            if ( rs.next() ) {
                Reader reader = new Reader();
                reader.setReaderName( rs.getString( "reader" ) );
                reader.setReadingList( BookDAO.selectBooksFromReader( reader.getName() ) );
                return reader;
            } else {
                return null;
            }
        } catch ( SQLException ex ) {
            System.err.println( "ERROR: " + ex );
            throw new RuntimeException( ex );
        }
    }
}
