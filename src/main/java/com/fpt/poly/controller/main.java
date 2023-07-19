package com.fpt.poly.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class main {
	@RequestMapping("/main")
	public String index () {
		return "/user/main" ;
	}
	@RequestMapping("/mainAdmin")
	public String indexAdmin () {
		return "/admin/main" ;
	}
}
