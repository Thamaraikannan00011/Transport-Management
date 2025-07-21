package com.transport.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.transport.entity.Driver;
import com.transport.repository.DriverRepository;

@Repository
public class DriverDAO {
	
	@Autowired
	private DriverRepository repository;
	
	public Driver createDriver(Driver driver) {
		return repository.save(driver);
	}
	
	public List<Driver> getAllDrivers(){
		return repository.findAll();
	}
	
	public Optional<Driver> getDriverById(Long id){
		return repository.findById(id);
	}
	
	public Driver updateDriver(Driver driver) {
		return repository.save(driver);
	}
	
	public void deleteDriver(Long id) {
		repository.deleteById(id);
	}
	
	public List<Driver> getAvailableDrivers(){
		return repository.getAvailableDrivers();
	}

}
