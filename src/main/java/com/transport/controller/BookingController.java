package com.transport.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.transport.dto.ResponseStructure;
import com.transport.entity.Booking;
import com.transport.service.BookingService;

@RestController
@RequestMapping("/booking")
public class BookingController {

	@Autowired
	private BookingService ser;
	
	@PostMapping
	public ResponseEntity<ResponseStructure<Booking>> createBooking(@RequestBody Booking booking){
		return ser.createBooking(booking);
	}
	
	@GetMapping
	public ResponseEntity<ResponseStructure<List<Booking>>> getAllBookings(){
		return ser.getAllBookings();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ResponseStructure<Booking>> getBookingById(@PathVariable Long id){
		return ser.getBookingById(id);
	}
	
	@PutMapping
	public ResponseEntity<ResponseStructure<Booking>> updateBooking(@RequestBody Booking booking){
		return ser.updateBooking(booking);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<ResponseStructure<String>> cancelBooking(@PathVariable Long id){
		return ser.cancelBooking(id);
	}
	
}
