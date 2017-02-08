package com.solai.dao;

import java.util.List;

import com.solai.model.Schedule;
import com.solai.model.Sessions;

public class TestScheduleDAO 
{
	public static void main(String[] args) 
	{
		Schedule schedule=new Schedule();
		schedule.setId(18);
		schedule.setFoodItems("Chilli parotta");
		Sessions sessions=new Sessions();
		sessions.setId(3);
		schedule.setScheduleDetails(sessions);
		schedule.setFoodQuantity(100);
		
		
		
		ScheduleDAO scheduleDAO=new ScheduleDAO();
//		scheduleDAO.save(schedule);
		scheduleDAO.delete(17);
		
		
//		
//		List <Schedule> list=scheduleDAO.list();
//		for(Schedule s:list){
//			System.out.println(s);
		//System.out.println(s.getId()+"\t");
		}
	}
//}
