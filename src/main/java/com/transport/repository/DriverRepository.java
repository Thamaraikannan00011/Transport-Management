package com.transport.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.transport.entity.Driver;

@Repository
public interface DriverRepository extends JpaRepository<Driver, Long>{
	
	@Query("SELECT d FROM Driver d WHERE d.status = AVAILABLE")
	public List<Driver> getAvailableDrivers();

}
