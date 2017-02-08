package com.solai.dao;

public class TestFoodOrderDAO {

	public static void main(String[] args) 
	{
		FoodOrderDAO foodorderDAO=new FoodOrderDAO();
		String Message_Status = foodorderDAO.FoodOrdering("a5", "Idly,Vada", "2,3", "Message");
		System.out.println(Message_Status);
	}

}