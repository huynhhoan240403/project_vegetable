package com.fpt.poly.controller;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fpt.poly.bean.Account;
import com.fpt.poly.bean.product;
import com.fpt.poly.dao.AccountDAO;
import com.fpt.poly.dao.ProductDAO;


@Controller
public class index {
	@Autowired
	ProductDAO dao;
	@Autowired
	AccountDAO daoo;
	
	
	@RequestMapping("/index")
	public String index (HttpServletRequest request, Model model) {
		cookie(request, model);
		List<product> product= dao.findAll();
		model.addAttribute("shop", product);
		return "/user/index" ;
	}
	@RequestMapping("/indexAdmin")
	public String indexAdmin (HttpServletRequest request, Model model) {
		cookie(request, model);
		return "/admin/indexAdmin" ;
	}
	public void cookie(HttpServletRequest request, Model model) {
		 Cookie[] cookies = request.getCookies();
	        
	        // Tìm cookie có tên là "user" và lấy giá trị tài khoản người dùng
	        if (cookies != null) {
	            for (Cookie cookie : cookies) {
	                if (cookie.getName().equals("user")) {
	                    String username = cookie.getValue();
	                    
	                    // Thực hiện các thao tác với thông tin tài khoản người dùng
	                    Account user = daoo.findByUsername(username);
	                    if (user != null) {
	                        // Truyền thông tin tài khoản người dùng vào model để hiển thị trong view
	                        model.addAttribute("username", user.getUsername());
	                        model.addAttribute("password", user.getPassword());
	                        model.addAttribute("hoten", user.getHoten());
	                        model.addAttribute("email", user.getEmail());
	                        model.addAttribute("admin", user.isAdmin());
	                        
	                        //Nhớ lấy bootstraps profile !!!
	                        
	                        // Thực hiện các thao tác khác...
	                    } else {
	                       
	                    }
	                    
	                    break;
	                }
	            }
	        }
	}
	
}
