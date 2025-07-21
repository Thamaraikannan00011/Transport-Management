package com.transport.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.transport.entity.Booking;
import com.transport.repository.BookingRepository;

@Repository
public class BookingDAO {
	
	@Autowired
	private BookingRepository repo;
	
	public Booking createBooking(Booking booking) {
		return repo.save(booking);
	}
	
	public List<Booking> getAllBookings(){
		return repo.findAll();
	}
	
	public Optional<Booking> getBookingById(Long id) {
		return repo.findById(id);
	}
	
	public Booking updateBooking(Booking booking) {
		return repo.save(booking);
	}
	
	public void cancelBooking(Long id) {
		repo.deleteById(id);
	}
	
}
