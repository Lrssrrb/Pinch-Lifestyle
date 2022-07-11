package com.main.service;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public interface Usercontroller {

	public String dec_bal(@PathVariable double b);
	public String cur_bal();
	
}




//mini statmant
//total tansection
//current -me ja sakta hai

//other bank ifsc
//account