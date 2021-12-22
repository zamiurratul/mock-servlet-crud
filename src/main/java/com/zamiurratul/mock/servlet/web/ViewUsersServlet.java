package com.zamiurratul.mock.servlet.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zamiurratul.mock.servlet.dao.UserDao;
import com.zamiurratul.mock.servlet.model.User;

public class ViewUsersServlet extends HttpServlet {

	private final UserDao userDao = new UserDao();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<User> users = userDao.findAll();
		req.setAttribute("users", users);
		req.getRequestDispatcher("view-users.jsp").forward(req, resp);
	}
}
