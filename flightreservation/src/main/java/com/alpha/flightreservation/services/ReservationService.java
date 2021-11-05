package com.alpha.flightreservation.services;

import com.alpha.flightreservation.dto.ReservationRequest;
import com.alpha.flightreservation.entities.Reservation;

public interface ReservationService {
	
	public Reservation bookFlight(ReservationRequest request);
	
}
