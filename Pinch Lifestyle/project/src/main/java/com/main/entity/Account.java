package com.main.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@NonNull
public class Account {

	@Id
	private int id;
	private String accountNumber;
	private String accountType;
	private String accountPassword;
	private Double accountBalance;
	
//	public Account(int id, String accountNumber, String accountType, String accountPassword, Double accountBalance) {
//		super();
//		this.id = id;
//		this.accountNumber = accountNumber;
//		this.accountType = accountType;
//		this.accountPassword = accountPassword;
//		this.accountBalance = accountBalance;
//	}
	
	
}
