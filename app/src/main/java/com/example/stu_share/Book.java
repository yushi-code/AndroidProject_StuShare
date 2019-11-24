package com.example.stu_share;

import java.io.Serializable;

public class Book implements Serializable {
    private int id;
    private int ownerId;
    private String title;
    private String author;
    private String edition;
    private String isbn;
    private String price;
    private String details;
    private String created;
    private String status;

    public Book( int id, int ownerId, String title, String author, String edition, String isbn,
                 String price, String details, String created, String status){
        this.id = id;
        this.ownerId = ownerId;
        this.title = title;
        this.author = author;
        this.edition = edition;
        this.isbn = isbn;
        this.price = price;
        this.details = details;
        this.created = created;
        this.status = status;
    }

    public int getId(){
        return id;
    }
    public int getOwnerId(){
        return ownerId;
    }
    public String getTitle(){
        return title;
    }
    public String getAuthor(){
        return author;
    }
    public String getEdition(){
        return edition;
    }
    public String getIsbn(){
        return isbn;
    }
    public String getPrice(){
        return price;
    }
    public String getDetails(){
        return details;
    }
    public String getCreated(){
        return created;
    }
    public String getStatus(){
        return status;
    }


    public void setId(int id) {
        this.id = id;
    }
    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setAuthor(String author){
        this.author = author;
    }
    public void setEdition(String edition) {
        this.edition = edition;
    }
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    public void setPrice(String price) {
        this.price = price;
    }
    public void setDetails(String details) {
        this.details = details;
    }
    public void setCreated(String created) {
        this.created = created;
    }
    public void setStatus(String status) {
        this.status = status;
    }


    public String toString(){
        return "Title: " + title + "\nAuthor: " + author + "\nEdition: " + edition +
                "\nISBN: " + isbn +  "\nPrice" + price + "\nDetails: " + details;
    }
}
