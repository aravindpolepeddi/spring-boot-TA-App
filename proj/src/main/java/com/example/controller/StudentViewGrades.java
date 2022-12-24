package com.example.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.dao.CodeReviewDAO;
import com.example.dao.StudentDAO;
import com.example.pojo.TACodeReview;
import com.example.pojo.User;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class StudentViewGrades {
	
    @GetMapping("/student/ViewGrading.htm")
    public String addUserGET(ModelMap model, TACodeReview ta,HttpServletRequest request) throws Exception
    {
    	User loggeduser = (User) request.getSession().getAttribute("user");
		CodeReviewDAO crDAO = new CodeReviewDAO();

		List<TACodeReview> a = crDAO.getcrList();
		List<TACodeReview> n = new ArrayList<>();
		for(TACodeReview s: a) {
			if(s.getStudent_id()==loggeduser.getID()) {
				n.add(s);

			}
		}
		request.setAttribute("cr", n);

        return "StudentViewGrades";
    }

}
