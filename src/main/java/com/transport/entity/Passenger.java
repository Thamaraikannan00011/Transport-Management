package com.transport.entity;

import com.transport.enumeration.Gender;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Passenger {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Passenger Id", nullable = false, unique = true)
	private Long passengerId;
	@Column(name = "First Name", nullable = false)
	private String firstName;
	@Column(name = "Last Name", nullable = false)
	private String lastName;
	@Column(name = "Gender", nullable = false)
	private Gender gender;
	@Column(name = "Age", nullable = false)
	private Integer age;
	@Column(name = "Email", nullable = false, unique = true)
	private String email;
	@Column(name = "Phone Number", nullable = false, unique = true)
	private String phoneNumber;
	
	public Long getPassengerId() {
		return passengerId;
	}
	public void setPassengerId(Long passengerId) {
		this.passengerId = passengerId;
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
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	@Override
	public String toString() {
		return "{\n\tPassenger Id : " + passengerId + ",\n\tFirst Name : " + firstName + ",\n\tLast Name : " + lastName
				+ ",\n\tGender : " + gender + ",\n\tAge : " + age + ",\n\tEmail : " + email + ",\n\tPhone Number : " + phoneNumber + "\n}";
	}
}
