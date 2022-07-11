package com.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.main.entity.Account;
import com.main.repository.AccountDao;
import com.main.repository.CurrentDao;
import com.main.service.Usercontroller;

@RestController
@RequestMapping(value = "/user")
public class UserControllerImpl implements Usercontroller{
	
	@Autowired
	private AccountDao acc;
	
	@Autowired
	private CurrentDao cur;
	
	@PutMapping(value = "/dec_bal/{b}")
	@SuppressWarnings("deprecation")
	public String dec_bal(@PathVariable double b) {
		Account ac = acc.getById(cur.getById(0).getUserid());
		if(ac.getAccountBalance()>=b) {
			ac.setAccountBalance(ac.getAccountBalance()-b);
			acc.save(ac);
			return "done,\ncurrent ballance = "+ac.getAccountBalance();
		}
		else
			return "balance is not enough,\ncurrent ballance = "+ac.getAccountBalance();
	}
	
	@PutMapping(value = "/cur_bal")
	@SuppressWarnings("deprecation")
	public String cur_bal() {
		Account ac = acc.getById(cur.getById(0).getUserid());
		return "current ballance = "+ac.getAccountBalance();
	}

	@PutMapping(value = "/trans/{b}/{id}")
	@SuppressWarnings("deprecation")
	public String transfer(@PathVariable double b,@PathVariable Integer id) {
		Account taker = acc.getById(id);
		Account ac = acc.getById(cur.getById(0).getUserid());
		if(ac.getAccountBalance()>=b) {
			ac.setAccountBalance(ac.getAccountBalance()-b);
			taker.setAccountBalance(taker.getAccountBalance()+b);
			acc.save(ac);
			acc.save(taker);
			return "done,\ncurrent ballance = "+ac.getAccountBalance();
		}
		else
			return "balance is not enough,\ncurrent ballance = "+ac.getAccountBalance();
	}

}
