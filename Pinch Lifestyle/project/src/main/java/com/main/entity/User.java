package com.main.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@Data
@NoArgsConstructor
public class User {

	@Id
	private int userid;
	@NonNull
	private String name1;
	private String name2;
	private int id;
	
	public User(int userid, String name1, String name2) {
		super();
		this.userid = userid;
		this.name1 = name1;
		this.name2 = name2;
		this.id = userid;
	}
	
	public User(int userid, String name1) {
		super();
		this.userid = userid;
		this.name1 = name1;
		this.id = userid;
	}

}
