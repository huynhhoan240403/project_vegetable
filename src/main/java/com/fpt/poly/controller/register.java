package com.fpt.poly.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fpt.poly.bean.Account;
import com.fpt.poly.dao.AccountDAO;


@Controller
public class register {
	  @Autowired
	   private AccountDAO dao; 
	
	  @RequestMapping("/register")
	  public String registerr() {
		  return"/user/register";
	  }

	  @RequestMapping("/failregister")
	  public String failregister() {
		  return"user/failregister";
	  }


//   @RequestMapping("/account/create")
//   public String create(Account item) {
//   	dao.save(item);
//   	return "index";	
//   }
	  @RequestMapping("/account/create")
   public String createUser(Account user, Model model) {
		  if(!dao.existsById(user.getUsername())) {
				dao.save(user);
				return "redirect:/login";
			}
		  else {
			  model.addAttribute("message","Tài khoản đã tồn tại");
			  return "redirect:/failregister";
		  }
   }
	  
}
