package com.main.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Current {
	
	@Id
	private int id;
	private int userid;
	private String name;
	private String type;
	private String password;
	
	public Current(int userid, String name, String type, String password) {
		super();
		this.id = 0;
		this.userid = userid;
		this.name = name;
		this.type = type;
		this.password = password;
	}

}
