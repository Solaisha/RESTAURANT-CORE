package com.solai.dao;

import java.sql.Types;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

import com.solai.util.ConnectionUtil;

public class FoodOrderDAO 
{
	JdbcTemplate jdbcTemplate =ConnectionUtil.getJdbcTemplate();
	public String FoodOrdering(String seat_no,String food_item,String quantity, String error)
	{
		SimpleJdbcCall call= new SimpleJdbcCall(jdbcTemplate).withProcedureName("PR_food_items_ordering");
		call.declareParameters(
				new SqlParameter("seat_no",Types.VARCHAR),
				new SqlParameter("food_items",Types.VARCHAR),
				new SqlParameter("quantities",Types.VARCHAR),
				new SqlOutParameter("error_message",Types.VARCHAR));
		call.setAccessCallParameterMetaData(false);
		SqlParameterSource in=new MapSqlParameterSource().addValue("SEAT_No",seat_no).addValue("FOOD_ITEMS",food_item).addValue("QUANTITIES",quantity).addValue("ERROR_MESSAGE",error);
		Map<String,Object> execute=call.execute(in);
		String Message_Status=(String) execute.get("error_message");
		return Message_Status;
	}
}



