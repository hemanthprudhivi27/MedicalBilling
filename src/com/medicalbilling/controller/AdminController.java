
package com.medicalbilling.controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;

public class AdminController {
	
	@Autowired
	JdbcTemplate jdbc;
	
	@Autowired
	NamedParameterJdbcTemplate namedjdbc;
	
@RequestMapping(value = "register")
public String register(HttpServletRequest request,HttpServletResponse response) throws IOException {
	 
	
	String a = request.getParameter("username");
	String b = request.getParameter("password");
	String c = request.getParameter("phone");
	String d = request.getParameter("select");
	int e = Integer.parseInt(d);
	
	if (d==null && d.equals(" ")) {
		
		String sql = "INSERT INTO medical_user (username,password,phone,isadmin) VALUES (?,?, ?,?)";
		jdbc.update(sql,a,b,c,e);
		
		 	if (e == 1) {
			return "upload";
		}
	else {
		
		 return "User";
		}
	}
	else {
		return "error";
	}
	
	
	
}
@RequestMapping(value = "login")
public String  login(HttpServletRequest request,HttpServletResponse response) {
	
	String a = request.getParameter("username");
	String b = request.getParameter("password");
	
	String sql = "select * from medical_user where username =:a password =:b";
	
	if ((a != null && a.equals("")) && (b != null && b.equals(" "))) {
		
	
	List <String>  li = jdbc.query(sql,new RowMapper <String>() {

		@Override
		public String mapRow(ResultSet rs, int rowNum) throws SQLException {
		int c = rs.getInt("phone");
		String d = String.valueOf(c);
			return d;
		}
		
	}); 
	
	if(li != null) {
		
	String s =	"select isadmin from medical_user where username =:" + a;
List<Integer> l = jdbc.query(s,new RowMapper<Integer>() {

		@Override
		public Integer mapRow(ResultSet rs, int rowNum) throws SQLException {
			int z = rs.getInt("isadmin");
			return z;}});


if (l.get(0)==1) {
	 
	return "upload";
	
}
return "user";
	

	}
	return "error";
	}
	return "error";
	
	
		
	
}
@RequestMapping(value = "upload")
public String upload(HttpServletRequest request,HttpServletResponse response) {
	
	String a = request.getParameter("medicinename");
	String b = request.getParameter("quantity");
	String c = request.getParameter("Rupees");
	
	String sql = "insert into medicines (medicinename,quantity,rupees) VALUES (?,?, ?)";
	jdbc.update(sql,a,b,c);
	
	
	
	return "upload";
	
	
	
}

@RequestMapping(value = "update")
public String update(HttpServletRequest request,HttpServletResponse response) {
	
	String a = request.getParameter("medicinename");
	String b = request.getParameter("quantity");
	String sql = "update mediines set quantity =" + b + "where name =" + a ;
	jdbc.execute(sql);
	return "update";
	}
	
	
	
@RequestMapping(value = "finish")
public String finish(HttpServletRequest request,HttpServletResponse response) {
	
	
	
	String a = request.getParameter("medicinename");
	String b = request.getParameter("quantity");
	String c = request.getParameter("Rupees");
	
	

	if (c == null && c.equals("")) {

		String sql = "update mediines set quantity = " + b + "where name =" + a;
		jdbc.update(sql);
		
	}
	else {
		String sql = "insert into medicines (medicinename,quantity,rupees) VALUES (?,?, ?)";
		jdbc.update(sql,a,b,c);
		
	}
	 String sql = "select * from medicines";
	 
	    List<Medicines>list = jdbc.query(sql , new MedicinesMapper());

	   request.getSession().setAttribute("List", list);
	
		return "Tablets";
	}


}
	









