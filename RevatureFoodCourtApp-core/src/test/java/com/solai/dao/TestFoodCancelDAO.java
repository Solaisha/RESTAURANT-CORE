package com.solai.dao;

public class TestFoodCancelDAO {

	public static void main(String[] args) 
	{
		FoodCancelDAO foodcancelDAO=new FoodCancelDAO();
		String Message_Status = foodcancelDAO.FoodCancelling("a5","14","vada", "1", "Message");
		System.out.println(Message_Status);
	}

}
