package com.example.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
public class StudentBookCodeReviewController {

//    @GetMapping("/student/BookCodeReview.htm")
//    public String addUserGET(ModelMap model, TACodeReview cr,HttpServletRequest request) throws Exception
//    {
////REMOVE ALREADY BOOKED TIMES FROM crTimes LIST
////    	CodeReviewDAO crDAO = new CodeReviewDAO();
////    	crDAO.getcrList();
////    	

	@GetMapping("/student/BookCodeReview.htm")
    public String loginmessage(){
        return "StudentBookCodeReview";
    }
    
	@PostMapping("/student/BookCodeReview.htm")
	public String showSuccess(@ModelAttribute("cr") TACodeReview cr, BindingResult result, SessionStatus status,HttpServletRequest request) throws UserException, ParseException {
		

		CodeReviewDAO crDAO = new CodeReviewDAO();

		TACodeReview TAcr = new TACodeReview();
		System.out.println(request.getParameter("assignment"));
		System.out.println(request.getParameter("date"));
		System.out.println(request.getParameter("time"));
    	StudentDAO studentDAO = new StudentDAO();
		User loggeduser = (User) request.getSession().getAttribute("user");
		
    	TADAO taDAO = new TADAO();
    	int b = loggeduser.getID();
    	int a = studentDAO.getTAID(b);
		

	

		//crDAO.update(cr);
//		taDAO.create(ta);
		
		TAcr.setAssignment_num(Integer.parseInt(request.getParameter("assignment")));
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat ddf = new SimpleDateFormat("HH:mm");
		Date Studentcodereviewdate = df.parse(request.getParameter("date"));
		TAcr.setStudentcodereviewdate(Studentcodereviewdate);
		Date t = df.parse(request.getParameter("time"));
		System.out.println(t);

		TAcr.setStudentcodereviewstart(df.parse(request.getParameter("time")));
		TAcr.setStudent_id(b);
		TAcr.setTa_id(a);
		
		crDAO.create(TAcr);
//		validator.validate(user, result);
//		if(result.hasErrors()) {
//			return "user-form";
//		}
		status.setComplete();
		return "student";
	}
}
