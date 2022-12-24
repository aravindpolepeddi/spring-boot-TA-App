package com.example.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.dao.TADAO;
import com.example.exception.UserException;
import com.google.gson.Gson;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@Controller
public class AssignmentDateAJAX{

	@GetMapping("/student/AssignmentDateAJAX")
	@ResponseBody
	public String getAssignemntDate(HttpServletRequest request, HttpServletResponse response) throws IOException, NumberFormatException, UserException {
		
		String TA_Ass_ID=request.getParameter("assignment");
		List<String> parameterNames = new ArrayList<String>(request.getParameterMap().keySet());
		TADAO taDAO = new TADAO();
		List<Date> Assdatelist= taDAO.getTACRDates(Integer.parseInt(TA_Ass_ID));
		Map<Date, Date> datelist = new HashMap<>();
		if (!Assdatelist.isEmpty()) {
			for (Date date : Assdatelist) {
				
				datelist.put(date, date);
			}
		}
		Gson json = new Gson();
		String assString = json.toJson(datelist);
		return assString;

	}

}
