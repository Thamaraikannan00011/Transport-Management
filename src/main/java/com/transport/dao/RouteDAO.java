package com.transport.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.transport.entity.Route;
import com.transport.repository.RouteRepository;

@Repository
public class RouteDAO {
	
	@Autowired
	private RouteRepository rep;
	
	public Route createRoute(Route route) {
		return rep.save(route);
	}
	
	public List<Route> getAllRoutes(){
		return rep.findAll();
	}
	
	public Optional<Route> getRouteById(Long id){
		return rep.findById(id);
	}
	
	public Route updateRoute(Route route) {
		return rep.save(route);
	}
	
	public void deleteRoute(Long id) {
		rep.deleteById(id);
	}

}
