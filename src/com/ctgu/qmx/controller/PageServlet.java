package com.ctgu.qmx.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ctgu.qmx.bean.Comment;
import com.ctgu.qmx.bean.Commodity;
import com.ctgu.qmx.bean.User;
import com.ctgu.qmx.service.CommentService;
import com.ctgu.qmx.service.CommodityService;
import com.ctgu.qmx.service.SellerService;

public class PageServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		CommodityService commodityService = new CommodityService();
		SellerService sellerService = new SellerService();
		CommentService commentService = new CommentService();
		Commodity commodity = commodityService.findCommodity(id);
		User user = sellerService.findSeller(commodity.getUsername());
		List<Comment> comments = commentService.getComment(id);
		req.setAttribute("commodity", commodity);
		req.setAttribute("comments", comments);
		req.setAttribute("seller", user);
		req.getRequestDispatcher("page.jsp").forward(req, resp);
	}

}
