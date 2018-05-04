package com.ctgu.qmx.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ctgu.qmx.bean.Commodity;
import com.ctgu.qmx.service.CommodityService;

public class CommodityAll extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Commodity> commodities = new CommodityService().getAllCommodity();
		req.setAttribute("commodities", commodities);
		req.getRequestDispatcher("").forward(req, resp);
	}

}
