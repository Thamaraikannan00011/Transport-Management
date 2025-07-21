package com.transport.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.transport.entity.Trip;
import com.transport.repository.TripRepository;

@Repository
public class TripDAO {

	@Autowired
	private TripRepository rep;
	
	public Trip createTrip(Trip trip) {
		return rep.save(trip);
	}
	
	public List<Trip> getAllTrips(){
		return rep.findAll();
	}
	
	public Optional<Trip> getTripById(Long id) {
		return rep.findById(id);
	}
	
	public Trip updateTrip(Trip trip) {
		return rep.save(trip);
	}
	
	public void cancelTrip(Long id) {
		rep.deleteById(id);
	}
	
}
