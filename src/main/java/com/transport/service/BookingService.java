package com.transport.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.transport.dao.BookingDAO;
import com.transport.dto.ResponseStructure;
import com.transport.entity.Booking;
import com.transport.exception.IdNotFoundException;
import com.transport.exception.NoRecordFoundException;

@Service
public class BookingService {
	
	@Autowired
	private BookingDAO dao;
	
	public ResponseEntity<ResponseStructure<Booking>> createBooking(Booking booking){
		Booking b = dao.createBooking(booking);
		ResponseStructure<Booking> res = new ResponseStructure<Booking>();
		res.setStatus(HttpStatus.CREATED.value());
		res.setMessage("Booking successfull");
		res.setData(b);
		return new ResponseEntity<ResponseStructure<Booking>>(res, HttpStatus.CREATED);
	}
	
	public ResponseEntity<ResponseStructure<List<Booking>>> getAllBookings(){
		List<Booking> li = dao.getAllBookings();
		ResponseStructure<List<Booking>> res = new ResponseStructure<List<Booking>>();
		if(!li.isEmpty()) {
			res.setStatus(HttpStatus.OK.value());
			res.setMessage("Fetched all booking");
			res.setData(li);
			return new ResponseEntity<ResponseStructure<List<Booking>>>(res, HttpStatus.OK);
		}
		else {
			throw new NoRecordFoundException("No record found in database");
		}
	}
	
	public ResponseEntity<ResponseStructure<Booking>> getBookingById(Long id){
		Optional<Booking> opt = dao.getBookingById(id);
		ResponseStructure<Booking> res = new ResponseStructure<Booking>();
		if(opt.isPresent()) {
			res.setStatus(HttpStatus.OK.value());
			res.setMessage("Record fetched by Id");
			res.setData(opt.get());
			return new ResponseEntity<ResponseStructure<Booking>>(res, HttpStatus.OK);
		}
		else{
			throw new IdNotFoundException("No record found by id");
		}
	}
	
	public ResponseEntity<ResponseStructure<Booking>> updateBooking(Booking booking){
		Booking b = dao.updateBooking(booking);
		ResponseStructure<Booking> res = new ResponseStructure<Booking>();
		res.setStatus(HttpStatus.OK.value());
		res.setMessage("Booking updated successfull");
		res.setData(b);
		return new ResponseEntity<ResponseStructure<Booking>>(res, HttpStatus.OK);
	}
	
	public ResponseEntity<ResponseStructure<String>> cancelBooking(Long id){
		Optional<Booking> opt = dao.getBookingById(id);
		ResponseStructure<String> res = new ResponseStructure<String>();
		if(opt.isPresent()) {
			res.setStatus(HttpStatus.ACCEPTED.value());
			res.setMessage("Booking cancelled");
			res.setData("Booking deleted");
			return new ResponseEntity<ResponseStructure<String>>(res, HttpStatus.ACCEPTED);
		}
		else{
			throw new IdNotFoundException("No record found by id");
		}
	}
	

}
