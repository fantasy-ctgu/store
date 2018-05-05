package com.ctgu.qmx.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ctgu.qmx.bean.CommodityType;
import com.ctgu.qmx.service.CommodityTypeService;

public class UploadServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		CommodityTypeService commodityTypeService = new CommodityTypeService();
		List<CommodityType> commodityTypes = commodityTypeService.getAll();
		req.setAttribute("commodityTypes", commodityTypes);
		req.getRequestDispatcher("upload.jsp").forward(req, resp);
	}
	
}
