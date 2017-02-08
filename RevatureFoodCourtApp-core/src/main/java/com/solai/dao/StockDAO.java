package com.solai.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.solai.model.Stock;
import com.solai.util.ConnectionUtil;

public class StockDAO 
{
	JdbcTemplate jdbcTemplate=ConnectionUtil.getJdbcTemplate();
	public void save(Stock stock)
	{
		String sql="INSERT INTO STOCK_DETAILS (ITEMS,ITEMS_ID,TOTAL_QUANTITY) VALUES(?,?,?)";
		Object [] params={stock.getItem(),stock.getItemsId(),stock.getQuantity()};
		int rows=jdbcTemplate.update(sql,params);
		System.out.println("Number of rows Inserted:" +rows);
	}
	
	public void delete(int id)
	{
		String sql="DELETE FROM STOCK_DETAILS WHERE ID=?";
		Object[] params={id};
		int rows=jdbcTemplate.update(sql,params);
		System.out.println("Number of rows deleted:"+rows);
	}
	
	public void update(Stock stock)
	{
		String sql="UPDATE STOCK_DETAILS SET ITEMS=? WHERE ITEMS_ID?";
		Object[]params={stock.getItem(),stock.getItemsId()};
		int rows=jdbcTemplate.update(sql,params);
		System.out.println("Number of rows updated:"+rows);
	}
	
	
	public List <Stock> list()
	{
		String sql="SELECT * FROM STOCK_DETAILS";
		return jdbcTemplate.query(sql,( rs,rowNum)->{
			Stock stock=new Stock();
			stock.setId(rs.getInt("ID"));
			stock.setItem(rs.getString("ITEMS"));
			stock.setItemsId(rs.getInt("ITEMS_ID"));
			stock.setQuantity(rs.getInt("TOTAL_QUANTITY"));
			return stock;
		});
		
	}

}


