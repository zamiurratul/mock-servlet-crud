package com.zamiurratul.mock.servlet.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zamiurratul.mock.servlet.dao.UserDao;
import com.zamiurratul.mock.servlet.model.User;
import com.zamiurratul.mock.servlet.utils.CommonUtils;

public class EditUserServlet extends HttpServlet {
	private final UserDao userDao = new UserDao();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Long id = Long.parseLong(req.getParameter("id"));
		req.setAttribute("user", userDao.findbyId(id));
		req.getRequestDispatcher("edit-user.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		User user  = CommonUtils.convertToUser(req);
		userDao.update(user);
		resp.sendRedirect(req.getContextPath() + "/view-users");
	}
	
	
}
