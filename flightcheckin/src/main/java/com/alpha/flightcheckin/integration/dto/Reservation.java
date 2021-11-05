package com.alpha.flightcheckin.integration.dto;

public class Reservation {

	private Long id;
	private Boolean checkedIn;
	private int numberOfBags;
	private Passenger passenger;
	private Flight flight;

	public Boolean getCheckedIn() {
		return checkedIn;
	}

	public void setChekedIn(Boolean chekedIn) {
		this.checkedIn = chekedIn;
	}

	public int getNumberOfBags() {
		return numberOfBags;
	}

	public void setNumberOfBags(int numberOfBags) {
		this.numberOfBags = numberOfBags;
	}

	public Passenger getPassenger() {
		return passenger;
	}

	public void setPassenger(Passenger passenger) {
		this.passenger = passenger;
	}

	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
