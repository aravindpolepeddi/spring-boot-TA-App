package com.example.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.dao.StudentDAO;
import com.example.pojo.TA;
import com.example.pojo.TACodeReview;
import com.example.pojo.User;
import com.example.pojo.Student;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class TAViewStudents {
    @GetMapping("/TA/ViewStudents.htm")
    public String addUserGET(ModelMap model, TACodeReview ta,HttpServletRequest request) throws Exception
    {
    	User loggeduser = (User) request.getSession().getAttribute("user");
    	StudentDAO studentDAO = new StudentDAO();
    	System.out.println(loggeduser.getID());
    	System.out.println(studentDAO.getStudentList(loggeduser.getID()));
    	List<Student> s = studentDAO.getStudentList(loggeduser.getID());
    	request.setAttribute("studentList", s);
    	model.addAttribute("ta", ta);
        return "TAViewStudents";
    }
}
