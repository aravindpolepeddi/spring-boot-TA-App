package com.example.controller;

import java.text.ParseException;
import java.util.List;

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
import com.example.pojo.Student;
import com.example.pojo.TA;
import com.example.pojo.User;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class AdminAssignTAsController {
	@GetMapping("/admin/AssignTAs.htm")
	public String showForm(ModelMap model, Student student,SessionStatus status,HttpServletRequest request) throws UserException {
		StudentDAO studentDAO = new StudentDAO();
		request.setAttribute("studentList", studentDAO.getStudentList());
        TADAO taDAO = new TADAO();
		request.setAttribute("taList", taDAO.getTAList());
		model.addAttribute("student", student);
		return "AssignTAs";
	}
	
	@PostMapping("/admin/AssignTAs.htm")
	public String showSuccess(@ModelAttribute("student") Student student, BindingResult result, SessionStatus status,HttpServletRequest request) throws UserException, ParseException {

		System.out.println(request.getParameter("students"));
		System.out.println(request.getParameter("TAs"));
		TADAO taDAO = new TADAO();
		
		
		StudentDAO studentDAO = new StudentDAO();
		TADAO g = new TADAO();
		User loggeduser = (User) request.getSession().getAttribute("user");
		System.out.println(loggeduser.getID());
//		admin = adminDAO.get(loggeduser.getID());
		
		Student stu= studentDAO.getfromstudentid(Integer.parseInt(request.getParameter("students")));
		
		
		stu.setTa_id(taDAO.getTAUserID(Integer.parseInt(request.getParameter("TAs"))));
		studentDAO.update(stu);
		
		
		//adminDAO.create(ta);
				
//		validator.validate(user, result);
//		if(result.hasErrors()) {
//			return "user-form";
//		}
		status.setComplete();
		return "admin";
	}
}
