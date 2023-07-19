package com.fpt.poly.dao;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fpt.poly.bean.Bill;





public interface BillDAO extends JpaRepository<Bill, Integer>{

	List<Bill> findByUsername(String username);

	 
}
