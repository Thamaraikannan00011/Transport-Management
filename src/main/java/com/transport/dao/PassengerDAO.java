package com.transport.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.transport.entity.Passenger;
import com.transport.repository.PassengerRepository;

@Repository
public class PassengerDAO {
	
	@Autowired
	private PassengerRepository rep;
	
	public Passenger createPassenger(Passenger passenger) {
		return rep.save(passenger);
	}
	
	public List<Passenger> getAllPassengers(){
		return rep.findAll();
	}
	
	public Optional<Passenger> getPassengerById(Long id) {
		return rep.findById(id);
	}
	
	public Passenger updatePassenger(Passenger passenger) {
		return rep.save(passenger);
	}
	
	public void deletePassenger(Long id) {
		rep.deleteById(id);
	}
}
