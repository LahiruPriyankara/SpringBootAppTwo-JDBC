package com.lhu.SpringSecurityJdbc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
	
	@RequestMapping("/")
	@ResponseBody
	public String allUser() {
		return "<h1>ALL USERS PAGE</h1>";
	}
	@RequestMapping("/normalUser")
	@ResponseBody
	public String normalUser() {
		return "<h1>NORMAL USERS PAGE</h1>";
	}
	@RequestMapping("/admin")
	@ResponseBody
	public String adminUser() {
		return "<h1>ADMIN USERS PAGE</h1>";
	}
	
}
