package com.ctgu.qmx.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ctgu.qmx.bean.CommodityType;
import com.ctgu.qmx.dao.IBaseDao;
import com.ctgu.qmx.utils.DBUtils;

public class CommodityTypeDaoImpl implements IBaseDao<String, CommodityType> {

	private Connection con;
	private PreparedStatement ps;
	ResultSet rs;

	public CommodityTypeDaoImpl() {
		try {
			this.con = DBUtils.getCon();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public boolean doInsert(CommodityType v) {
		return false;
	}

	@Override
	public boolean doDelete(String k) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean doUpdate(CommodityType v) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public CommodityType findByName(String k) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CommodityType findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CommodityType> findAll() {
		List<CommodityType> commodityTypes = new ArrayList<CommodityType>();
		String sql = "select * from commodity_type";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				CommodityType commodity = new CommodityType();
				commodity.setCommodity_type(rs.getInt("commodity_type"));
				commodity.setExplains(rs.getString("explains"));
				commodityTypes.add(commodity);
			}
			con.close();
			ps.close();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return commodityTypes;
	}

	@Override
	public List<CommodityType> findAllPaging(String keyWord, int currentPage, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getAllContent() {
		// TODO Auto-generated method stub
		return 0;
	}

}
