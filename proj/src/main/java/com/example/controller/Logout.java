package com.example.controller;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.support.SessionStatus;

import com.example.pojo.Admin;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
public class Logout {
	
	HttpSession session;
	@GetMapping("/Logout.htm")
	@ModelAttribute("user")
	
	public void showForm(SessionStatus status,HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		session = request.getSession();
		session.removeAttribute("user");
		status.setComplete();
response.sendRedirect("http://localhost:8080/proj/login.htm");
		//return "welcome";
	}
}
