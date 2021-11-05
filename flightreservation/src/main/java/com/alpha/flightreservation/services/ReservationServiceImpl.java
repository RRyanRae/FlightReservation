package com.alpha.flightreservation.services;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.alpha.flightreservation.dto.ReservationRequest;
import com.alpha.flightreservation.entities.Flight;
import com.alpha.flightreservation.entities.Passenger;
import com.alpha.flightreservation.entities.Reservation;
import com.alpha.flightreservation.repos.FlightRepository;
import com.alpha.flightreservation.repos.PassengerRepository;
import com.alpha.flightreservation.repos.ReservationRepository;
import com.alpha.flightreservation.util.EmailUtil;
import com.alpha.flightreservation.util.PDFGenerator;

@Service
@Transactional
public class ReservationServiceImpl implements ReservationService {
	
	@Value("${com.alpha.flightReservation.itinerary.dirpath}")
	private String ITINERARY_DIR;
	@Autowired
	FlightRepository flightRepository;
	@Autowired
	PassengerRepository passengerRepository;
	@Autowired
	ReservationRepository reservationRepository;
	@Autowired
	PDFGenerator pdfGenerator;
	@Autowired
	EmailUtil emailUtil;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ReservationServiceImpl.class);
	
	@Override
	public Reservation bookFlight(ReservationRequest request) {
		
		LOGGER.info("Inside bookFlight()");
		
		Long flightId = request.getFlightId();
		LOGGER.info("Fetching Flight for flight Id: " + flightId);
		Flight flight = flightRepository.findById(flightId).get();
		
		Passenger passenger = new Passenger();
		passenger.setFirstName(request.getPassengerFirstName());
		passenger.setLastName(request.getPassengerLastName());
		passenger.setPhone(request.getPassengerPhone());
		passenger.setEmail(request.getPassengerEmail());
		LOGGER.info("Saving the Passenger: " + passenger);
		Passenger savedPassenger = passengerRepository.save(passenger);
		
		Reservation reservation = new Reservation();
		reservation.setFlight(flight);
		reservation.setPassenger(savedPassenger);
		reservation.setChekedIn(false);
		
		LOGGER.info("Saving the reservation: " + reservation);
		Reservation savedReservation = reservationRepository.save(reservation);
		
		String filePath = ITINERARY_DIR+savedReservation.getId() + ".pdf";
		LOGGER.info("Generating the Itinerary");
		pdfGenerator.genrateItinerary(savedReservation, filePath);
		LOGGER.info("Sending the Itinerary via Email");
		emailUtil.sendItenerary(passenger.getEmail(), filePath);
		
		
		return savedReservation;
	}

}
