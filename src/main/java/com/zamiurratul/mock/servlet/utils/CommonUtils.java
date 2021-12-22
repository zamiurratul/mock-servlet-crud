package com.zamiurratul.mock.servlet.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;

import com.zamiurratul.mock.servlet.model.User;

public class CommonUtils {
	
	public static User convertToUser(HttpServletRequest request) {
		User user = new User();
		user.setId(Long.parseLong(request.getParameter("id")));
		user.setEmployeeId(request.getParameter("employeeId"));
		user.setFullName(request.getParameter("fullName"));
		user.setDesignation(request.getParameter("designation"));
		user.setEmail(request.getParameter("email"));
		user.setContactNo(request.getParameter("contactNo"));
		user.setPassword(request.getParameter("password"));
		user.setJoiningDate(convertToSqlDate(request.getParameter("joiningDate")));
		return user;
	}
	
	public static java.sql.Date convertToSqlDate(String date) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		try {
			java.util.Date _date = formatter.parse(date);
			return new java.sql.Date(_date.getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
}
