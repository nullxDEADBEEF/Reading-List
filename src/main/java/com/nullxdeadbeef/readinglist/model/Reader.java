package com.nullxdeadbeef.readinglist.model;

import java.util.List;

public class Reader {
    private String reader;
    private List<Book> readingList;

    public Reader( String reader, List<Book> readingList ) {
        this.reader = reader;
        this.readingList = readingList;
    }

    public String getName() {
        return reader;
    }

    public void setReader( String reader ) {
        this.reader = reader;
    }

    public List<Book> getReadingList() {
        return readingList;
    }

    public void setReadingList( List<Book> readingList ) {
        this.readingList = readingList;
    }
}
