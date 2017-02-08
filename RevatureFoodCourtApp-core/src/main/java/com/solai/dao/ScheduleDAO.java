package com.solai.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.solai.model.Schedule;
import com.solai.model.Sessions;
import com.solai.util.ConnectionUtil;

public class ScheduleDAO 
{
	JdbcTemplate jdbcTemplate=ConnectionUtil.getJdbcTemplate();
	
	public void save(Schedule schedule)
	{
		String sql="INSERT INTO FOOD_SCHEDULE_DETAILS (ID,FOOD_ITEMS,FOOD_ITEMS_ID,TOTAL_FOOD_QUANTITY) VALUES(?,?,?,?)";
		Object[] params={schedule.getId(),schedule.getFoodItems(),schedule.getScheduleDetails().getId(),schedule.getFoodQuantity()};
		int rows=jdbcTemplate.update(sql,params);
		System.out.println("Number of rows Inserted:" +rows);

	}
	public void delete(int id)
	{
		String sql="DELETE FROM FOOD_SCHEDULE_DETAILS WHERE ID=?";
		Object[]params={id};
		int rows=jdbcTemplate.update(sql,params);
		System.out.println("Number of rows deleted:"+rows);

	}
	
	public void update(Schedule schedule)
	{
		String sql="UPDATE FOOD_SCHEDULE_DETAILS SET FOOD_ITEMS=?,ID=? WHERE FOOD_ITEMS_ID=?";
		Object[] params={schedule.getFoodItems(),schedule.getId(),schedule.getScheduleDetails()};
		int rows=jdbcTemplate.update(sql,params);
		System.out.println("Number of rows updated:"+rows);

	}
	
	
	List <Schedule> list()
	{
		String sql="SELECT * FROM FOOD_SCHEDULE_DETAILS";
		List <Schedule> list=jdbcTemplate.query(sql, (rs,params)->{
			Schedule schedule=new Schedule();
			schedule.setId(rs.getInt("ID"));
			schedule.setFoodItems(rs.getString("FOOD_ITEMS"));
			Sessions s=new Sessions();
			s.setId(rs.getInt("FOOD_ITEMS_ID"));
			schedule.setScheduleDetails(s);
//			schedule.setScheduleDetails(rs.getSessions("FOOD_ITEMS_ID"));
			schedule.setFoodQuantity(rs.getInt("TOTAL_FOOD_QUANTITY"));
			return schedule;
		});
		return list;
	
}
}


