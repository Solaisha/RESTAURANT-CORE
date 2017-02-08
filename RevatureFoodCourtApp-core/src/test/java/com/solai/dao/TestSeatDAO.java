package com.solai.dao;

import java.util.List;

import com.solai.model.Seat;

public class TestSeatDAO {

	public static void main(String[] args) {

//		Seat seat=new Seat();
//		seat.setSeatId(11);
//		seat.setSeatNumber("A11");
//		seat.setSeatAvailability("Empty Seat");
//		
SeatDAO seatDAO=new SeatDAO();
//		seatDAO.save(seat);
//		
		
		List <Seat> list= seatDAO.list();
		for(Seat s:list)
		{
			System.out.println(s);
		}
		
	}

}
