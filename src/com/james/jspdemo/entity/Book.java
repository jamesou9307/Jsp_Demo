package com.james.jspdemo.entity;

/**
 * Created by fsuser on 2017-07-18.
 */
public class Book {

    private String isbn;
    private String bookname;
    private int price;

    public Book(String isbn, String bookname, int price) {
        this.isbn = isbn;
        this.bookname = bookname;
        this.price = price;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
