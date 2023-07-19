package com.fpt.poly.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fpt.poly.bean.Account;
import com.fpt.poly.dao.AccountDAO;




@Controller
public class login {


	@Autowired
	AccountDAO dao;
	
	@RequestMapping("/login")
	public String login(HttpServletRequest request, Model model) {
		
	 Cookie[] cookies = request.getCookies();

	        // Kiểm tra xem có cookie "user" hay không
	        if (cookies != null) {
	            for (Cookie cookie : cookies) {
	                if (cookie.getName().equals("user")) {
	                    // Nếu tồn tại cookie "user", điều hướng đến trang profile
	                    return "redirect:/profile";
	                }
	            }
	        }

	        // Nếu không tồn tại cookie "user", điều hướng đến trang login
	        return "/user/login";
	    }
		
	 @RequestMapping("/logout")
	    public String logout(HttpServletResponse response) {
	        // Tạo một cookie mới với tên "user" và giá trị rỗng
	        Cookie cookie = new Cookie("user", "");
	        cookie.setMaxAge(0); // Đặt thời gian tồn tại của cookie là 0 để xóa nó
	        cookie.setPath("/"); // Đặt path cho cookie
	        response.addCookie(cookie);

	        return "redirect:/login"; // Chuyển hướng đến trang đăng nhập sau khi đăng xuất
	    }
	
	
	@RequestMapping("/failLogin")
	public String failLogin() {
		return "user/failLogin";
	}
	
	@RequestMapping("/profile")
	public String profile(HttpServletRequest request, Model model) {
		  // Lấy danh sách cookie từ request
		cookie(request, model);
		
		return "user/profile";
	}

	
	@RequestMapping("/checkLogin")
	public String loginUser(Account Account, HttpServletResponse response) {
		
	Account existingUser = dao.findByUsername(Account.getUsername());
    
    // Kiểm tra xem người dùng tồn tại và mật khẩu khớp
	 if (existingUser != null && existingUser.getPassword().equals(Account.getPassword())) {
		 
		 if(existingUser.isAdmin()==false) {
			 Cookie cookie = new Cookie("user", Account.getUsername());
			 cookie.setMaxAge(86400); // Thời gian tồn tại của cookie (1 ngày)
			 cookie.setPath("/"); // Đặt path cho cookie
			 response.addCookie(cookie);
			 
		        return "redirect:/index";
		 }else {
			 Cookie cookie = new Cookie("user", Account.getUsername());
			 cookie.setMaxAge(86400); // Thời gian tồn tại của cookie (1 ngày)
			 cookie.setPath("/"); // Đặt path cho cookie
			 response.addCookie(cookie);
			 
			 return "redirect:/indexAdmin"; // thằng này nằm ở dòng 91		       
		 }
	
	    }
	 else {
		 return "redirect:/index";
	 }
    
}
	
	@RequestMapping("/adminLogin")
	public String login2(HttpServletRequest request) {
		
		 Cookie[] cookies = request.getCookies();

	        // Kiểm tra xem có cookie "user" hay không
	        if (cookies != null) {
	            for (Cookie cookie : cookies) {
	                if (cookie.getName().equals("user")) {
	                    // Nếu tồn tại cookie "user", điều hướng đến trang profile
	                    return "redirect:/adminProfile";
	                }
	            }
	        }

	        // Nếu không tồn tại cookie "user", điều hướng đến trang login
	        return "user/login";
	    }
	
	@RequestMapping("/adminProfile")
	public String profile2(HttpServletRequest request, Model model) {
		  // Lấy danh sách cookie từ request
        cookie(request, model);
        
		
		return "admin/adminProfile";
	}
	 
	
	public void cookie(HttpServletRequest request, Model model) {
		 Cookie[] cookies = request.getCookies();
	        
	        // Tìm cookie có tên là "user" và lấy giá trị tài khoản người dùng
	        if (cookies != null) {
	            for (Cookie cookie : cookies) {
	                if (cookie.getName().equals("user")) {
	                    String username = cookie.getValue();
	                    
	                    // Thực hiện các thao tác với thông tin tài khoản người dùng
	                    Account user = dao.findByUsername(username);
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
