package com.libraymanagement;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Map;

public class LIBRARIAN {
	
	 static Map<Integer, STUDENT> issuedBooks = new HashMap<>();
	 
	 public void addOldIssuedStudents(LIBRARY library)
	 {
	        // Std 1
	        STUDENT s1 = library.searchStudent(201);
	        BOOK b1 = library.searchBook(102);
	        if (s1 != null && b1 != null) 
	        {
	            s1.setIssuedBook(b1);
	            s1.setIssueDate(LocalDate.of(2026, 8, 20));
	            s1.setDueDate(LocalDate.of(2026, 8, 27));
	            b1.setisAvaibable(false);
	            issuedBooks.put(s1.getStudentId(), s1);	       
	            }
	        // Std2 
	        STUDENT s2 = library.searchStudent(202);
	        BOOK b2 = library.searchBook(104);
	        if (s2 != null && b2 != null) 
	        {
	            s2.setIssuedBook(b2);
	            s2.setIssueDate(LocalDate.of(2026, 9, 1));
	            s2.setDueDate(LocalDate.of(2026, 9, 8));
	            b2.setisAvaibable(false);	        
	            issuedBooks.put(s1.getStudentId(), s1);	     
	            }
	    }
	 //Approve Book
	 public void approveBookIssue( LIBRARY library, STUDENT student, int bookId) 
	 {
	        BOOK book = library.searchBook(bookId);
	        if (book == null) {
	            System.err.println("Book Not Found!");
	            return;
	        }

	        if (!book.isAvaibable())
	        {
	            System.out.println("Book Already Issued!");
	            return;
	        }

	        if (student.getIssuedBook() != null) {
	            System.out.println("Student Already Has One Book!" );
	            return;
	        }
	        LocalDate issueDate = LocalDate.now();
	        LocalDate dueDate = issueDate.plusDays(7);
	        student.setIssuedBook(book);
	        student.setIssueDate(issueDate);
	        student.setDueDate(dueDate);
	        book.setisAvaibable(false);
	        issuedBooks.put(student.getStudentId(),student );
	        System.out.println();
	        System.out.println("\n=============================================================");
	        System.out.println("                 BOOK ISSUED APPROVED!    ");
	        System.out.println("==============================================================");
	        System.out.println("Student Id : "+student.getStudentId());
	        System.out.println("Student    : " +student.getStudentName());
	        System.out.println("Book       : " + book.getbookname());
	        System.out.println("Issue Date : " +issueDate);
	        System.out.println( "Due Date  : " +dueDate);
	        System.out.println("==============================================================");
	    }

	    // Retrun books
	    public void returnBook(STUDENT student) 
	    {
	        // Student null check
	        if (student == null) {
	            System.err.println("Student Not Found!");
	            return;
	        }
//	          check issued book
	        if (student.getIssuedBook() == null) {
	            System.err.println("No Book Issued For This Student!" );
	            return;
	        }
	        BOOK book = student.getIssuedBook();
	        LocalDate returnDate = LocalDate.now();
	        double fine = calculateFine( student.getDueDate(),returnDate);
	        System.out.println("Returned Book : " + book.getbookname() );
	        if (fine > 0) {
	            System.out.println( "Fine Amount : Rs." + fine);
	        } else {
	            System.out.println("No Fine");
	        }
	        book.setisAvaibable(true);
	        issuedBooks.remove( student.getStudentId());
	        student.setIssuedBook(null);
	        student.setIssueDate(null);
	        student.setDueDate(null);
	        System.out.println("Book Returned Successfully!");
//	        System.out.println(issuedBooks);
	    }
	 // FINE CALCULATOR
	    public double calculateFine(LocalDate dueDate,LocalDate returnDate)
	    {
	        if (returnDate.isAfter(dueDate)) 
	        {
	            long lateDays =ChronoUnit.DAYS.between(dueDate,returnDate);
	            return lateDays * 5;
	        }
	        return 0;
	    }
//      DUE Date 
	    public static void dueDate( LIBRARY library,int studentId)
	    {  
	    	System.out.println("------------------------------------------------------------");
	    	System.out.println("        ----- ISSUED STUDENT DETAILS -----");
	    	System.out.println("------------------------------------------------------------");
	    	
	    	LocalDate today = LocalDate.now();
	        try {
				for (STUDENT student : issuedBooks.values()) 
				{
				    System.out.println("Student ID   : " + student.getStudentId());
				    System.out.println("Student Name : " + student.getStudentName());
				    System.out.println("Book Name    : " + student.getIssuedBook().getbookname());
				    System.out.println("Issue Date   : "+ student.getIssueDate());
				    System.out.println("Due Date     : " + student.getDueDate());
				    	           
					if (today.isAfter(student.getDueDate()))
					{
				        System.out.println("Status       : Due Date Passed");
				    } else if (today.isEqual(student.getDueDate()))
				    {
				        System.out.println("Status       : Return Book Today");
				    } else {
				        System.out.println("Status       : Due Date Not Passed");
				    }
				    System.out.println("----------------------------------------------------");
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
}


