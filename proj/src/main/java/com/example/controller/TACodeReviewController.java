package com.example.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.support.SessionStatus;

import com.example.dao.CodeReviewDAO;
import com.example.dao.TADAO;
import com.example.dao.UserDAO;
import com.example.exception.UserException;
import com.example.pojo.TA;
import com.example.pojo.TACodeReview;
import com.example.pojo.User;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class TACodeReviewController {
	
    @GetMapping("/TA/CodeReview.htm")
    public String addUserGET(ModelMap model, TA ta) throws Exception
    {
    	model.addAttribute("ta", ta);
        return "TACodeReview";
    }
    
	@PostMapping("/TA/CodeReview.htm")
	public String showSuccess(@ModelAttribute("ta") TA ta, BindingResult result, SessionStatus status,HttpServletRequest request) throws UserException, ParseException {
		

		CodeReviewDAO crDAO = new CodeReviewDAO();
		TADAO taDAO = new TADAO();
		User loggeduser = (User) request.getSession().getAttribute("user");
		System.out.println(loggeduser.getID());
		List<TA> talist=taDAO.getTAList();

			for(int i=0;i<talist.size();i++){
				if(talist.get(i).getUserID()==loggeduser.getID()) {
					if(talist.get(i).getAssignment_num()==Integer.parseInt(request.getParameter("Assignment_Num"))) {
						DateFormat ddf = new SimpleDateFormat("yyyy-MM-dd");
						talist.get(i).setAssignment_num(Integer.parseInt(request.getParameter("Assignment_Num")));
						talist.get(i).setCodereviewdate(ddf.parse(request.getParameter("Code_Review_Date")));
						DateFormat df = new SimpleDateFormat("HH:mm");
						talist.get(i).setCodereviewperiod(Integer.parseInt(request.getParameter("codereviewperiod")));
						talist.get(i).setCodereviewstart( df.parse(request.getParameter("codereviewstart")));
						talist.get(i).setCodereviewend( df.parse(request.getParameter("codereviewend")));
						talist.get(i).setAssignment_num(Integer.parseInt(request.getParameter("Assignment_Num")));
						taDAO.update(talist.get(i));
						break;
					}
					else {
						TA newta = new TA();
						newta.setFirstname(loggeduser.getFirstname());
						newta.setLastname(loggeduser.getLastname());
						newta.setUserID(loggeduser.getID());
						DateFormat ddf = new SimpleDateFormat("yyyy-MM-dd");
						newta.setAssignment_num(Integer.parseInt(request.getParameter("Assignment_Num")));
						newta.setCodereviewdate(ddf.parse(request.getParameter("Code_Review_Date")));
						DateFormat df = new SimpleDateFormat("HH:mm");
						newta.setCodereviewperiod(Integer.parseInt(request.getParameter("codereviewperiod")));
						newta.setCodereviewstart( df.parse(request.getParameter("codereviewstart")));
						newta.setCodereviewend( df.parse(request.getParameter("codereviewend")));
						//talist.get(i).setAssignment_num(Integer.parseInt(request.getParameter("Assignment_Num")));
						taDAO.create(newta);
						break;
					}
				}
			}


		
		
				
//		validator.validate(user, result);
//		if(result.hasErrors()) {
//			return "user-form";
//		}
		status.setComplete();
		return "ta";
	}

}
