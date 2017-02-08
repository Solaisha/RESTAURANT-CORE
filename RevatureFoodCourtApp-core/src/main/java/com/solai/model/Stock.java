package com.solai.model;

import lombok.Data;

@Data
public class Stock 
{
	private int id;
	private String item;
	private int itemsId;
	private int quantity;
	private int stock;
}
