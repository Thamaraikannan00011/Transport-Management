package com.transport.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.transport.dao.TripDAO;
import com.transport.dto.ResponseStructure;
import com.transport.entity.Trip;
import com.transport.exception.IdNotFoundException;
import com.transport.exception.NoRecordFoundException;

@Service
public class TripService {
	
	@Autowired
	private TripDAO dao;
	
	public ResponseEntity<ResponseStructure<Trip>> createTrip(Trip trip) {
		ResponseStructure<Trip> res = new ResponseStructure<Trip>();
		Trip t = dao.createTrip(trip);
		res.setStatus(HttpStatus.CREATED.value());
		res.setMessage("Scheduled new trip");
		res.setData(t);
		return new ResponseEntity<ResponseStructure<Trip>>(res, HttpStatus.CREATED);
	}
	
	public ResponseEntity<ResponseStructure<List<Trip>>> getAllTrips(){
		ResponseStructure<List<Trip>> res = new ResponseStructure<List<Trip>>();
		List<Trip> li = dao.getAllTrips();
		if(!li.isEmpty()) {
			res.setStatus(HttpStatus.OK.value());
			res.setMessage("Retrieved all trips");
			res.setData(li);
			return new ResponseEntity<ResponseStructure<List<Trip>>>(res, HttpStatus.OK);
		}
		else {
			throw new NoRecordFoundException("No record found in database");
		}
	}
	
	public ResponseEntity<ResponseStructure<Trip>> getTripById(Long id) {
		ResponseStructure<Trip> res = new ResponseStructure<Trip>();
		Optional<Trip> opt = dao.getTripById(id);
		if(opt.isPresent()) {
			res.setStatus(HttpStatus.OK.value());
			res.setMessage("Got specific trip by id");
			res.setData(opt.get());
			return new ResponseEntity<ResponseStructure<Trip>>(res, HttpStatus.OK);
		}
		else {
			throw new IdNotFoundException("No id found in database");
		}
	}
	
	public ResponseEntity<ResponseStructure<Trip>> updateTrip(Trip trip) {
		ResponseStructure<Trip> res = new ResponseStructure<Trip>();
		Trip t = dao.updateTrip(trip);
		res.setStatus(HttpStatus.OK.value());
		res.setMessage("Updated trip details");
		res.setData(t);
		return new ResponseEntity<ResponseStructure<Trip>>(res, HttpStatus.OK);
	}
	
	public ResponseEntity<ResponseStructure<String>> cancelTrip(Long id) {
		ResponseStructure<String> res = new ResponseStructure<String>();
		Optional<Trip> opt = dao.getTripById(id);
		if(opt.isPresent()) {
			dao.cancelTrip(id);
			res.setStatus(HttpStatus.NO_CONTENT.value());
			res.setMessage("Canceled scheduled trip");
			res.setData(null);
			return new ResponseEntity<ResponseStructure<String>>(res, HttpStatus.NO_CONTENT);
		}
		else {
			throw new IdNotFoundException("No id matching with record");
		}
	}
	
}
