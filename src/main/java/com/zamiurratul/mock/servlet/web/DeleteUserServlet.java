package com.zamiurratul.mock.servlet.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zamiurratul.mock.servlet.dao.UserDao;

public class DeleteUserServlet extends HttpServlet {
	
	private final UserDao userDao = new UserDao();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Long id = Long.parseLong(req.getParameter("id"));
		userDao.delete(id);
		resp.sendRedirect(req.getContextPath() + "/view-users");
	}
	
}
