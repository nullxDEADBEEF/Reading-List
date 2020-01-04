package com.nullxdeadbeef.readinglist.service;

import com.nullxdeadbeef.readinglist.model.Reader;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
}
