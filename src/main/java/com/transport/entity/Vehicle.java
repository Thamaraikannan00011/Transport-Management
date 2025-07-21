package com.transport.entity;

import com.transport.enumeration.VehicleStatus;
import com.transport.enumeration.VehicleType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Vehicle {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Vehicle Id", unique = true, nullable = false)
	private Long vehicleId;
	@Column(name = "Vehicle Model", nullable = false)
	private String model;
	@Column(name = "Vehicle Capacity", nullable = false)
	private Integer capacity;
	@Column(name = "Vehicle Type", nullable = false) 
	private VehicleType type;
	@Column(name = "Vehicle Status", nullable = false)
	private VehicleStatus status;
	
	public Long getVehicleId() {
		return vehicleId;
	}
	public void setVehicleId(Long vehicleId) {
		this.vehicleId = vehicleId;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public Integer getCapacity() {
		return capacity;
	}
	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}
	public VehicleType getType() {
		return type;
	}
	public void setType(VehicleType type) {
		this.type = type;
	}
	public VehicleStatus getStatus() {
		return status;
	}
	public void setStatus(VehicleStatus status) {
		this.status = status;
	}
	
	@Override
	public String toString() {
		return "{\n\tVehicleId : " + vehicleId + ",\n\tModel : " + model + ",\n\tCapacity : " + capacity + ",\n\tVehicle Type : " + type
				+ ",\n\tVehicle Status : " + status + "\n}";
	}
}
