package com.solai.service;

import com.solai.dao.SeatDAO;
import com.solai.exception.SeatServiceException;
import com.solai.model.Seat;
import com.solai.validator.SeatValidator;

public class SeatService 
{
	public void saveService(Seat seat) throws SeatServiceException
	{

	SeatValidator seatValidator= new SeatValidator();
	SeatDAO seatDAO=new  SeatDAO();
	try {
		seatValidator.validateSeat(seat);
		seatDAO.save(seat);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	
}