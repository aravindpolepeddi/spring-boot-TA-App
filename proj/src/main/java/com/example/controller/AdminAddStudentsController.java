package com.example.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.support.SessionStatus;

import com.example.dao.AdminDAO;
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
public class AdminAddStudentsController {
	
	@GetMapping("/admin/AddStudents.htm")
	public String showForm(ModelMap model, Admin admin,SessionStatus status) {
		model.addAttribute("admin", admin);
		return "adminAddStudents";
	}
	
	@PostMapping("/admin/AddStudents.htm")
	public String showSuccess(@ModelAttribute("Admin") Admin admin, BindingResult result, SessionStatus status,HttpServletRequest request) throws UserException, ParseException {
		

		
		UserDAO userDAO = new UserDAO();
		StudentDAO studentDAO = new StudentDAO();
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
		user.setType("student");
		user=userDAO.create(user);

		
		Student student = new Student();
		student.setFirstname(request.getParameter("fname"));
		student.setLastname(request.getParameter("lname"));
		student.setNU_ID(Integer.parseInt(request.getParameter("nuid")));
		student.setUser_ID(user.getID());
		studentDAO.create(student);
		
		
		//adminDAO.create(ta);
				
//		validator.validate(user, result);
//		if(result.hasErrors()) {
//			return "user-form";
//		}
		status.setComplete();
		return "admin";
	}

}
