package com.ctgu.qmx.service;

import java.util.List;

import com.ctgu.qmx.bean.CommoditySchool;
import com.ctgu.qmx.daoimpl.CommoditySchoolDaoImpl;

public class CommoditySchoolService {
	CommoditySchoolDaoImpl commoditySchoolDaoImpl;
	public CommoditySchoolService() {
		commoditySchoolDaoImpl = new CommoditySchoolDaoImpl();
	}
	public CommoditySchool getById(int school){
		return commoditySchoolDaoImpl.findById(school);
	}
	public List<CommoditySchool> getAll(){
		return commoditySchoolDaoImpl.findAll();
	}
}
