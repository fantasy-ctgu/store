package com.ctgu.qmx.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ctgu.qmx.bean.User;
import com.ctgu.qmx.service.UserService;

public class UserLogin extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		User user = new UserService().findUser(username);
		System.out.println(user);
		if(null != user && password.equals(user.getPassword())){
			HttpSession session = req.getSession();
			session.setAttribute("user", user);
			resp.sendRedirect("index.jsp");
		}else {
			req.setAttribute("error", "用户不合法");
			req.getRequestDispatcher("login.html").forward(req, resp);
		}
	}

}
