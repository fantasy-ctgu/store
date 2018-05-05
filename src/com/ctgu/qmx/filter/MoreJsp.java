package com.ctgu.qmx.filter;

import java.io.IOException;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ctgu.qmx.bean.Commodity;
import com.ctgu.qmx.bean.CommodityType;
import com.ctgu.qmx.service.CommodityService;
import com.ctgu.qmx.service.CommodityTypeService;

public class MoreJsp implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest)arg0;
		HttpServletResponse response = (HttpServletResponse)arg1;
		
		CommodityTypeService commodityTypeService = new CommodityTypeService();
		CommodityService commodityService = new CommodityService();
		List<CommodityType> commodityTypes = commodityTypeService.getAll();
		List<Commodity> commodities = commodityService.getAllCommodity();
		request.setAttribute("commodityTypes", commodityTypes);
		request.setAttribute("commodities", commodities);
		
		arg2.doFilter(request, response);
	}
	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
