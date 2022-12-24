package com.example.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.dao.StudentDAO;
import com.example.dao.TADAO;
import com.example.exception.UserException;
import com.example.pojo.TA;
import com.example.pojo.User;
import com.google.gson.Gson;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//http://localhost:8080/proj/student/AssignmentAJAX
@Controller
//@WebServlet("/student/AssignmentAJAX.htm")
public class AssignmentAJAX extends HttpServlet {

	@GetMapping("/student/AssignmentAJAX")
	@ResponseBody
	public String getAssignemntNumber(HttpServletRequest request, HttpServletResponse response) throws IOException {
		User loggeduser = (User) request.getSession().getAttribute("user");
		System.out.println(loggeduser.getID());
		Map<Integer, Integer> assnumlist = new HashMap<>();
		StudentDAO studentDAO = new StudentDAO();
		TADAO taDAO = new TADAO();
		// GET LIST of TAs with USERID //Continue
		List<TA> ta1 = new ArrayList<>();
		try {
			ta1 = taDAO.getTA(studentDAO.getTAID(loggeduser.getID()));
		} catch (UserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (!ta1.isEmpty()) {
			for (TA ta : ta1) {
				if(!assnumlist.containsValue(ta.getAssignment_num())) {
					assnumlist.put(ta.getAssignment_num(), ta.getAssignment_num());
				}
				
			}
		}
		Gson json = new Gson();
		String assString = json.toJson(assnumlist);
		return assString;

	}

}
