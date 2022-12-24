package com.example.controller;

import java.text.ParseException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.support.SessionStatus;

import com.example.dao.StudentDAO;
import com.example.dao.TADAO;
import com.example.dao.UserDAO;
import com.example.exception.UserException;
import com.example.pojo.Admin;
import com.example.pojo.Student;
import com.example.pojo.TA;
import com.example.pojo.User;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class AdminAddTAsController {
	
	@GetMapping("/admin/AddTAs.htm")
	public String showForm(ModelMap model, TA ta,SessionStatus status) {
		model.addAttribute("admin", ta);
		return "adminAddTAs";
	}
	
	@PostMapping("/admin/AddTAs.htm")
	public String showSuccess(@ModelAttribute("TA") TA ta, BindingResult result, SessionStatus status,HttpServletRequest request) throws UserException, ParseException {
		

		
		UserDAO userDAO = new UserDAO();
		TADAO taDAO = new TADAO();
//		StudentDAO studentDAO = new StudentDAO();
		
		User loggeduser = (User) request.getSession().getAttribute("user");
		System.out.println(loggeduser.getID());
//		admin = adminDAO.get(loggeduser.getID());
		
		User user = new User();
		user.setFirstname(request.getParameter("fname"));
		user.setLastname(request.getParameter("lname"));
		user.setEmail(request.getParameter("email"));
		user.setUsername(request.getParameter("username"));
		user.setPassword(request.getParameter("password"));
		user.setType("ta");
		user=userDAO.create(user);


		ta.setFirstname(request.getParameter("fname"));
		ta.setLastname(request.getParameter("lname"));
		ta.setUserID(user.getID());
		taDAO.create(ta);
		
		
		//adminDAO.create(ta);
				
//		validator.validate(user, result);
//		if(result.hasErrors()) {
//			return "user-form";
//		}
		return "admin";
	}

}
