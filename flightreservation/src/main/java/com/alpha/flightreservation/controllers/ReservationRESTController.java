package com.alpha.flightreservation.controllers;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alpha.flightreservation.dto.ReservationUpdateRequest;
import com.alpha.flightreservation.entities.Reservation;
import com.alpha.flightreservation.repos.ReservationRepository;

@RestController
@CrossOrigin
public class ReservationRESTController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ReservationRESTController.class);
	
	@Autowired
	ReservationRepository reservationRepository;
	
	@RequestMapping("/reservations/{id}")
	public Reservation findReservation(@PathVariable("id") Long id) {
		LOGGER.info("Inside the findReservation() for id" + id);
		return reservationRepository.findById(id).get();
	}
	
	@RequestMapping("/reservations")
	public Reservation updateReservation(@RequestBody ReservationUpdateRequest request) {
		LOGGER.info("Inside the updateReservation() for " + request);
		Reservation reservation = reservationRepository.findById(request.getId()).get();
		reservation.setNumberOfBags(request.getNumberOfBags());
		reservation.setChekedIn(request.getCheckedIn());
		LOGGER.info("Saving Reservation!");
		return reservationRepository.save(reservation);
	}

}
