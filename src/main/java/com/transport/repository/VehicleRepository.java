package com.transport.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.transport.entity.Vehicle;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long>{

//	@Query("SELECT v FROM Vehicle v WHERE v.status = AVAILABLE;")
//	public List<Vehicle> getAvailableVehicles();
//	
//	@Query("SELECT v FROM Vehicle v WHERE v.status = ?1")
//	public Vehicle updateVehicleStatus(VehicleStatus status);
//	
//	public List<Vehicle> findByVehicleType(VehicleType type);
//	
//	public List<Vehicle> findByCapacity(Integer capacity);
//	
//	public List<Vehicle> findByStatus(VehicleStatus status);
//	
//	@Query("SELECT v FROM Vehicle v WHERE v.status NOT LIKE MAINTENANCE")
//	public List<Vehicle> findVehiclesNotInMaintenance(VehicleStatus status);
//	
//	public List<Vehicle> findByModel(Vehicle model); 
//	
//	@Query("SELECT count(v) FROM Vehicle v WHERE v.")
//	public Vehicle findVehiclesWithMostTrips();
//	
	
}