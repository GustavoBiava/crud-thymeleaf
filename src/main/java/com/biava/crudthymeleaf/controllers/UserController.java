package com.biava.crudthymeleaf.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.biava.crudthymeleaf.entities.User;
import com.biava.crudthymeleaf.services.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService service;

	@GetMapping(value = "/home")
	public ModelAndView home() {
		ModelAndView mav = new ModelAndView("home");
		mav.addObject(new User());
		return mav;
	}
	
	@GetMapping(value = "/list")
	public ModelAndView list() {
		ModelAndView mav = new ModelAndView("list");
		mav.addObject("users", service.findAll());
		return mav;
	}
	
	@PostMapping(value = "/insert")
	public String insert(User user) {
		service.insert(user);
		return "redirect:list";
	}
	
	@GetMapping(value = "/edit/{id}")
	public ModelAndView edit(@PathVariable("id") Long id) {
		ModelAndView mav = new ModelAndView("home");
		mav.addObject("user", service.findById(id));
		return mav;
	}
	
	@GetMapping(value = "/delete/{id}")
	public String delete(@PathVariable("id") Long id) {
		service.delete(id);
		return "redirect:/list";
	}
}

