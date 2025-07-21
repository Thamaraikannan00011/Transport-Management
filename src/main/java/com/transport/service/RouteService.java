package com.transport.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.transport.dao.RouteDAO;
import com.transport.dto.ResponseStructure;
import com.transport.entity.Route;
import com.transport.exception.IdNotFoundException;
import com.transport.exception.NoRecordFoundException;

@Service
public class RouteService {
	
	@Autowired
	private RouteDAO dao;
	
	public ResponseEntity<ResponseStructure<Route>> createRoute(Route route) {
		ResponseStructure<Route> res = new ResponseStructure<Route>();
		Route r = dao.createRoute(route);
		res.setStatus(HttpStatus.CREATED.value());
		res.setMessage("Added new route");
		res.setData(r);
		return new ResponseEntity<ResponseStructure<Route>>(res, HttpStatus.CREATED);
	}
	
	public ResponseEntity<ResponseStructure<List<Route>>> getAllRoutes(){
		ResponseStructure<List<Route>> res = new ResponseStructure<List<Route>>();
		List<Route> li = dao.getAllRoutes();
		if(!li.isEmpty()) {
			res.setStatus(HttpStatus.OK.value());
			res.setMessage("Retrieved all routes");
			res.setData(li);
			return new ResponseEntity<ResponseStructure<List<Route>>>(res, HttpStatus.OK);
		}
		else {
			throw new NoRecordFoundException("No record found in database");
		}
	}
	
	public ResponseEntity<ResponseStructure<Route>> getRouteById(Long id){
		ResponseStructure<Route> res = new ResponseStructure<Route>();
		Optional<Route> opt = dao.getRouteById(id);
		if(opt.isPresent()) {
			res.setStatus(HttpStatus.OK.value());
			res.setMessage("Get specific route by ID");
			res.setData(opt.get());
			return new ResponseEntity<ResponseStructure<Route>>(res, HttpStatus.OK);
		}
		else {
			throw new IdNotFoundException("No record found by given id");
		}
	}
	
	public ResponseEntity<ResponseStructure<Route>> updateRoute(Route route) {
		ResponseStructure<Route> res = new ResponseStructure<Route>();
		Route r = dao.updateRoute(route);
		res.setStatus(HttpStatus.OK.value());
		res.setMessage("Updated route details");
		res.setData(r);
		return new ResponseEntity<ResponseStructure<Route>>(res, HttpStatus.OK);
	}
	
	public ResponseEntity<ResponseStructure<String>> deleteRoute(Long id) {
		ResponseStructure<String> res = new ResponseStructure<String>();
		Optional<Route> opt = dao.getRouteById(id);
		if(opt.isPresent()) {
			dao.deleteRoute(id);
			res.setStatus(HttpStatus.NO_CONTENT.value());
			res.setMessage("Removed route from database");
			res.setData("Deleted");
			return new ResponseEntity<ResponseStructure<String>>(res, HttpStatus.NO_CONTENT);
		}
		else {
			throw new IdNotFoundException("No id found to remove");
		}
	}
	
}
