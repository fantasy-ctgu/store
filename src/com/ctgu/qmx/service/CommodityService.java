package com.ctgu.qmx.service;

import java.util.List;

import com.ctgu.qmx.bean.Commodity;
import com.ctgu.qmx.bean.Page;
import com.ctgu.qmx.daoimpl.CommodityDaoImpl;

public class CommodityService {
	CommodityDaoImpl commodityDaoImpl;

	public CommodityService() {
		commodityDaoImpl = new CommodityDaoImpl();
	}

	public boolean commodityInsert(Commodity commodity) {
		if (commodityDaoImpl.doInsert(commodity)) {
			return true;
		}
		return false;
	}
	
	public Commodity findCommodity(int commodity_id){
		return commodityDaoImpl.findById(commodity_id);
	}
	
	public List<Commodity> getAllCommodity(){
		return commodityDaoImpl.findAll();
	}
	public List<Commodity> getBySchool(int school){
		return commodityDaoImpl.findBySchool(school);
	}

	public Page<Commodity> getPage(int currentPage, int pageSize, String keyWord) {
		Page<Commodity> page = new Page<Commodity>();
		page.setCurrPage(currentPage);
		page.setPageSize(pageSize);
		int totalCount;
		List<Commodity> commodities = null;
		totalCount = commodityDaoImpl.getAllContent();
		commodities = commodityDaoImpl.findAllPaging(keyWord, currentPage, pageSize);
		page.setTotalCount(totalCount);
		page.setList(commodities);
		return page;
	}
}
