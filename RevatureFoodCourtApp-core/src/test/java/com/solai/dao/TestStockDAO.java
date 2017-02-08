package com.solai.dao;

import java.util.List;

import com.solai.model.Stock;

public class TestStockDAO {

	public static void main(String[] args) 
	{
//		Stock stock=new Stock();
//		stock.setId(17);
//		stock.setItem("Appam");
//		stock.setItemsId(4);;
//		stock.setQuantity(100);
		StockDAO stockDAO=new StockDAO();
//		stockDAO.save(stock);
		
//		stockDAO.delete(16);
		
		
		List<Stock> list=stockDAO.list();
		for(Stock s:list)
		{
			System.out.println(s.getId()+"\t");
			System.out.println(s.getItem()+"\t");
			System.out.println(s.getItemsId()+"\t");
			System.out.println(s.getQuantity()+"\t");
			System.out.println(s.getStock()+"\t");

		}
	}

}
