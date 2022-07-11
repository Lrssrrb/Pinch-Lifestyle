package com.main.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.main.entity.Register;
import com.main.entity.User;

@Service
public interface AdminController {

	public User create(@RequestBody Register register);
	public void delete(@PathVariable int id);
	public User edit(@RequestBody User user ,@PathVariable("id") Integer id);
	public List<User> getall();
	public String add_bal(@PathVariable double b,@PathVariable int id);
	public String dec_bal(@PathVariable double b,@PathVariable int id);
	
}
