package com.ctgu.qmx.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ctgu.qmx.bean.Commodity;
import com.ctgu.qmx.bean.CommoditySchool;
import com.ctgu.qmx.bean.CommodityType;
import com.ctgu.qmx.service.CommoditySchoolService;
import com.ctgu.qmx.service.CommodityService;
import com.ctgu.qmx.service.CommodityTypeService;

public class MoreServlet extends  HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int school = Integer.parseInt(req.getParameter("school"));
		CommodityTypeService commodityTypeService = new CommodityTypeService();
		CommodityService commodityService = new CommodityService();
		CommoditySchoolService commoditySchoolService = new CommoditySchoolService();
		CommoditySchool commoditySchool = commoditySchoolService.getById(school);
		List<CommodityType> commodityTypes = commodityTypeService.getAll();
		List<Commodity> commodities = commodityService.getBySchool(school);
		req.setAttribute("commodityTypes", commodityTypes);
		req.setAttribute("commoditySchool", commoditySchool);
		req.setAttribute("commodities", commodities);
		req.getRequestDispatcher("more.jsp").forward(req, resp);
	}

}
