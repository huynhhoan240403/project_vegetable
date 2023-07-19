package com.fpt.poly.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fpt.poly.bean.Account;
import com.fpt.poly.dao.AccountDAO;

@Controller
public class shopdetails {
	@Autowired
	AccountDAO daoo;
	@RequestMapping("/shop-details")
	public String index (HttpServletRequest request, Model model) {
		cookie(request, model);
		return "/user/shop-details" ;
	}
	@RequestMapping("/shop-detailsAdmin")
	public String indexAdmin (HttpServletRequest request, Model model) {
		cookie(request, model);
		return "/admin/shop-details" ;
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
