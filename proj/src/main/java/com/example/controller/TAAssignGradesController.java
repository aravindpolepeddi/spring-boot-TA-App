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

import com.example.dao.CodeReviewDAO;
import com.example.dao.StudentDAO;
import com.example.dao.TADAO;
import com.example.exception.UserException;
import com.example.pojo.Student;
import com.example.pojo.TA;
import com.example.pojo.TACodeReview;
import com.example.pojo.User;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class TAAssignGradesController {
	
    @GetMapping("/TA/AssignGrades.htm")
    public String addUserGET(ModelMap model, TA ta,HttpServletRequest request) throws Exception
    {
		StudentDAO studentDAO = new StudentDAO();
		request.setAttribute("studentList", studentDAO.getStudentList());
    	model.addAttribute("ta", ta);
        return "TAAssignGrades";
    }
    
    
	@PostMapping("/TA/AssignGrades.htm")
	public String showSuccess(@ModelAttribute("ta") TA ta, BindingResult result, SessionStatus status,HttpServletRequest request) throws UserException, ParseException {
		
		System.out.println(request.getParameter("students"));
		StudentDAO studentDAO = new StudentDAO();
		Student stu= studentDAO.getfromstudentid(Integer.parseInt(request.getParameter("students")));
		int stu_id=stu.getUser_ID();
		System.out.println(request.getParameter("Assignment_Num"));
		int ass_num=Integer.parseInt(request.getParameter("Assignment_Num"));
		CodeReviewDAO crDAO = new CodeReviewDAO();
		
		TACodeReview cr = crDAO.get(ass_num, stu_id);
		cr.setTa_remarks(request.getParameter("ta_remarks"));
		cr.setStudent_marks(Integer.parseInt(request.getParameter("Assignment_marks")));
	
		crDAO.update(cr);

				
//		validator.validate(user, result);
//		if(result.hasErrors()) {
//			return "user-form";
//		}
		status.setComplete();
		return "ta";
	}
}
