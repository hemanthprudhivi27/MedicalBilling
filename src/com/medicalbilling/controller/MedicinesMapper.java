package com.medicalbilling.controller;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class MedicinesMapper implements RowMapper {

	@Override
	public Medicines mapRow(ResultSet rs, int rowNum) throws SQLException {
		Medicines m = new Medicines();
		m.setMedicine_name(rs.getString("name"));
		m.setQuantity(rs.getInt("quantity"));
		m.setRupees(rs.getInt("rupees"));
		return m;
	}

	
}