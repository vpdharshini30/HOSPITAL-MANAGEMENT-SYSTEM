package com.HospitalManagement;

import java.util.ArrayList;

public class Patient {
	
	    private int patientId;
	    private String patientName;
	    private int age;
	    private String gender;
	    private String  phoneNumber;
	    public static ArrayList<Patient> getDefaultPatients()
	    {
		    ArrayList<Patient> patients = new ArrayList<>();
		    patients.add(new Patient(101, "Priya", 23, "Female", "9876543210"));
		    patients.add(new Patient(102, "Arun", 28, "Male", "9876543211"));
		    patients.add(new Patient(103, "Divya", 35, "Female", "9876543212"));
		    patients.add(new Patient(104, "Kavi" ,18,"Male","9876543213"));
		    return patients;
		}
	    public Patient(int patientId,String patientName,int age,String gender,String phoneNumber){
	    	this.patientId=patientId;
	    	this.patientName=patientName;
	    	this.age=age;
	    	this.gender=gender;
	    	this.phoneNumber = phoneNumber;
	    }
		public int getPatientId() {
			// TODO Auto-generated method stub
			return patientId;
		}
		public String getPatientName() {
			// TODO Auto-generated method stub
			return patientName;
		}
		public int getAge() {
			// TODO Auto-generated method stub
			return age;
		}
		public String getGender() {
			// TODO Auto-generated method stub
			return gender;
		}
		public String getPhoneNumber() {
			// TODO Auto-generated method stub
			return phoneNumber;
		
		}
	}


