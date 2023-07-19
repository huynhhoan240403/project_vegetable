package com.fpt.poly.bean;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@SuppressWarnings("serial")

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class Bill implements Serializable{

	
	String fullname;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;
	String username;
	String address;
	Integer phonenumber;
	String email;
	String total;
	@Temporal(TemporalType.DATE)
	Date date = new Date();
	
}
