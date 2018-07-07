package com.test.demo.model;

public class ZJModel2 {
    private  int id;
    private String bookname;
    private int bookid;
    private String bookdesr;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public int getBookid() {
        return bookid;
    }

    public void setBookid(int bookid) {
        this.bookid = bookid;
    }

    public String getBookdesr() {
        return bookdesr;
    }

    public void setBookdesr(String bookdesr) {
        this.bookdesr = bookdesr;
    }

    @Override
    public String toString() {
        return "ZJModel2{" +
                "id=" + id +
                ", bookname='" + bookname + '\'' +
                ", bookid=" + bookid +
                ", bookdesr='" + bookdesr + '\'' +
                '}';
    }
}
