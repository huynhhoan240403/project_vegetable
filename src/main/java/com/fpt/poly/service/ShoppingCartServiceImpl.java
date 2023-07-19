package com.fpt.poly.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import com.fpt.poly.bean.product;
import com.fpt.poly.dao.ProductDAO;




@SessionScope
@Service
public class ShoppingCartServiceImpl implements ShoppingCartService{
	
//	@Autowired
//	ProductDAO dao;
//	
//	Map<Integer, Product> map = new HashMap<>();
//	@Override
//	public Product add(Integer id) {
//		Product item = map.get(id);
//		if(item == null) {
//			item = getItemFromDatabase(id);
//			item.setQty(1);
//			map.put(id, item);
//		} else {
//			item.setQty(item.getQty() + 1);
//		}
//		return item;
//	}
//	
//	@Override
//	public void remove(Integer id) {
//		map.remove(id);
//	}
//	
//	@Override
//	public Product update(Integer id, int qty) {
//		Product item = map.get(id);
//		item = getItemFromDatabase(id);
//		item.setQty(qty);
//		return item;
//	}
//	
//	@Override
//	public void clear() {
//		map.clear();
//	}
//	
//	@Override
//	public Collection<Product> getItems() {
//		return map.values();
//	}
//	
//	@Override
//	public int getCount() {
//		return map.values().stream()
//				.mapToInt(item -> item.getQty())
//				.sum();
//	}
//	
//	@Override
//	public double getAmount() {
//		return map.values().stream()
//				.mapToDouble(item -> item.getPrice()*item.getQty())
//				.sum();
//	}
//	private Product getItemFromDatabase(Integer id) {
//        return dao.findById(id).orElse(null);
//    }
//}
	  @Autowired
	    ProductDAO dao;

	    Map<Integer, product> map = new HashMap<>();

	    @Override
	    public product add(Integer id) {
	        product item = map.get(id);
	        if (item == null) {
	            Optional<product> productOptional = getItemFromDatabase(id);
	            if (productOptional.isPresent()) {
	                item = productOptional.get();
	                item.setQty(1);
	                map.put(id, item);
	            }
	        } else {
	            item.setQty(item.getQty() + 1);
	        }
	        return item;
	    }

	    @Override
	    public void remove(Integer id) {
	        map.remove(id);
	    }

	    @Override
	    public product update(Integer id, int qty) {
	        product item = map.get(id);
	        if (item != null) {
	            item.setQty(qty);
	        }
	        return item;
	    }

	    @Override
	    public void clear() {
	        map.clear();
	    }

	    @Override
	    public Collection<product> getItems() {
	        return map.values();
	    }

	    @Override
	    public int getCount() {
	        return map.values().stream()
	                .mapToInt(product::getQty)
	                .sum();
	    }

	    @Override
	    public int getAmount() {
	        return map.values().stream()
	                .mapToInt(item -> item.getPrice() * item.getQty())
	                .sum();
	    }

	    private Optional<product> getItemFromDatabase(Integer id) {
	        return dao.findById(id);
	    }
	}