package com.project.back_end.models;

import java.time.LocalDate; 
import java.time.LocalDateTime;
import java.time.LocalTime;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Transient;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;

@Entity
public class Appointment {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
    @JsonBackReference("appointment-doctor")
    @JoinColumn(name = "doctor_id")
	@NotNull(message="select a doctor")
	private Doctor doctor;

	@ManyToOne
	@NotNull(message="patient could not be null")
    @JsonBackReference("appointment-patient")
    @JoinColumn(name = "patient_id")
	private Patient patient;

    // Use named constants to make integer status values more readable.
    public static final int SCHEDULED = 0;
    public static final int COMPLETED = 1;
	@NotNull(message="status cannot be empty")
    //0 for Scheduled, 1 for Completed) (required)
	private int status;

	@Future(message = "Appointment time must be in the future")
	private LocalDateTime appointmentTime;
	
    //helper methods

	@Transient
	private LocalDateTime getEndTime() {
	 return appointmentTime.plusHours(1);	
	}

    @Transient
	private LocalDate getAppointmentDate() {
		return appointmentTime.toLocalDate();
	}

    @Transient
	private LocalTime getAppointmentTimeOnly() {
		return appointmentTime.toLocalTime();
	}

    //Constructors

	public Appointment() {
		
	}
	public Appointment(long id, Doctor doctor, Patient patient, int status, LocalDateTime appointmentTime) {
		this.id = id;
		this.doctor = doctor;
		this.patient = patient;
		this.status = SCHEDULED;
		this.appointmentTime = appointmentTime;
	}

    //getters & Setters

	public long getId() {
		return id;
	}
	public Doctor getDoctor() {
		return doctor;
	}
	public Patient getPatient() {
		return patient;
	}
	public int getStatus() {
		return status;
	}
	public LocalDateTime getAppointmentTime() {
		return appointmentTime;
	}
	public void setId(long id) {
		this.id = id;
	}
	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	public void setStatus(int status) {
        if (status != SCHEDULED && status != COMPLETED) {
            throw new IllegalArgumentException("Invalid status value. Use 0 for Scheduled or 1 for Completed.");
        }
        this.status = status;
    }

	public void setAppointmentTime(LocalDateTime appointmentTime) {
		this.appointmentTime = appointmentTime;
	}

	
}

