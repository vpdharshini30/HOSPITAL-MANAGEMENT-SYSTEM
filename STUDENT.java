package com.libraymanagement;
import java.time.LocalDate;

public class STUDENT {

    private int studentId;
    private String studentName;
    private String department;
    private BOOK issuedBook;
    private LocalDate issueDate;
    private LocalDate dueDate;

    public STUDENT(int studentId, String studentName,String department) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.department=department;
    }

    public int getStudentId() {
        return studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public BOOK getIssuedBook() {
        return issuedBook;
    }

    public void setIssuedBook(BOOK issuedBook) {
        this.issuedBook = issuedBook;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(LocalDate issueDate) {
        this.issueDate = issueDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public void displayStudent() {
        System.out.println("Student ID: " + studentId + " | Name: " + studentName);
    }
}
