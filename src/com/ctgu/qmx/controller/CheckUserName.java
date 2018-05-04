package com.ctgu.qmx.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ctgu.qmx.bean.User;
import com.ctgu.qmx.service.UserService;

public class CheckUserName extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		User user = new UserService().findUser(username);
		PrintWriter out = resp.getWriter();
		if(null != user){
			out.println(1);
		}
		else {
			out.println(0);
		}
		out.close();
	}

}
