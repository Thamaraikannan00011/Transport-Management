package com.transport.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Route {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Route Id", nullable = false, unique = true)
	private Long routeId;
	@Column(name = "Starting Designation", nullable = false)
	private String startDestination;
	@Column(name = "End Destination", nullable = false)
	private String endDestionation;
	@Column(name = "Distance", nullable = false)
	private Double distance;
	
	public Long getRouteId() {
		return routeId;
	}
	public void setRouteId(Long routeId) {
		this.routeId = routeId;
	}
	public String getStartDestination() {
		return startDestination;
	}
	public void setStartDestination(String startDestination) {
		this.startDestination = startDestination;
	}
	public String getEndDestionation() {
		return endDestionation;
	}
	public void setEndDestionation(String endDestionation) {
		this.endDestionation = endDestionation;
	}
	public Double getDistance() {
		return distance;
	}
	public void setDistance(Double distance) {
		this.distance = distance;
	}
	
	@Override
	public String toString() {
		return "{\n\tRouteId : " + routeId + ",\n\tStart Destination : " + startDestination + ",\n\tEnd Destionation : "
				+ endDestionation + ",\n\tDistance : " + distance + "\n}";
	}
}
	