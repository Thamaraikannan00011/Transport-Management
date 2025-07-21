package com.transport.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.transport.entity.Trip;

@Repository
public interface TripRepository extends JpaRepository<Trip, Long>{

}
