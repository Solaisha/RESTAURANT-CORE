package com.solai.model;

import lombok.Data;

@Data
public class Schedule {
	private int id;
	private String foodItems;
	private Sessions scheduleDetails;
	private int foodQuantity;
}
