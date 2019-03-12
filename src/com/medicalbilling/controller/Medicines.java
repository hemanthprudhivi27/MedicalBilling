package com.medicalbilling.controller;

public class Medicines {
	
 private String Medicine_name ;
 private   int Quantity;
 private int Rupees;
public String getMedicine_name() {
	return Medicine_name;
}
public void setMedicine_name(String medicine_name) {
	Medicine_name = medicine_name;
}
public int getQuantity() {
	return Quantity;
}
public void setQuantity(int quantity) {
	Quantity = quantity;
}
public int getRupees() {
	return Rupees;
}
public void setRupees(int rupees) {
	Rupees = rupees;
}
 
public String toString() {
	return "Medicine_name  =" +  Medicine_name  + "Quantity  =" + Quantity  +  "Rupees  =" +  Rupees;
	
}
}
