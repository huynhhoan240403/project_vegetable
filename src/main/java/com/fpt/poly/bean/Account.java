package com.fpt.poly.bean;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;

import lombok.NoArgsConstructor;


@SuppressWarnings("serial")

@Data
@NoArgsConstructor
@AllArgsConstructor 
@Entity

public class Account implements Serializable {
	@Id
	String username;
	String hoten;
	String password;
	String email;
	boolean admin = false;
}
