package com.transport.entity;

import java.time.LocalDate;

import com.transport.enumeration.BookingStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Booking {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Booking Id", nullable = false, unique = true)
	private Long bookingId;
	@Column(name = "Booking Date", nullable = false)
	private LocalDate bookingDate;
	@Column(name = "Booking Status", nullable = false)
	private BookingStatus status;
	
	public Long getBookingId() {
		return bookingId;
	}
	public void setBookingId(Long bookingId) {
		this.bookingId = bookingId;
	}
	public LocalDate getBookingDate() {
		return bookingDate;
	}
	public void setBookingDate(LocalDate bookingDate) {
		this.bookingDate = bookingDate;
	}
	public BookingStatus getStatus() {
		return status;
	}
	public void setStatus(BookingStatus status) {
		this.status = status;
	}
	
	@Override
	public String toString() {
		return "{\n\tBooking Id : " + bookingId + ",\n\tBooking Date : " + bookingDate 
						+ ",\n\tBooking Status : " + status + "\n}";
	}
}
