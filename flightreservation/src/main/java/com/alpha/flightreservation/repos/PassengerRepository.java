package com.alpha.flightreservation.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alpha.flightreservation.entities.Passenger;

public interface PassengerRepository extends JpaRepository<Passenger, Long> {

}
