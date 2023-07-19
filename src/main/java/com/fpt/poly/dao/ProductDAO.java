package com.fpt.poly.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.fpt.poly.bean.product;




public interface ProductDAO extends JpaRepository<product, Integer> {

	product getById(Integer id);

//	@Query("SELECT o FROM Product o WHERE o.price BETWEEN ?1 AND ?2")
//	List<product> findByPrice(int minPrice, int maxPrice);
}
