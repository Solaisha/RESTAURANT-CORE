package com.solai.model;

import java.time.LocalTime;

import lombok.Data;

@Data
public class Sessions 
{
	private int id;
	private String sessions;
	private LocalTime foodsStartTime;
	private LocalTime foodsClosedTime;
}
