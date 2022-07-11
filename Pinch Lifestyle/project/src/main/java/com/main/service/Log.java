package com.main.service;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.main.entity.Current;

@Service
public interface Log {

	public Current login(@PathVariable("id") Integer id,@PathVariable("type") String type,@RequestBody() String pass);
	
	public void logout();
}
