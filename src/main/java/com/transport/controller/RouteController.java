package com.transport.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.transport.dto.ResponseStructure;
import com.transport.entity.Route;
import com.transport.service.RouteService;

@RestController
@RequestMapping("/route")
public class RouteController {
	
	@Autowired
	private RouteService ser;
	
	@PostMapping
	public ResponseEntity<ResponseStructure<Route>> createRoute(@RequestBody Route route) {
		return ser.createRoute(route);
	}
	
	@GetMapping
	public ResponseEntity<ResponseStructure<List<Route>>> getAllRoutes(){
		return ser.getAllRoutes();
	}

	@GetMapping("/{id}")
	public ResponseEntity<ResponseStructure<Route>> getRouteById(@PathVariable Long id){
		return ser.getRouteById(id);
	}
	
	@PutMapping
	public ResponseEntity<ResponseStructure<Route>> updateRoute(@RequestBody Route route) {
		return ser.updateRoute(route);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<ResponseStructure<String>> deleteRoute(@PathVariable Long id) {
		return ser.deleteRoute(id);
	}
}
