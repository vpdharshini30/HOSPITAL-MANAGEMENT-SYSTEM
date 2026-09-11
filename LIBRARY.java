package com.libraymanagement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class LIBRARY {
	  
	   private ArrayList<BOOK>books = new ArrayList<>();
	   private ArrayList<STUDENT> students = new ArrayList<>();
	   private Map<Integer, BOOK> issuedBooks = new HashMap<>();

	   public LIBRARY() 
	   {
	        BOOK b1 = new BOOK(101, "JavaProgramming","JamesGosling","Programming", true);
	        BOOK b2 = new BOOK(102,"Clean Code","Robert Martin","Programming",false );
	        BOOK b3 = new BOOK(103,"The Alchemist", "Paulo Coelho","Fiction      ", true);
	        BOOK b4 = new BOOK( 104,"Wings of Fire","AbdulKalam", "Biography",false);
	        BOOK b5 = new BOOK( 105,"Atomic Habits","James Clear","Self Help", true );
	        // Store objects inside ArrayList
	        books.add(b1);
	        books.add(b2);
	        books.add(b3);
	        books.add(b4);
	        books.add(b5);
	        students.add(new STUDENT(201, "Priya", "CSE"));
	        students.add(new STUDENT(202, "Kaviya", "ECE"));
	        students.add(new STUDENT(203, "Arun", "IT"));
	        students.add(new STUDENT(204, "Kayal", "EEE"));
	        students.add(new STUDENT(205, "varun", "IT"));
	        
	    }
	        
	   //ADD  BOOK
	   public void addBook(BOOK book) 
	   {
		   System.out.println("\n-----------------------------------------------------------------------------------------------");
		    System.out.printf("%-10s %-25s %-25s %-20s %-15s%n","BOOK ID", "BOOK NAME","AUTHOR","CATEGORY","AVAILABILITY");
			System.out.println("-----------------------------------------------------------------------------------------------");
	        books.add(book);
	        book.displayBookDetails();
	        System.out.println("-----------------------------------------------------------------------------------------------");
	        System.out.println("Book added successfully.");
	    }
	  //SEARCH BOOK
	   public BOOK searchBook(int id) 
	   {     
		  
	        for (BOOK book : books) {

	            if (book.getbookid() == id) {

	                return book;
	            }
	        }
	       
	        return null;
	    }
	   //VIEW ALL BOOKS
	   public void viewBooks()
	   {
		   if(books.isEmpty()) {
			   System.err.println("No books available. ");
			   return;
		   }
		   System.out.println("\n-----------------------------------------------------------------------------------------------");
		   System.out.printf("%-10s %-25s %-25s %-20s %-15s%n","BOOK ID", "BOOK NAME","AUTHOR","CATEGORY","AVAILABILITY");
			System.out.println("-----------------------------------------------------------------------------------------------");
		   for(BOOK book:books) {
			   book.displayBookDetails();
		   }
		   
	   }
	   //AVAILABLE BOOKS
	   public void availableBooks() {
		   System.out.println("\n---------AVAILABLE BOOKS----------");
		   System.out.println("\n-----------------------------------------------------------------------------------------------");
		   System.out.printf("%-10s %-25s %-25s %-20s %-15s%n","BOOK ID", "BOOK NAME","AUTHOR","CATEGORY","AVAILABILITY");
			System.out.println("-----------------------------------------------------------------------------------------------");
		   boolean found =false;
		   for(BOOK book:books) {
			   if(book.isAvaibable()) {
				   book.displayBookDetails();
				   found=true;
			   }
		   }
	   }
      ///Search the student
	   public STUDENT searchStudent(int studentId) {
		    for (STUDENT student : students)
		    {
		        if (student.getStudentId() == studentId)
		        {
		            return student;
		        }
		    }
		    return null;
		}
	// REPORT
	    public void generateReport()
	    {
	        int available = 0;
	        for (BOOK book : books) 
	        {
	            if (book.isAvaibable())
	            {
	                available++;
	            }
	        }
	        System.out.println("\n----- LIBRARY REPORT -----");
	        System.out.println("Total Books     : " + books.size());
	        System.out.println("Available Books : " + available);
	        System.out.println("Issued Books    : " + issuedBooks.size());
	    }
	
}

