package com.libraymanagement; 
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method 
		Scanner sc=new Scanner(System.in);
     
		ArrayList<BOOK> books = new ArrayList<>();
	
		int choice;
		// LIBRARY Objects
        LIBRARY library = new LIBRARY();
        //LIBRARIAN Objects
        LIBRARIAN librarian = new LIBRARIAN();
        librarian.addOldIssuedStudents(library);
        //Students Object
       
        do  {

            System.out.println("\n=========================");
            System.out.println(" LIBRARY MANAGEMENT SYSTEM");
            System.out.println(" =========================");
            System.out.println("1. Add Book");  
            System.out.println("2. View Books");
            System.out.println("3. Search Book");
            System.out.println("4. Book Availability");
            System.out.println("5. Approve Book Issue");
            System.out.println("6. Return Book / Collect Fine");
            System.out.println("7. Due Date Reminder");
            System.out.println("8. Generate Report");
            System.out.println("9. Exit");
            System.out.println(" =========================");
            
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();
            switch(choice) {
            case 1://Add Books
            	System.out.print("Enter The BOOK ID : ");
            	int bookid=sc.nextInt();
            	sc.nextLine();
            	System.out.print("Enter The BOOK Name :");
            	String bookname = sc.nextLine();
            	
                System.out.print("Enter The Author Name :");
                String author = sc.nextLine();
               
                System.out.print("Enter The Category : ");
                String category = sc.nextLine();
                
                BOOK book = new BOOK(bookid,bookname,author,category,true);
                library.addBook(book);
                break;
                
            case 2://View BOOk
            	library.viewBooks();
            	break;
            	
            case 3://Search book
            	System.out.print("Please Enter The BookId to Search The Book : ");
            	int bookId=sc.nextInt();
            	BOOK searchBook=library.searchBook(bookId);
            	 System.out.println("\n-----------------------------------------------------------------------------------------------");
      		   System.out.printf("%-10s %-25s %-25s %-20s %-15s%n","BOOK ID", "BOOK NAME","AUTHOR","CATEGORY","AVAILABILITY");
      			System.out.println("-----------------------------------------------------------------------------------------------");
      		  
            	if(searchBook!=null) {
            		searchBook.displayBookDetails();
            		
            	}
            	else {
            		System.err.println("Book Not Found");
            	}
            	break;
            	
            case 4://Available Book
            	
            	library.availableBooks();
            	break;
            	
            case 5://Approve Book Issue
            	System.out.print("Enter the BookId : ");
            	int bookID=sc.nextInt();
            	System.out.print("Enter The Student Id : ");
            	int stid=sc.nextInt();
            	STUDENT student5 = library.searchStudent(stid);
            	librarian.approveBookIssue(library, student5, bookID);
            	break;
            	
            	
            case 6://Return Books
            	System.out.println("Enter The Student ID");
            	int stdid=sc.nextInt();
                STUDENT student = library.searchStudent(stdid);
                if (student != null) {
                    librarian.returnBook(student);
                } else 
                {
                    System.out.println("Student Not Found!");
                }
                break;
            case 7://DUE date 
            	
               System.out.print("Enter The Student Id : ");
               int remstdid=sc.nextInt();
               LIBRARIAN.dueDate(library,remstdid);
               break;
            
            case 8://Report 
            	library.generateReport();
            	break;
            case 9://Exit
            	System.out.println("Thank You.............");
            	break;
            default:
            	System.out.println("Try Again.............");
            }
            
        }while(choice!=10);
	}

	}


