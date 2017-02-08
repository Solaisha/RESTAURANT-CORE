package com.solai.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.solai.model.Seat;
import com.solai.util.ConnectionUtil;

public class SeatDAO {
	
	JdbcTemplate jdbcTemplate=ConnectionUtil.getJdbcTemplate();
	public void save(Seat seat)
	{
		String sql="INSERT INTO SEAT_ALLOCATION(SEAT_ID,SEAT_NUMBER,SEAT_AVAILABILITY)VALUES(?,?,?)";
		Object[]params={seat.getSeatId(),seat.getSeatNumber(),seat.getSeatAvailability()};
		int rows=jdbcTemplate.update(sql,params);
		System.out.println("Number of rows inserted:" +rows);
	}
	
	public void delete(int id)
	{
		String sql="DELETE FROM SEAT_ALLOCATION WHERE SEAT_ID=?";
		Object[]params={id};
		int rows=jdbcTemplate.update(sql,params);
		System.out.println("Number of rows deleted:" +rows);
	}
	
	public void update(Seat seat)
	{
		String sql="UPDATE SEAT_ALLOCATION SET SEAT_NUMBER=?,SEAT_AVAILABILITY=? WHERE SEAT_ID=?";
		Object[]params={seat.getSeatNumber(),seat.getSeatAvailability(),seat.getSeatId()};
		int rows=jdbcTemplate.update(sql,params);
		System.out.println("Number of rows updated" +rows);
				
	}
 	
	
	List <Seat> list()
	{
		String sql="SELECT * FROM SEAT_ALLOCATION";
		List <Seat> list=jdbcTemplate.query(sql,( rs,params)->{
			Seat seat=new Seat();
			seat.setSeatId(rs.getInt("SEAT_ID"));
			seat.setSeatNumber(rs.getString("SEAT_NUMBER"));
			seat.setSeatAvailability(rs.getString("SEAT_AVAILABILITY"));
			return seat;
		});
		return list;
	}
}
