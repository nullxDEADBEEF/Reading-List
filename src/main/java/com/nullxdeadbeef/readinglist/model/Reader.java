package com.nullxdeadbeef.readinglist.model;

import java.util.List;

public class Reader {
    private String reader;
    private List<Book> readingList;

    public Reader() {}

    public Reader( String reader, List<Book> readingList ) {
        this.reader = reader;
        this.readingList = readingList;
    }

    public String getName() {
        return reader;
    }

    public void setReaderName( String readerName ) {
        this.reader = readerName;
    }

    public List<Book> getReadingList() {
        return readingList;
    }

    public void setReadingList( List<Book> readingList ) {
        this.readingList = readingList;
    }
}
