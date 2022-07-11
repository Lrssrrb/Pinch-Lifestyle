package com.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.main.entity.Admin;
import com.main.entity.Current;
import com.main.entity.User;
import com.main.repository.AccountDao;
import com.main.repository.AdminDao;
import com.main.repository.CurrentDao;
import com.main.repository.UserDao;
import com.main.service.Log;

@RestController
@RequestMapping(value = "log")
public class LogImpl implements Log{

	@Autowired
	private AdminDao adao;
	
	@Autowired
	private CurrentDao cdao;
	
	@Autowired
	private UserDao udao;
	
	@Autowired
	private AccountDao acc;
	
	@SuppressWarnings("deprecation")
	@PostMapping(value = "/in/{type}/{id}")
	public Current login(@PathVariable("id") Integer id,@PathVariable("type") String type,@RequestBody() String pass) {
		if(type.equals("admin")) {
		Admin a = adao.getById(id);
		System.out.println(a);
		if(a.getPassword().equals(pass)) {
			Current c = new Current(id,a.getName(), "admin", pass);
			cdao.save(c);
			return c;
			}
		}
		else if(type.equals("user")) {
		User u = udao.getById(id);
		System.out.println(acc.getById(u.getId()));
		if(acc.getById(u.getId()).getAccountPassword().equals(pass)) {
			if(cdao.getById(0) != null) {
//				System.out.println(cdao.getById(0));
//				cdao.deleteById(0);
				cdao.del(0);
//				System.out.println(cdao.getById(0));
				Current c = new Current(id,u.getName1(), "user", pass);
				cdao.save(c);
				return c;
			}
			else {
				Current c = new Current(id,u.getName1(), "user", pass);
				cdao.save(c);
				return c;
			}
			}
		}
		return null;
	}
	
	@DeleteMapping(value = "/out")
	public void logout() {
		cdao.del(0);
	}

}
