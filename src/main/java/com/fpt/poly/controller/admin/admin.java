package com.fpt.poly.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class admin {
	@RequestMapping("/admin")
	public String index () {
		return "/admin/admin" ;
	}
}