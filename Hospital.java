package com.HospitalManagement;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Hospital
{
	Map<Integer, Patient> patients = new HashMap<>();

    Map<Integer, Doctor> doctors = new HashMap<>();

    Map<String, Appointment> appointments = new HashMap<>();
    private int appointment = 1001;
    public void registerPatient(Patient patient) {

        if (patients.containsKey(patient.getPatientId())) {
            System.err.println("Patient ID already exists!");
            return;
        }
        patients.put(patient.getPatientId(), patient);
        
    }

    public void addDoctor(Doctor doctor) {

        if (doctors.containsKey(doctor.getDoctorId())) {
            System.err.println("Doctor ID already exists!");
            return;
        }
        doctors.put(doctor.getDoctorId(), doctor);
       
    }

    public void bookAppointment(int patientId, int doctorId, LocalDateTime dateTime) {

        Patient patient = patients.get(patientId);
        Doctor doctor = doctors.get(doctorId);
        if (patient == null) {
        	 throw new IllegalArgumentException("Patient ID not found!");
        }
        if (doctor == null) {
            throw new IllegalArgumentException("Doctor ID not found!");
        }
        if (!doctor.getAvailableSlots().contains(dateTime)) {
            throw new IllegalArgumentException(
                    "Selected slot is not available or already booked!"
            );
        }
        for (Appointment appointment : appointments.values()) {
            if (appointment.getDoctor().getDoctorId() == doctorId &&appointment.getAppointmentDateTime().equals(dateTime) &&appointment.getStatus().equals("BOOKED")) 
            {
                System.out.println("This slot is already booked!");
                return;
            }
        }
        String appointmentId = "A" + appointment;
        appointment++;
        double fee = getConsultationFee(doctor.getSpecialization());
        Appointment appointment = new Appointment(appointmentId, patient, doctor, dateTime, "BOOKED",fee);
        appointments.put(appointmentId, appointment);
        System.out.println("\n+--------------------------------------+");
        System.out.println("|       APPOINTMENT CONFIRMED          |");
        System.out.println("+--------------------------------------+");

        System.out.println("Appointment ID       : " + appointmentId);
        System.out.println("Patient              : " + patient.getPatientName());
        System.out.println("Doctor               : " + doctor.getDoctorName());
        System.out.println("Specialization       : " + doctor.getSpecialization());
        System.out.println("Date & Time          : " + dateTime);
        System.out.println("Consultation Fee     : ₹" + fee);

        System.out.println("+--------------------------------------+");
    }

    	public void cancelAppointment(String appointmentId) {
    	    Appointment appointment = appointments.get(appointmentId);
    	    if (appointment == null) {
    	        throw new IllegalArgumentException( "Appointment ID not found!");
    	    }

    	    if (appointment.getStatus().equalsIgnoreCase("CANCELLED")) {
    	        throw new IllegalArgumentException( "Appointment already cancelled!");
    	    }

    	    appointment.setStatus("CANCELLED");
    	    appointment.getDoctor().getAvailableSlots().add(appointment.getAppointmentDateTime());
    	    System.out.println("Appointment Cancelled Successfully!");
    	}
    	

    public void viewAvailableSlots(int doctorId) {
    	Doctor doctor = doctors.get(doctorId);

        if (doctor == null) {
        	throw new IllegalArgumentException("Doctor ID not found!");
        }
      
        System.out.println("\nAvailable Slots for " + doctor.getDoctorName());
        System.out.println("----------------------------------------------------");
        for (LocalDateTime slot : doctor.getAvailableSlots()) {
            System.out.println(slot);
        }
    }
    	
    

    public void viewDoctorSchedule(int doctorId) {

        Doctor doctor = doctors.get(doctorId);

        if (doctor == null) {
        	throw new IllegalArgumentException("Doctor ID not found!");
        }
        System.out.println("\n===== DOCTOR SCHEDULE =====");
        System.out.println("---------------------------------------------------------------------");
        System.out.println("Schedule for " + doctor.getDoctorName());
        boolean found = false;
        for (Appointment appointment : appointments.values()) {

            if (appointment.getDoctor().getDoctorId() == doctorId && appointment.getStatus().equalsIgnoreCase("BOOKED")) {
                System.out.println(appointment.getAppointmentId() + " | " +appointment.getPatient().getPatientName() + " | " +appointment.getAppointmentDateTime() + " | " +appointment.getStatus());
                found = true;
            }
        }

        if (!found) {
            System.err.println("No Booked appointments found!");
        }
    }
    public void viewAllPatients() {

        if (patients.isEmpty()) {
        	 throw new IllegalArgumentException("Patient ID not found!");
        }

        System.out.println("\n------------- PATIENT DETAILS ----------------------------------");
        System.out.printf("%-10s %-20s %-5s %-10s %-15s%n", "ID", "NAME", "AGE", "GENDER", "PHONE");
        System.out.println("------------------------------------------------------------------");
        for (Patient patient : patients.values())
        {
            System.out.printf("%-10d %-20s %-10d %-12s %-15s%n",patient.getPatientId(),patient.getPatientName(), patient.getAge(),patient.getGender(),patient.getPhoneNumber());
        }
        System.out.println("================================================================");
    }
    public void viewAllDoctors() {

        if (doctors.isEmpty()) {
        	 throw new IllegalArgumentException("Doctor ID not found!");
        }

        System.out.println("\n------------- DOCTOR DETAILS --------------");
        System.out.printf("%-10s %-20s %-30s%n", "ID", "DOCTOR NAME", "SPECIALIZATION");
        System.out.println("-------------------------------------------");
        for (Doctor doctor : doctors.values()) {
        	 System.out.printf("%-10d %-20s %-35s%n",doctor.getDoctorId(),doctor.getDoctorName(),doctor.getSpecialization());     
        }
        System.out.println("================================================================");
    }

    public void viewPatientHistory(int patientId) {

        Patient patient = patients.get(patientId);
        if (patient == null) {
        	 throw new IllegalArgumentException("Patient ID not found!");
        }
        System.out.println("\nPatient History - " + patient.getPatientName());
        boolean found = false;

        for (Appointment appointment : appointments.values()) {

            if (appointment.getPatient().getPatientId() == patientId) {
                System.out.println("Appointment ID : " + appointment.getAppointmentId());
                System.out.println("Doctor         : " + appointment.getDoctor().getDoctorName());
                System.out.println( "Date & Time    : " + appointment.getAppointmentDateTime());
                System.out.println( "Status         : " + appointment.getStatus());
                System.out.println("-----------------------------");
                found = true;
            }
        }
        if (!found) {
            System.err.println("No appointment history found!");
        }
    }

	public LocalDateTime getSelectedSlot(int doctorId, int slotNumber) {
		// TODO Auto-generated method stub
		Doctor doctor = doctors.get(doctorId);
	    if (doctor == null) {
	    	throw new IllegalArgumentException( "Doctor ID not found!");
	    }
	    ArrayList<LocalDateTime> slots = doctor.getAvailableSlots();
	    if (slotNumber < 1 || slotNumber > slots.size()) {
	    	 throw new IllegalArgumentException("Invalid Slot Number!");
	    }
	    return slots.get(slotNumber - 1);
	}
	public boolean isDoctorExists(int doctorId) {
	    return doctors.containsKey(doctorId);
	}
	public boolean isPatientExists(int patientId) {
	    return patients.containsKey(patientId);
	}
	public double getConsultationFee(String specialization) {

	    switch (specialization.toLowerCase()) {
	        case "cardiologist":
	            return 800;
	        case "dermatologist":
	            return 600;
	        case "general physician":
	           return 400;
	        case "neurologist":
	            return 1000;
	        case "Gastroenterologist":
	            return 700;
	        case "Infectious Disease Specialist":
	        	return 1000;
	        case "Psychiatrist":
	            return 300;
	        case "Anesthesiologist":
	            return 500;
	        default:
	            return 0;
	    }
	}
	public boolean viewDoctorsBySpecialization(String specialization) {

	    boolean found = false;
	    System.out.println("\nAvailable Doctors:");
        System.out.println("DOCTOR_ID"+"\t"+"DOCTOR_NAME"+"\t"+"SPECIALIZATION");
        System.out.println("==================================================================================");
	    for (Doctor doctor : doctors.values()) {

	        if (doctor.getSpecialization().equalsIgnoreCase(specialization)) {

	            System.out.println( doctor.getDoctorId() + " \t\t " +doctor.getDoctorName() + " \t\t " +doctor.getSpecialization());
	            found = true;
	        }
	    } System.out.println("==================================================================================");
	    if (!found) {
	        System.out.println("No doctors found for this specialization!");
	    }

	    return found;
	}

}
