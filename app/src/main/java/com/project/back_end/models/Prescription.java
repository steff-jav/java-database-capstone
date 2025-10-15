package com.project.back_end.models;

import org.springframework.data.mongodb.core.mapping.Document;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.NotNull;


@Document
public class Prescription {

	@Id
	private String id;
	
	@NotNull(message="patient name could not be null")
	@Size(min=3,max=100)
	private String patientName;
	
	@NotNull(message="appointmentId could not be null")
	private Long appointmentId;
	
	@NotNull(message =" medication could not be empty")
	@Size(min=3,max=100)
	private String medication;
	
	@NotNull(message =" dosage could not be empty")
	private String dosage;
	
	@Size(max=200)
	private String doctorNotes;
	
	public Prescription() {
	}
	
	public Prescription(String patientName, Long appointmentId, String medication, String dosage, String doctorNotes) {
		this.patientName = patientName;
		this.appointmentId = appointmentId;
		this.medication = medication;
		this.dosage = dosage;
		this.doctorNotes = doctorNotes;
	}
	public String getId() {
		return id;
	}
	public String getPatientName() {
		return patientName;
	}
	public Long getAppointmentId() {
		return appointmentId;
	}
	public String getMedication() {
		return medication;
	}
	public String getDosage() {
		return dosage;
	}
	public String getDoctorNotes() {
		return doctorNotes;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	public void setAppointmentId(Long appointmentId) {
		this.appointmentId = appointmentId;
	}
	public void setMedication(String medication) {
		this.medication = medication;
	}
	public void setDosage(String dosage) {
		this.dosage = dosage;
	}
	public void setDoctorNotes(String doctorNotes) {
		this.doctorNotes = doctorNotes;
	}
	

}
