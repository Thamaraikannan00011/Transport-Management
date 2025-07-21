package com.transport.entity;

import com.transport.enumeration.DriverStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Driver {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Driver Id", nullable = false, unique = true)
	private Long driverId;
	@Column(name = "First Name", nullable = false)
	private String firstName;
	@Column(name = "Last Name", nullable = false)
	private String lastName;
	@Column(name = "License Number", nullable = false, unique = true)
	private String licenseNumber;
	@Column(name = "Phone Number", nullable = false, unique = true)
	private String phoneNumber;
	@Column(name = "Email", nullable = false, unique = true)
	private String email;
	@Column(name = "Driver Status", nullable = false)
	private DriverStatus status;
	
	public Long getDriverId() {
		return driverId;
	}
	public void setDriverId(Long driverId) {
		this.driverId = driverId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getLicenseNumber() {
		return licenseNumber;
	}
	public void setLicenseNumber(String licenseNumber) {
		this.licenseNumber = licenseNumber;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public DriverStatus getStatus() {
		return status;
	}
	public void setStatus(DriverStatus status) {
		this.status = status;
	}
	
	@Override
	public String toString() {
		return "{\n\tDriver Id : " + driverId + ",\n\tFirst Name : " + firstName + ",\n\tLast Name : " + lastName
				+ ",\n\tLicense Number : " + licenseNumber + ",\n\tPhone Number : " + phoneNumber + ",\n\tEmail : " + email 
				+ ",\n\tDriver Status : "+ status + "\n}";
	}
}
