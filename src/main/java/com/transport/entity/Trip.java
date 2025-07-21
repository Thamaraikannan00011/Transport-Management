package com.transport.entity;

import java.time.LocalDate;
import java.time.LocalTime;

import com.transport.enumeration.TripType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Trip {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Trip Id", nullable = false, unique = true)
	private Long tripId;
	@Column(name = "Departure Date", nullable = false)
	private LocalDate departureDate;// YYYY-MM-DD
	@Column(name = "Departure Time", nullable = false)
	private LocalTime departureTime;// HH:MM:SS
	@Column(name = "Arrival Date", nullable = false)
	private LocalDate arrivalDate;
	@Column(name = "Arrival Time", nullable = false)
	private LocalTime arrivalTime;
	@Column(name = "Trip Type", nullable = false)
	private TripType tripType;
	@Column(name = "Max Passengers", nullable = false)
	private Integer maxPassengers;
	
	public Long getTripId() {
		return tripId;
	}
	public void setTripId(Long tripId) {
		this.tripId = tripId;
	}
	public LocalDate getDepartureDate() {
		return departureDate;
	}
	public void setDepartureDate(LocalDate departureDate) {
		this.departureDate = departureDate;
	}
	public LocalTime getDepartureTime() {
		return departureTime;
	}
	public void setDepartureTime(LocalTime departureTime) {
		this.departureTime = departureTime;
	}
	public LocalDate getArrivalDate() {
		return arrivalDate;
	}
	public void setArrivalDate(LocalDate arrivalDate) {
		this.arrivalDate = arrivalDate;
	}
	public LocalTime getArrivalTime() {
		return arrivalTime;
	}
	public void setArrivalTime(LocalTime arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	public TripType getTripType() {
		return tripType;
	}
	public void setTripType(TripType tripType) {
		this.tripType = tripType;
	}
	public Integer getMaxPassengers() {
		return maxPassengers;
	}
	public void setMaxPassengers(Integer maxPassengers) {
		this.maxPassengers = maxPassengers;
	}
	
	@Override
	public String toString() {
		return "{\n\tTrip Id : " + tripId + ",\n\tDeparture Date : " + departureDate + ",\n\tDeparture Time : " + departureTime
				+ ",\n\tArrival Date : " + arrivalDate + ",\n\tArrival Time : " + arrivalTime + ",\n\tTrip Type : " + tripType
				+ ",\n\tMax Passengers : " + maxPassengers + "\n}";
	}
}
