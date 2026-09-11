package com.HospitalManagement;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Doctor {
	private int doctorId;
    private String doctorName;
    private String specialization;
    private ArrayList<LocalDateTime> availableSlots;

    public Doctor(int doctorId, String doctorName, String specialization) 
    {
        this.doctorId = doctorId;
        this.doctorName = doctorName;
        this.specialization = specialization;
        this.availableSlots = new ArrayList<>();
    }
    
    public void addSlot(LocalDateTime slot) {
        availableSlots.add(slot);
    }
    
    public int getDoctorId() {
    	return doctorId;
    }
    public String getDoctorName() {
    	return doctorName;
    }
    public String getSpecialization() {
    	return specialization;
    }
    public ArrayList<LocalDateTime>getAvailableSlots()
    {
    	return availableSlots;
    }
    public static ArrayList<Doctor> getDefaultDoctors() {

        ArrayList<Doctor> doctors = new ArrayList<>();

        Doctor d1 = new Doctor(201, "Dr. Kumar", "Cardiologist");
        Doctor d2 = new Doctor(202, "Dr. Anitha", "Dermatologist");
        Doctor d3 = new Doctor(203, "Dr. Ravi", "General Physician");
        Doctor d4 = new Doctor(204, "Dr. Praveen", "Gastroenterologist");
        Doctor d5 = new Doctor(205, "Dr. Suji", "Neurologist");
        Doctor d6 = new Doctor(206, "Dr. Pavi", "General Surgeon");
        Doctor d7 = new Doctor(207, "Dr. Hari", "Infectious Disease Specialist");
        Doctor d8 = new Doctor(208, "Dr. Harshi", "Anesthesiologist");
        Doctor d9 = new Doctor(209, "Dr. Diya", "Psychiatrist");

         //d1 time slot
        d1.addSlot(LocalDateTime.of(2026, 9, 15, 10, 0));
        d1.addSlot(LocalDateTime.of(2026, 9, 15, 11, 0));
        d1.addSlot(LocalDateTime.of(2026, 9, 15, 15, 0));
         //d2.time slot
        d2.addSlot(LocalDateTime.of(2026, 9, 15, 9, 30));
        d2.addSlot(LocalDateTime.of(2026, 9, 15, 14, 0));
        //d3 time slot
        d3.addSlot(LocalDateTime.of(2026, 9, 15, 10, 30));
        d3.addSlot(LocalDateTime.of(2026, 9, 15, 16, 0));
        d3.addSlot(LocalDateTime.of(2026, 9, 15, 12, 0));
        
        d4.addSlot(LocalDateTime.of(2026, 9, 15, 9, 30));
        d4.addSlot(LocalDateTime.of(2026, 9, 15, 10, 0));
        d4.addSlot(LocalDateTime.of(2026, 9, 15, 15, 0));
        
        d5.addSlot(LocalDateTime.of(2026, 9, 15, 7, 0));
        d5.addSlot(LocalDateTime.of(2026, 9, 15, 9, 0));
        d5.addSlot(LocalDateTime.of(2026, 9, 15, 13, 0));
        
        d6.addSlot(LocalDateTime.of(2026, 9, 15, 8, 30));
        d6.addSlot(LocalDateTime.of(2026, 9, 15, 9, 0));
        
        d7.addSlot(LocalDateTime.of(2026, 9, 15, 10, 30));
        d7.addSlot(LocalDateTime.of(2026, 9, 15, 11, 30));
        d7.addSlot(LocalDateTime.of(2026, 9, 15, 12, 0));
        
        d8.addSlot(LocalDateTime.of(2026, 9, 15, 11, 30));
        d8.addSlot(LocalDateTime.of(2026, 9, 15, 14, 0));
        
        d9.addSlot(LocalDateTime.of(2026, 9, 15, 14, 0));
        d9.addSlot(LocalDateTime.of(2026, 9, 15, 14, 30));
        d9.addSlot(LocalDateTime.of(2026, 9, 15, 15, 0));


        doctors.add(d1);
        doctors.add(d2);
        doctors.add(d3);
        doctors.add(d4);
        doctors.add(d5);
        doctors.add(d6);
        doctors.add(d7);
        doctors.add(d8);
        doctors.add(d9);

        return doctors;
    }
}
