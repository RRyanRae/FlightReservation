package com.alpha.flightcheckin.integration;

import com.alpha.flightcheckin.integration.dto.Reservation;
import com.alpha.flightcheckin.integration.dto.ReservationUpdateRequest;

public interface ReservationRestClient {

	public Reservation findReservation(Long id);
	
	public Reservation updateReservation(ReservationUpdateRequest request);
	
}
