package com.main.entity;


import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Getter
@NoArgsConstructor
public class Register {

	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private int id;
	@NonNull
	private String accountNumber;
	@NonNull
	private String accountType;
	@NonNull
	private String accountPassword;
	@NonNull
	private Double accountBalance;
	private int userid;
	@NonNull
	private String name1;
	private String name2;
	
	public Register(int id, String accountNumber, String accountType, String accountPassword, Double accountBalance,
			String name1,String name2) {
		super();
		this.id = id;
		this.accountNumber = accountNumber;
		this.accountType = accountType;
		this.accountPassword = accountPassword;
		this.accountBalance = accountBalance;
		this.userid = id;
		this.name1 = name1;
		this.name2 = name2;
	}
	
	public Register(int id, String accountNumber, String accountType, String accountPassword, Double accountBalance,
			String name1) {
		super();
		this.id = id;
		this.accountNumber = accountNumber;
		this.accountType = accountType;
		this.accountPassword = accountPassword;
		this.accountBalance = accountBalance;
		this.userid = id;
		this.name1 = name1;
	}
	
	
}
