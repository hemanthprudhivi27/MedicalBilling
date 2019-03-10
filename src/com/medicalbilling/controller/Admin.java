package com.medicalbilling.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Admin {
	
	@Autowired
	JdbcTemplate jdbc;
	
@RequestMapping(value = "admin_register")
public String register() {
	 
	
	
	
	return "upload";
	
}
@RequestMapping(value = "admin_login")
public String  login() {
	
	
	
	
	return "upload";
	
}
@RequestMapping(value = "upload")
public void upload() {
	
	
	
}




}
