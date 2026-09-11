package com.HospitalManagement;

import java.time.LocalDateTime;

public class Appointment {
	
	   private String appointmentId;
	    private Patient patient;
	    private Doctor doctor;
	    private LocalDateTime appointmentDateTime;
	    private String status;
	    private double consultationFee;
	    public Appointment(String appointmentId, Patient patient, Doctor doctor, LocalDateTime appointmentDateTime, String status,double consultationFee)
	    {
                this.appointmentId = appointmentId;
                this.patient = patient;
                this.doctor = doctor;
                this.appointmentDateTime = appointmentDateTime;
                this.status = status;
                this.consultationFee=consultationFee;
}

public String getAppointmentId() {
 return appointmentId;
}

public Patient getPatient() {
 return patient;
}

public Doctor getDoctor() {
 return doctor;
}

public LocalDateTime getAppointmentDateTime() {
 return appointmentDateTime;
}

public String getStatus() {
 return status;
}

public void setStatus(String status) {
 this.status = status;
}
}


