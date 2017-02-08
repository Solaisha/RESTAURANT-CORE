package com.solai.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.solai.model.Items;
import com.solai.util.ConnectionUtil;

public class ItemsDAO {
	private JdbcTemplate jdbcTemplate=ConnectionUtil.getJdbcTemplate();
	
	
	public void save(Items items)
	{
		String sql="INSERT INTO ITEMS_DETAILS(ID,ITEMS,ITEMS_PRICE)VALUES (?,?,?)";
		Object[] params={items.getId(),items.getItems(),items.getItemsPrice()};
		int rows=jdbcTemplate.update(sql,params);
		System.out.println("Number of rows inserted:" +rows);
	}
	
	public void delete(int id)
	{
		String sql="DELETE FROM ITEMS_DETAILS WHERE ID=?";
		Object[] params={id};
		int rows=jdbcTemplate.update(sql,params);
		System.out.println("Number of rows deleted:" +rows);

	}
	
	public void update(Items items)
	{
		String sql="UPDATE ITEMS_DETAILS SET ITEMS=?,ITEMS_PRICE=? WHERE ID=?";
		Object[] params={items.getItems(),items.getItemsPrice(),items.getId()};
		int rows=jdbcTemplate.update(sql,params);
		System.out.println("Number of rows updated" +rows);
	}
	
	public List<Items> list()
	{
		String sql="SELECT * FROM ITEMS_DETAILS";
		List <Items> list=jdbcTemplate.query(sql, (rs,rowNUM) -> {
			Items items=new Items();
			items.setId(rs.getInt("ID"));
			items.setItems(rs.getString("ITEMS"));
			items.setItemsPrice(rs.getInt("ITEMS_PRICE"));
			return items;
		});
		return list;
	}
}
