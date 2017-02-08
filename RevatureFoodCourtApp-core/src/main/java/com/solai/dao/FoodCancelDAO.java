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

public class FoodCancelDAO 
{
		JdbcTemplate jdbcTemplate=ConnectionUtil.getJdbcTemplate();
			public String FoodCancelling(String seat_no,String order_id,String food_item,String quantity,String message)
			{
				SimpleJdbcCall call= new SimpleJdbcCall(jdbcTemplate).withProcedureName("PR_cancellation_of_food");
				call.declareParameters(
						new SqlParameter("order_ids",Types.VARCHAR),
						new SqlParameter("seat_no",Types.VARCHAR),
						new SqlParameter("food_items",Types.VARCHAR),
						new SqlParameter("quantites",Types.VARCHAR),
						new SqlOutParameter("error_message", Types.VARCHAR));
						call.setAccessCallParameterMetaData(false);
						SqlParameterSource in=new MapSqlParameterSource().addValue("SEAT_NO", seat_no).addValue("ORDER_IDS",order_id).addValue("FOOD_ITEMS",food_item).addValue("QUANTITES",quantity).addValue("ERROR_MESSAGE",message);
						Map<String,Object> execute=call.execute(in);
						String Message_Status=(String) execute.get("error_message");
						return Message_Status;


			}
}
