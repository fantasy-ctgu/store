package com.ctgu.qmx.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ctgu.qmx.bean.User;
import com.ctgu.qmx.service.SellerService;

public class SellerInsertServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		User user = new User();
		user.setUsername(req.getParameter("username"));
		user.setPassword(req.getParameter("password"));
		user.setName(req.getParameter("name"));
		user.setSex(req.getParameter("sex"));
		user.setAge(Integer.parseInt(req.getParameter("age")));
		user.setAddress(req.getParameter("address"));
		if (new SellerService().sellerRegister(user)) {
			HttpSession session = req.getSession();
			session.setAttribute("seller", user);
			resp.sendRedirect("index.jsp");
		}else {
			req.setAttribute("error", "用户名已存在");
			req.getRequestDispatcher("register.html").forward(req, resp);
		}
		
	}

}
