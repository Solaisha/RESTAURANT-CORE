package com.solai.validator;

import com.solai.model.Seat;

public class TestSeatValidator {

	public static void main(String[] args) 
	{
		Seat seat=new Seat();
		SeatValidator seatValidator=new SeatValidator();
		
		
		seat.setSeatNumber("");
		try {
			seatValidator.validateSeat(seat);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

}
