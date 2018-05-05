package com.ctgu.qmx.service;

import java.util.List;

import com.ctgu.qmx.bean.CommodityType;
import com.ctgu.qmx.daoimpl.CommodityTypeDaoImpl;

public class CommodityTypeService {
	CommodityTypeDaoImpl commodityTypeDaoImpl;
	public CommodityTypeService() {
		commodityTypeDaoImpl = new CommodityTypeDaoImpl();
	}
	public List<CommodityType> getAll(){
		return commodityTypeDaoImpl.findAll();
	}
}
