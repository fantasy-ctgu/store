package com.ctgu.qmx.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ctgu.qmx.bean.CommoditySchool;
import com.ctgu.qmx.dao.IBaseDao;
import com.ctgu.qmx.utils.DBUtils;

public class CommoditySchoolDaoImpl implements IBaseDao<String, CommoditySchool> {

	private Connection con;
	private PreparedStatement ps;
	ResultSet rs;

	public CommoditySchoolDaoImpl() {
		try {
			this.con = DBUtils.getCon();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean doInsert(CommoditySchool v) {
		return false;
	}

	@Override
	public boolean doDelete(String k) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean doUpdate(CommoditySchool v) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public CommoditySchool findByName(String k) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CommoditySchool findById(int id) {
		CommoditySchool commoditySchool = new CommoditySchool();
		String sql = "select * from commodity_school where commodity_school = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				commoditySchool.setCommodity_school(rs.getInt("commodity_school"));
				commoditySchool.setExplains(rs.getString("explains"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return commoditySchool;
	}

	@Override
	public List<CommoditySchool> findAll() {
		List<CommoditySchool> commoditySchools = new ArrayList<CommoditySchool>();
		String sql = "select * from commodity_school";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				CommoditySchool commoditySchool = new CommoditySchool();
				commoditySchool.setCommodity_school(rs.getInt("commodity_school"));
				commoditySchool.setExplains(rs.getString("explains"));
				commoditySchools.add(commoditySchool);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return commoditySchools;
	}

	@Override
	public List<CommoditySchool> findAllPaging(String keyWord, int currentPage, int pageSize) {
		return null;
	}

	@Override
	public int getAllContent() {
		return 0;
	}

}
