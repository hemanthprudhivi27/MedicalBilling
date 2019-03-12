package com.medicalbilling.controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {
	
	@Autowired
	JdbcTemplate jdbc;
	
	@Autowired
	NamedParameterJdbcTemplate namedjdbc;
	
	@RequestMapping(value = "medicines")
	public String medicines(HttpServletRequest request,HttpServletResponse response) {
		 String sql = "select * from medicines";
		 
		    List<List<String>> lt = jdbc.query(sql, new MedicinesMapper());
		    
		  
		request.getSession().setAttribute("Total_medicine", lt);
		
		return "medicines";
		
	}
	@RequestMapping(value = "select_medicines")
	public String  select_medicines(HttpServletRequest request,HttpServletResponse response) {
		
		String a = request.getParameter("medicinename");
		String b = request.getParameter("quantity");
		int c = Integer.parseInt(b);
		String f = request.getParameter("select");
		
		HashMap <String,Integer> h = new HashMap <String,Integer>();
		List<HashMap> medicines = new LinkedList<HashMap>();
		HashMap <Integer,Integer> hi = new HashMap <Integer,Integer>();
		List<HashMap> Rupees = new LinkedList<HashMap>();
		List<Integer> amount = new LinkedList<Integer>();
		int sum = 0;
		
		if (f==null) {
			return "error";
		}
		if(f.equals("next")) {
		String st = "select quantity from medicines where name =" + a;
		int q = jdbc.update(st);
		int balance = q-c;
		String str = "update medicines set quantity =" + balance + "where name =" + a;
		jdbc.execute(str);
		
		h.put(a,c);
		String sql = "select rupees from medicines where name =" + a ;
		int d = jdbc.update(sql);
		int s = c*d;
		hi.put(c, s);
		amount.add(s);
		
		
		return  "mediines";
		}
		 
			
			String st = "select quantity from medicines where name =" + a;
			int q = jdbc.update(st);
			int balance = q-c;
			String str = "update medicines set quantity =" + balance + "where name =" + a;
			jdbc.execute(str);
			
			h.put(a,c);
			String sql = "select rupees from medicines where name =" + a ;
			int d = jdbc.update(sql);
			int s = c*d;
			hi.put(c, s);	
			amount.add(s);
			
			
			
		for (int i = 0; i < amount.size();i++) {
			sum = sum + amount.get(i);
			}
		
			Rupees.add(hi);
		    medicines.add(h);
		    request.getSession().setAttribute("medicines", medicines);
		    request.getSession().setAttribute("Rupees", Rupees);
		    request.getSession().setAttribute("Total_amount", sum);
 		
		return "medicine_list";
		}
		
	
	
}
		


