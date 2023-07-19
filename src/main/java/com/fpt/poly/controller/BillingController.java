package com.fpt.poly.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fpt.poly.bean.Bill;
import com.fpt.poly.dao.BillDAO;




@Controller
public class BillingController {

	@Autowired
	BillDAO bdao;
	
	@RequestMapping("/billing")
	public String bill(Model model) {
		List<Bill> bill = bdao.findAll();
		model.addAttribute("items", bill);
		return "admin/adminBilling";
	}
	@RequestMapping("/deleteBillAdmin/{id}")
	public String delete(@ModelAttribute Bill bill) {

		bdao.delete(bill);

		return "redirect:/billing";
	
}
}
