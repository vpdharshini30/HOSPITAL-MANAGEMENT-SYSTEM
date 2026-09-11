package com.libraymanagement;

class BOOK {
	   private int bookid;
	   private String bookname;
	   private String author;
	   private String category;
	   private Boolean isAvailable;
	
	public BOOK(int bookid, String bookname, String author, String category, boolean isAvailable) {
		// TODO Auto-generated constructor stub
		this.bookid=bookid;
		this.bookname=bookname;
		this.author=author;
		this.category=category;
        this.isAvailable=isAvailable;
	}
	
	public void setbookid(int bookid) {
		this.bookid=bookid;
	}
	public void setbookname(String bookname) {
		this.bookname=bookname;
	}
	public void setauthor(String author) {
		this.author=author;
	}
	public void setcategory(String category) {
		this.category=category;
	}
	public void setisAvaibable(boolean isAvailable) {
		this.isAvailable=isAvailable;
	}
	public int getbookid() {
		return bookid;
	}
	
	public String getbookname() {
		return bookname;
	}
	
	public String getauthor() {
		return author;
	}
	public String getcategory() {
		return category;
	}
	public Boolean isAvaibable() {
		return isAvailable;
	}
	public void displayBookDetails() {
		System.out.printf("%-10d %-25s %-25s %-20s %-15s%n",bookid,bookname,author,category,isAvailable);	
		System.out.println("-----------------------------------------------------------------------------------------------");
		}
	
}
	


