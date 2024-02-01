package com.biava.crudthymeleaf.controllers.exceptions;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.ModelAndView;

import com.biava.crudthymeleaf.services.exceptions.ResourceNotFoundException;
import com.biava.crudthymeleaf.services.exceptions.UserAlreadyExistsException;

@ControllerAdvice
public class ExceptionHandler {

	@org.springframework.web.bind.annotation.ExceptionHandler(UserAlreadyExistsException.class)
	public ModelAndView userAlreadyExist(UserAlreadyExistsException exception) {
		ModelAndView mav = new ModelAndView("error");
		mav.addObject("error", exception.getMessage());
		return mav;
	}
	
	@org.springframework.web.bind.annotation.ExceptionHandler(ResourceNotFoundException.class)
	public ModelAndView resourceNotFound(ResourceNotFoundException exception) {
		ModelAndView mav = new ModelAndView("error");
		mav.addObject("error", exception.getMessage());
		return mav;
	}
}
