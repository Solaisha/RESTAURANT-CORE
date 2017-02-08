package com.solai.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.solai.model.Sessions;
import com.solai.util.ConnectionUtil;

public class SessionsDAO 
{
	private JdbcTemplate jdbcTemplate=ConnectionUtil.getJdbcTemplate();
	
	
	public void save(Sessions sessions)
	{
		 String sql="INSERT INTO FOOD_SESSION_DETAILS (FOOD_ID,SESSIONS,FOODS_AVAILABLE_FROM,FOODS_CLOSED_AT) values (?,?,?,?)";
		 Object[] params={sessions.getId(),sessions.getSessions(),sessions.getFoodsStartTime(),sessions.getFoodsClosedTime()};
		 int rows=jdbcTemplate.update(sql,params);
		 System.out.println("Number of rows Inserted:" +rows);
	}
	
	
	public void delete(int id)
	{
		String sql="delete from FOOD_SESSION_DETAILS where FOOD_ID=?";
		Object[] params={id};
		int rows=jdbcTemplate.update(sql,params);
		System.out.println("Number of rows deleted:"+rows);
	}
	
	public void update( Sessions sessions)
	{
		String sql="update FOOD_SESSION_DETAILS set SESSIONS=? where FOOD_ID=?";
		Object[] params={sessions.getSessions(),sessions.getId()};
		int rows=jdbcTemplate.update(sql,params);
		System.out.println("Number of rows updated:"+rows);

	}

	
	public List<Sessions> list()
	{
		String sql="SELECT * FROM FOOD_SESSION_DETAILS";
		return jdbcTemplate.query(sql, (rs, rowNum) -> {
			Sessions sessions = new Sessions();
			sessions.setId(rs.getInt("FOOD_ID"));
			sessions.setSessions(rs.getString("SESSIONS"));
			sessions.setFoodsStartTime(rs.getTime("FOODS_AVAILABLE_FROM").toLocalTime());
			sessions.setFoodsClosedTime(rs.getTime("FOODS_CLOSED_AT").toLocalTime());
			return sessions;
		
	});
}
}

