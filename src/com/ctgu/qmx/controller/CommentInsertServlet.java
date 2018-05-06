package com.ctgu.qmx.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ctgu.qmx.bean.Comment;
import com.ctgu.qmx.bean.User;
import com.ctgu.qmx.service.CommentService;

public class CommentInsertServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		Comment comment = new Comment();
		if (null != session.getAttribute("user")) {
			User user = (User) session.getAttribute("user");
			comment.setUsername(user.getName());
			comment.setCommodity_id(Integer.parseInt(req.getParameter("commodity_id")));
			comment.setContent(req.getParameter("content"));
			if (new CommentService().commentInsert(comment)) {
				resp.sendRedirect("Page?id="+req.getParameter("commodity_id"));
			} else {

			}
		} else if (null != session.getAttribute("seller")) {
			User user = (User) session.getAttribute("seller");
			comment.setUsername(user.getName());
			comment.setCommodity_id(Integer.parseInt(req.getParameter("commodity_id")));
			comment.setContent(req.getParameter("content"));
			if (new CommentService().commentInsert(comment)) {
				resp.sendRedirect("Page?id="+req.getParameter("commodity_id"));
			} else {

			}
		}else {
			resp.sendRedirect("login.html");
		}
	}

}
