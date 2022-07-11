package com.main.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@NonNull
public class Admin {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int adminid;
	private String name;
	private String type;
	private String password;
	
	public Admin(String name, String type, String password) {
		this.name = name;
		this.type = type;
		this.password = password;
	}
	
	
	
}
