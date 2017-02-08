package com.solai.dao;

import java.util.List;

import com.solai.model.Sessions;

public class TestSessionsDAO {

	public static void main(String[] args) 
	{
//Sessions sessions =new Sessions();
//		sessions.setId(5);
//		sessions.setSessions("Supper");
//		sessions.setFoodsStartTime(LocalTime.parse("08:00:00"));
//		sessions.setFoodsClosedTime(LocalTime.parse("11:00:00"));
//		
SessionsDAO sessionsDAO= new SessionsDAO();
//sessionsDAO.save(sessions);
//		
		
		List<Sessions> list=sessionsDAO.list();
		for(Sessions s:list){
			System.out.println(s.getSessions()+"\t");
		}
		
		 
//		List <FoodSessionDetails> list=foodsessiondetailsDAO.list();
//		for(FoodSessionDetails fsd:list){
//			System.out.println(fsd);
//	
		}
		
		
		}


