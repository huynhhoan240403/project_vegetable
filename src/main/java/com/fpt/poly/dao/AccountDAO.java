package com.fpt.poly.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fpt.poly.bean.Account;

public interface AccountDAO extends JpaRepository<Account, String> {
	Account findByUsername(String username);

}
