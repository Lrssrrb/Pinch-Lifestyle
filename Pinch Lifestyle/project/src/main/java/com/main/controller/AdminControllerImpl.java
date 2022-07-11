package com.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.main.entity.Account;
import com.main.entity.Register;
import com.main.entity.User;
//import com.main.exeptions.Error;
import com.main.repository.AccountDao;
import com.main.repository.CurrentDao;
import com.main.repository.UserDao;
import com.main.service.AdminController;


@RestController
@RequestMapping(value = "admin")
public class AdminControllerImpl implements AdminController{
	
	@Autowired
	private UserDao udao;
	
	@Autowired
	private AccountDao acc;
	
	@Autowired
	private CurrentDao cdao;
	
	
	@SuppressWarnings({ "deprecation"})
	@PostMapping(value = "/reggister")
	public User create(@RequestBody Register register) {
		Account a = new Account(register.getId(), register.getAccountNumber(), register.getAccountType(), register.getAccountPassword(), register.getAccountBalance());
		User user = new User(register.getId(), register.getName1(), register.getName2());
		System.out.println(a+""+user);
		if(!cdao.getById(0).getType().equals("admin"))
			return null;
		Account ac = new Account(user.getId(),a.getAccountNumber(), a.getAccountType(), a.getAccountPassword(), a.getAccountBalance());
		System.out.println(ac);
		acc.save(ac);
		return udao.save(user);
	}
	
	@SuppressWarnings({ "deprecation"})
	@PostMapping(value = "/delete/{id}")
	public void delete(@PathVariable int id) {
		if(!cdao.getById(0).getType().equals("admin"))
			return;
		acc.deleteById(id);
		udao.deleteById(id);
	}
	
	@SuppressWarnings("deprecation")
	@PostMapping(value = "/edit/{id}")
	public User edit(@RequestBody User user ,@PathVariable("id") Integer id) {
		if(cdao.getById(0).getType().equals("admin")) {
			if((int)id == user.getUserid() && user.getId() == acc.getById(id).getId())
				return udao.save(user);
			}
		return null;
	}
	
	@SuppressWarnings("deprecation")
	@GetMapping(value = "/getall")
	public List<User> getall(){
		if(cdao.getById(0).getType().equals("admin"))
			return udao.findAll();
		return null;
	}
	
	@SuppressWarnings("deprecation")
	@PutMapping(value = "add_bal/{id}/{b}")
	public String add_bal(@PathVariable double b,@PathVariable int id) {
		if(!cdao.getById(0).getType().equals("admin"))
				return null;
		Account ac = acc.getById(id);
		System.out.println(ac);
		ac.setAccountBalance(ac.getAccountBalance()+b);
		acc.save(ac);
		return "done,\ncurrent ballance = "+ac.getAccountBalance();
	}
	
	@SuppressWarnings("deprecation")
	@PutMapping(value = "/dec_bal/{id}/{b}")
	public String dec_bal(@PathVariable double b,@PathVariable int id) {
		if(!cdao.getById(0).getType().equals("admin"))
			return null;
		Account ac = acc.getById(id);
		if(ac.getAccountBalance()>=b) {
			ac.setAccountBalance(ac.getAccountBalance()-b);
			acc.save(ac);
			return "done,\ncurrent ballance = "+ac.getAccountBalance();
		}
		return "balance is not enough,\ncurrent ballance = "+ac.getAccountBalance();
	}

}
