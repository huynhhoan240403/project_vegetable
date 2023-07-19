package com.fpt.poly.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fpt.poly.bean.Account;
import com.fpt.poly.bean.Bill;
import com.fpt.poly.dao.AccountDAO;
import com.fpt.poly.dao.BillDAO;
import com.fpt.poly.service.ParamService;
import com.fpt.poly.service.ShoppingCartService;





@Controller


public class shopingcart {
	@Autowired
	AccountDAO daoo;
	
	@Autowired
	ShoppingCartService cart;
	
	@Autowired
	ParamService param;
	
	@Autowired
	BillDAO bdao;
	
	@RequestMapping("/shoping-cart")
	public String index (HttpServletRequest request, Model model) {
		cookie(request, model);
		
		model.addAttribute("cart", cart);
		return "/user/shoping-cart" ;
	}
	@RequestMapping("/shoping-cartAdmin")
	public String indexAdmin (HttpServletRequest request, Model model
			) {
		cookie(request, model);
		return "/admin/shoping-cart" ;
	}
	@RequestMapping("/cart/add/{id}")
	public String add( @PathVariable("id") Integer id, HttpServletRequest request) {
		
			 Cookie[] cookies = request.getCookies();

		        // Kiểm tra xem có cookie "user" hay không
		        if (cookies != null) {
		            for (Cookie cookie : cookies) {
		                if (cookie.getName().equals("user")) {
		              
		                	cart.add(id);
		            		return "redirect:/shoping-cart";
		                }
		            }
		        }
		        	return "redirect:/login";
	
	}
	@RequestMapping("/cart/update")
	public String update(@RequestParam("id") Integer id, @RequestParam("qty") int qty) {
	    cart.update(id, qty);
	    return "redirect:/shoping-cart";
	}
	@RequestMapping("/cart/remove/{id}")
	public String remove(@PathVariable("id") Integer id) {
		cart.remove(id);
		return "redirect:/shoping-cart";
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
	@RequestMapping("/checkOut")
	public String checkOut(HttpServletRequest request,Model model) {
		
		cookie(request, model);
	    model.addAttribute("cart", cart.getItems());
	    model.addAttribute("carts" , cart);
	    return "user/checkout";
	}
	 @RequestMapping("/order")
	    public String order(Bill bill, Model model) {
			 
					bdao.save(bill);
					return "redirect:/contact";
				
			  
	    }
}
