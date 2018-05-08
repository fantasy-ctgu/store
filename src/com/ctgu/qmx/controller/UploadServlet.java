package com.ctgu.qmx.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ctgu.qmx.bean.CommoditySchool;
import com.ctgu.qmx.bean.CommodityType;
import com.ctgu.qmx.service.CommoditySchoolService;
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
		CommoditySchoolService commoditySchoolService = new CommoditySchoolService();
		List<CommoditySchool> commoditySchools = commoditySchoolService.getAll();
		for (CommoditySchool commoditySchool : commoditySchools) {
			System.out.println(commoditySchool.getCommodity_school()+commoditySchool.getExplains());
		}
		if(req.getSession().getAttribute("user") == null){
			resp.sendRedirect("login.html");
			return ;
		}
		req.setAttribute("commodityTypes", commodityTypes);
		req.setAttribute("commoditySchools", commoditySchools);
		req.getRequestDispatcher("upload.jsp").forward(req, resp);
	}
	
}
