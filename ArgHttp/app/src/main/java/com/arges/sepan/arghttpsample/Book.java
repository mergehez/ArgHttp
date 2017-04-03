package com.arges.sepan.arghttpsample;

import java.util.Date;

/**
 * Created by arges on 4/3/2017.
 */

public class Book {

    private String title, author, publisher, language, isbn;
    private Date datePublished;
    private int pageNum;

    //constructor
    Book(){ }
    Book(String title, String author, String publisher, String language, String isbn, Date datePublished, int pageNum) {
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.language = language;
        this.isbn = isbn;
        this.datePublished = datePublished;
        this.pageNum = pageNum;

    }

    public String getBookAsString(){
        return "Title: " + this.title + "\nAuthor:" + this.author+"\n";
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Date getDatePublished() {
        return datePublished;
    }

    public void setDatePublished(Date datePublished) {
        this.datePublished = datePublished;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }
}