package com.HospitalManagement;

import java.time.LocalDateTime;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

    	Scanner sc = new Scanner(System.in);
        Hospital hospital = new Hospital();
        for (Patient patient : Patient.getDefaultPatients()) {
            hospital.registerPatient(patient);
        }

        for (Doctor doctor : Doctor.getDefaultDoctors()) {
            hospital.addDoctor(doctor);
        }
        int patientId,doctorId;
        int choice;int specChoice;
        String specialization;
        

        do {System.out.println("\n=====WELCOME TO RK HOSPITAL======");
        System.out.println("\n========================================");
        System.out.println("     HOSPITAL APPOINTMENT MANAGEMENT");
        System.out.println("========================================");
        System.out.println("1. Register Patient");
        System.out.println("2. Add Doctor");
        System.out.println("3. View All Patient Details");
        System.out.println("4. Book Appointment");
        System.out.println("5. Cancel Appointment");
        System.out.println("6. View Available Slots");
        System.out.println("7. View Doctor Schedule");
        System.out.println("8. View Patient History");
        System.out.println("9. View All Doctor Details");
        System.out.println("10. Exit");
        System.out.println("========================================");
        System.out.print("Enter your choice: ");
            choice = sc.nextInt();
           try {
            switch (choice) {

                case 1:///REGISTER PATIENTS
                    System.out.println("\n==========REGISTER PATIENTS============");
                	System.out.print("Enter Patient ID: ");
                    patientId = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Patient Name: ");
                    String patientName = sc.nextLine();
                    System.out.print("Enter Age: ");
                    int age = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Gender: ");
                    String gender = sc.nextLine();
                    System.out.print("Enter Phone Number: ");
                    String phoneNumber = sc.nextLine();
                    Patient patient =new Patient(patientId, patientName, age, gender, phoneNumber);
                    hospital.registerPatient(patient);
                    System.out.println("Patients Details Added Successfully ");
                    break;

                case 2:////ADD DOCTOR
                       System.out.println("\n=========ADD DOCTOR===========");
                	   System.out.print("Enter Doctor ID: ");
                	    doctorId = sc.nextInt();
                	    sc.nextLine();
                	    System.out.print("Enter Doctor Name: ");
                	    String doctorName = sc.nextLine();
                	    System.out.print("Enter Specialization: ");
                	    specialization = sc.nextLine();
                	    Doctor doctor = new Doctor(doctorId, doctorName, specialization);
                	    hospital.addDoctor(doctor);
                	    System.out.println("Doctor Details Added Successfully ");
                	    break;

                case 3://View all Patient
                	System.out.println("\n=======VIEW ALL PATIENTS ========");
                    hospital.viewAllPatients();
                    break;

                case 4://BOOK APPOINTMENT
                    System.out.println("\n===== BOOK APPOINTMENT =====");
                    System.out.print("Enter Patient ID: ");
                    patientId = sc.nextInt();

                    if (!hospital.isPatientExists(patientId)) {
                        System.err.println("Patient ID not found!");
                        break;
                    }
                    sc.nextLine();
                    System.out.println("\n===== CHOOSE SPECIALIZATION =====");
                    System.out.println("1. Cardiologist");
                    System.out.println("2. Dermatologist");
                    System.out.println("3. General Physician");
                    System.out.println("4. Gastroenterologist");
                    System.out.println("5. Neurologist");
                    System.out.println("6. Infectious Disease Specialist");
                    System.out.println("7. Anesthesiologist");
                    System.out.println("8. Psychiatrist");
                    System.out.print("Enter Choice: ");
                    specChoice = sc.nextInt();
                    specialization = null;
                    switch (specChoice) {

                    case 1:
                        specialization = "Cardiologist";
                        break;
                    case 2:
                        specialization = "Dermatologist";
                        break;
                    case 3:
                        specialization = "General Physician";
                        break;
                    case 4:
                        specialization = "Gastroenterologist";
                        break;
                    case 5:
                        specialization = "Neurologist";
                        break;
                    case 6:
                        specialization = "Infectious Disease Specialist";
                        break;
                    case 7:
                        specialization = "Anesthesiologist";
                        break;
                    case 8:
                        specialization = "Psychiatrist";
                        break;
                    default:
                        System.out.println("Invalid Specialization Choice!");
                }
                    boolean doctorFound =hospital.viewDoctorsBySpecialization(specialization);
                    if (!doctorFound) {
                        break;
                    }
                    System.out.print("Enter Doctor ID: ");
                    doctorId = sc.nextInt();
                    if (!hospital.isDoctorExists(doctorId)) {
                        System.err.println("Doctor ID not found!");
                        break;
                    }
                    hospital.viewAvailableSlots(doctorId);
                    System.out.print("Choose Slot Number: ");
                    int slotNumber = sc.nextInt();
                    LocalDateTime selectedSlot =hospital.getSelectedSlot(doctorId, slotNumber);                                              
                    double fee = hospital.getConsultationFee(specialization);
                
                    if (selectedSlot != null) {
                        hospital.bookAppointment(patientId, doctorId, selectedSlot);
                    }  
                    break;

                case 5://Cancelled Appointment
                 
                    System.out.println("\n===== CANCEL APPOINTMENT =====");
                    System.out.print("Enter Appointment ID: ");
                    String appointmentId = sc.next();
                    hospital.cancelAppointment(appointmentId);
                    break;

                case 6://View Available Slots
                    System.out.println("\n===== VIEW AVAILABLE SLOTS =====");
                    sc.nextLine();
                    System.out.println("\n===== CHOOSE SPECIALIZATION =====");
                    System.out.println("1. Cardiologist");
                    System.out.println("2. Dermatologist");
                    System.out.println("3. General Physician");
                    System.out.println("4. Gastroenterologist");
                    System.out.println("5. Neurologist");
                    System.out.println("6. Infectious Disease Specialist");
                    System.out.println("7. Anesthesiologist");
                    System.out.println("8. Psychiatrist");
                    System.out.print("Enter Choice: ");
                    specChoice = sc.nextInt();
                    specialization = null;
                    switch (specChoice) {

                    case 1:
                        specialization = "Cardiologist";
                        break;
                    case 2:
                        specialization = "Dermatologist";
                        break;
                    case 3:
                        specialization = "General Physician";
                        break;
                    case 4:
                        specialization = "Gastroenterologist";
                        break;
                    case 5:
                        specialization = "Neurologist";
                        break;
                    case 6:
                        specialization = "Infectious Disease Specialist";
                        break;
                    case 7:
                        specialization = "Anesthesiologist";
                        break;
                    case 8:
                        specialization = "Psychiatrist";
                        break;
                    default:
                        System.out.println("Invalid Specialization Choice!");
                }
                    boolean found =hospital.viewDoctorsBySpecialization(specialization);
                    if (!found) {
                        break;
                    }
                    System.out.print("Enter Doctor ID: ");
                    doctorId = sc.nextInt();
                    if (!hospital.isDoctorExists(doctorId)) {
                        System.err.println("Doctor ID not found!");
                        break;
                    }
                    hospital.viewAvailableSlots(doctorId);
                    break;

                case 7:///VIEW DOCTOR SCHEDULE
                    System.out.println("\n===== VIEW DOCTOR SCHEDULE =====");

                    System.out.print("Enter Doctor ID: ");
                    doctorId = sc.nextInt();

                    if (!hospital.isDoctorExists(doctorId)) {
                        System.err.println("Doctor ID not found!");
                        break;
                    }
                    hospital.viewDoctorSchedule(doctorId);
                    break;

                case 8://View Patient 
                    System.out.println("\n===== VIEW PATIENT HISTORY =====");
                    System.out.print("Enter Patient ID: ");
                    patientId = sc.nextInt();
                    if (!hospital.isPatientExists(patientId)) {
                        System.out.println("Patient ID not found!");
                        break;
                    }
                    hospital.viewPatientHistory(patientId);
                    break;
                case 9:
                    hospital.viewAllDoctors();
                    break;
                case 10://Exit
                    System.out.println("Thank You!");
                default:
                	System.err.println("Invalid Choice");
            }
}
catch(IllegalArgumentException e) {
	System.out.println("Error : "+e.getMessage());
}

        } while (choice != 9);

        sc.close();
        
    }
}
