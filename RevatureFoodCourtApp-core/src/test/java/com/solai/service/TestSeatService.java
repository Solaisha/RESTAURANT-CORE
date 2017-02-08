package com.solai.service;

import com.solai.exception.SeatServiceException;
import com.solai.model.Seat;

public class TestSeatService {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SeatService seatService=new SeatService();
		Seat seat=new Seat();
		seat.setSeatId(11);
		seat.setSeatNumber("A11");
		seat.setSeatAvailability("Empty Seat");
		try {
			seatService.saveService(seat);
		} catch (SeatServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
