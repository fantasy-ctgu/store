package com.ctgu.qmx.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ctgu.qmx.bean.Comment;
import com.ctgu.qmx.bean.Commodity;
import com.ctgu.qmx.service.CommentService;
import com.ctgu.qmx.service.CommodityService;

public class  CommodityInfo extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int commodity_id = Integer.parseInt(req.getParameter("commodity_id"));
		Commodity commodity = new CommodityService().findCommodity(commodity_id);
		List<Comment> comments = new CommentService().getComment(commodity_id);
		req.setAttribute("commodity", commodity);
		req.setAttribute("comments", comments);
		req.getRequestDispatcher("").forward(req, resp);
	}
	
}
