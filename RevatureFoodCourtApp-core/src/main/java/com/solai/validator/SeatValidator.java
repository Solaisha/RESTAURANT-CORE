package com.solai.validator;

import com.solai.model.Seat;

public class SeatValidator 
{
	public void validateSeat(Seat seat) throws Exception{
		if(seat.getSeatNumber()==null|| "".equals(seat.getSeatNumber().trim()))
				{
					throw new Exception("Seat Number is Empty");
				}
	}
}
