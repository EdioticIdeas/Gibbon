package com.ideotic.edioticideas.gibbon;

/**
 * Created by Mukul on 28-04-2017.
 */

public class IssuedBooks {

    private String bookid = null;
    private String bookName = null;
    private String BookAuthor = null;
    private String bookPublisher = null;
    private String bookIssuedOnDate = null;
    private String bookReturnDate = null;
    private String bookCopies = null;

    public IssuedBooks(String bookId, String bookName, String bookAuthor, String bookPublisher, String bookCopies) {
        this.BookAuthor = bookAuthor;
        this.bookCopies = bookCopies;
        this.bookName = bookName;
        this.bookPublisher = bookPublisher;
        this.bookid = bookId;
    }

    public IssuedBooks(String bookName, String dueDate, String issuedDate) {
        this.bookName = bookName;
        this.bookIssuedOnDate = issuedDate;
        this.bookReturnDate = dueDate;
    }

    public String getbookId() {
        return bookid;
    }

    public String getBookName() {
        return bookName;
    }

    public String getBookAuthor() {
        return BookAuthor;
    }

    public String getBookPublisher() {
        return bookPublisher;
    }

    public String getBookIssuedOnDate() {
        return bookIssuedOnDate;
    }

    public String getBookReturnDate() {
        return bookReturnDate;
    }

    public String getBookCopies() {
        return bookCopies;
    }
}
