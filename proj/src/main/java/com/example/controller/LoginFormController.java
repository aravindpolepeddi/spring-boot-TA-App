package com.example.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.support.SessionStatus;

import com.example.dao.UserDAO;
import com.example.exception.UserException;
import com.example.pojo.User;
import com.example.validator.UserLoginValidator;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class LoginFormController {
	 
//	@Autowired
//	private UserLoginValidator validator;
	HttpSession session;
	
	@GetMapping("/login.htm")
	public String showForm(ModelMap model, User user,SessionStatus status) {
		model.addAttribute("user", user);
		return "Login";
	}
	
	@PostMapping("/login.htm")
	public String showSuccess(@ModelAttribute("user") User user, BindingResult result, SessionStatus status,HttpServletRequest request) throws UserException {
		

		System.out.println(user.getPassword());
		System.out.println(user.getUsername());
		UserDAO userloginDAO = new UserDAO();
		User loggeduser= userloginDAO.LoginCheck(user.getUsername(), user.getPassword());
		session = request.getSession();
		session.setAttribute("user", loggeduser);
		//System.out.println(loggeduser.getFirstname());
//		validator.validate(user, result);
//		if(result.hasErrors()) {
//			return "user-form";
//		}
		status.setComplete();
		if(loggeduser.getType().equals("admin")) {
			return "admin";
		}
		else if(loggeduser.getType().equals("student")) {
			return "student";
		}
		else
		
		return "ta";
	}

}
