package com.fpt.poly.controller;

import java.io.File;
import java.util.List;
import java.util.Optional;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.fpt.poly.bean.Account;
import com.fpt.poly.bean.product;
import com.fpt.poly.dao.AccountDAO;
import com.fpt.poly.dao.ProductDAO;



@Controller
public class TableController {

	@Autowired
	ServletContext app;

	@Autowired
	AccountDAO dao;

	@Autowired
	ProductDAO pdao;

	@RequestMapping("/table")
	public String table(Model model, @RequestParam("page") Optional<Integer> p) {

		List<Account> items = dao.findAll();

//		Pageable pageable = PageRequest.of(p.orElse(0), 5);
//		Page<Account> page = dao.findAll(pageable);
//		model.addAttribute("page", page);

//		boolean isFirstPage = page.isFirst() && !page.hasPrevious();
//	    model.addAttribute("isFirstPage", isFirstPage);
		
		model.addAttribute("items", items);
	
		return "admin/adminTable";
	}

	@GetMapping("/edit-user")
	public String editUser(@RequestParam("username") String username, Model model) {
		Account user = dao.findByUsername(username);
		model.addAttribute("user", user);
		return "admin/adminTableEdit";
	}

	@PostMapping("/save-user")
	public String saveUser(@ModelAttribute Account user) {
		if (dao.existsById(user.getUsername())) {

			dao.save(user);

		}
		return "redirect:/table";
	}

	@RequestMapping("/delete/{username}")
	public String delete(@ModelAttribute Account user) {

		dao.delete(user);

		return "redirect:/table";
	}

	@RequestMapping("/tableProduct")
	public String table2(Model model,  @RequestParam("page") Optional<Integer> p) {
//		List<Product> items = pdao.findAll();
//		model.addAttribute("items", items);
		
		Pageable pageable = PageRequest.of(p.orElse(0), 5);
		Page<product> page = pdao.findAll(pageable);
		model.addAttribute("page", page);	
		
		return "admin/adminTableProduct";
	}

	@GetMapping("/edit-product")
	public String editProduct(@RequestParam("id") Integer id, Model model) {

		product pro = pdao.getById(id);
		model.addAttribute("product", pro);
		return "admin/adminProductEdit";
	}

	@RequestMapping("/uploadFile")
	public String upload(ModelMap model, @RequestParam("image") MultipartFile image) {

			try {
				String filename = image.getOriginalFilename();
				// String path = app.getRealPath("/images/"+filename); 
				File file = new File(app.getRealPath("/img/product/" + filename));
				image.transferTo(file);
					model.addAttribute("name", image.getOriginalFilename());
//					model.addAttribute("type", image.getContentType());
//					model.addAttribute("size", image.getSize());
					return "admin/adminTableProduct";
			} catch (Exception e) {
//					model.addAttribute("message", "Lỗi lưu file !");
			}
		
		return "redirect:/tableProduct";
	}
	
	@RequestMapping("/editFile")
	public String editfile(@RequestParam("id") Integer id,ModelMap model, @RequestParam("image") MultipartFile image) {

			try {
				
				String filename = image.getOriginalFilename();
				// String path = app.getRealPath("/images/"+filename); 
				File file = new File(app.getRealPath("/img/product/" + filename));
				image.transferTo(file);
					model.addAttribute("name", image.getOriginalFilename());
//					product pro = pdao.getById(id);
//					model.addAttribute("product", pro);
//					model.addAttribute("type", image.getContentType());
//					model.addAttribute("size", image.getSize());
					return "admin/adminProductEdit";
			} catch (Exception e) {
//					model.addAttribute("message", "Lỗi lưu file !");
			}
		
		return "admin/adminProductEdit";
	}

	@PostMapping("/save-product")
	public String saveProduct(@ModelAttribute product pro) {
		if (pdao.existsById(pro.getId())) {

			pdao.save(pro);

		}
		return "redirect:/tableProduct";
	}

	@RequestMapping("/delete/{id}")
	public String delete(@ModelAttribute product pro) {

		pdao.delete(pro);

		return "redirect:/tableProduct";
	}
	@RequestMapping("/createAccount")
    public String createUser(Account user, Model model) {
		  if(!dao.existsById(user.getUsername())) {
				dao.save(user);
//				model.addAttribute("successMessage", "Tạo người dùng mới thành công");
				return "redirect:/table";
			}
		  else {
//			  model.addAttribute("errorMessage", "Username đã tồn tại");
			  return "redirect:/tableFail";
		  }
    }
	@RequestMapping("/createProduct")
	 public String order(product pro, Model model) {
		 
			pdao.save(pro);
			return "redirect:/tableProduct";
		
	  
}
	@RequestMapping("/tableFail")
    public String createUser2(Account user, Model model,  @RequestParam("page") Optional<Integer> p) {
		Pageable pageable = PageRequest.of(p.orElse(0), 5);
		Page<Account> page = dao.findAll(pageable);
		model.addAttribute("page", page);
			  return "admin/adminTableFail";
		  }
    
@RequestMapping("/deleteProduct/{id}")
public String delete2(@ModelAttribute product pro) {

	pdao.delete(pro);

	return "redirect:/tableProduct";
}
}
	
	

