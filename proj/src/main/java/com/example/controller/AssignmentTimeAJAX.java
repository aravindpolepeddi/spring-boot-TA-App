package com.example.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.dao.TADAO;
import com.example.exception.UserException;
import com.google.gson.Gson;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class AssignmentTimeAJAX {
	@GetMapping("/student/AssignmentTimeAJAX")
	@ResponseBody
	public String getAssignemntDate(HttpServletRequest request, HttpServletResponse response) throws IOException, NumberFormatException, UserException, Exception {
		
		String TA_Ass_Date=request.getParameter("date");
		//SimpleDateFormat df = new SimpleDateFormat("HH:mm");
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");
		Map<String, String> crTimes = new HashMap<>();

		TADAO taDAO = new TADAO();
		Date startTime = taDAO.getstartTime(df.parse(TA_Ass_Date));
		Date endTime = taDAO.getendTime(df.parse(TA_Ass_Date));
		int timePeriod = taDAO.getTimePeriod(df.parse(TA_Ass_Date));
		
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat ddf = new SimpleDateFormat("HH:mm");
		int flag=0;
		while(flag<=0) {
			cal.setTime(startTime);
			cal.add(Calendar.MINUTE, timePeriod);
			if(cal.getTime().after(endTime)){
				flag=1;
			}
			else {
				String newTime = ddf.format(cal.getTime());
				DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");
				crTimes.put(dateFormat.format(cal.getTime()),newTime);
				startTime =cal.getTime();
			}
		}
		Gson json = new Gson();
		String assString = json.toJson(crTimes);
		return assString;

	}
}
