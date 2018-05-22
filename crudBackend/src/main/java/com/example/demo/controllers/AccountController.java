package com.example.demo.controllers;

import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;
import com.example.demo.entities.*;

@Controller
@RequestMapping("/user")
public class AccountController {
	
	@RequestMapping(method=RequestMethod.GET)
	public String login(ModelMap mm){
		mm.put("user", new User());
		return "login";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String login(@ModelAttribute(value="user") User user, ModelMap mm){
		if(user.getUserName().equals("boris") && user.getPassword().equals("zaharic")) {
			mm.put("username", user.getUserName());
			return "welcome";
		}else {
			mm.put("message","Account is invalid.");
			return "login";
		}
		
	}
}
