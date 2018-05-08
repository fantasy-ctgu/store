package com.ctgu.qmx.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ctgu.qmx.bean.Commodity;
import com.ctgu.qmx.dao.IBaseDao;
import com.ctgu.qmx.utils.DBUtils;

public class CommodityDaoImpl implements IBaseDao<String, Commodity> {

	private Connection con;
	private PreparedStatement ps;
	ResultSet rs;

	public CommodityDaoImpl() {
		try {
			this.con = DBUtils.getCon();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public boolean doInsert(Commodity v) {
		String sql = "insert into commodity_info(commodity_name,username,commodity_type,commodity_content,commodity_money,img,commodity_school) values(?,?,?,?,?,?,?)";
		try {
			this.ps = con.prepareStatement(sql);
			ps.setString(1, v.getCommodity_name());
			ps.setString(2, v.getUsername());
			ps.setInt(3, v.getCommodity_type());
			ps.setString(4, v.getCommodity_content());
			ps.setString(5, v.getCommodity_money());
			ps.setString(6, v.getImg());
			ps.setInt(7, v.getCommodity_school());
			if (ps.executeUpdate() > 0) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public boolean doDelete(String k) {
		return false;
	}

	@Override
	public boolean doUpdate(Commodity v) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public List<Commodity> findAll() {
		List<Commodity> commodities = new ArrayList<Commodity>();
		String sql = "select * from commodity_info";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				Commodity commodity = new Commodity();
				commodity.setId(Integer.parseInt(rs.getString("id")));
				commodity.setCommodity_content(rs.getString("commodity_content"));
				commodity.setCommodity_name(rs.getString("commodity_name"));
				commodity.setCommodity_type(Integer.parseInt(rs.getString("commodity_type")));
				commodity.setUsername(rs.getString("username"));
				commodity.setDatetime(rs.getTimestamp("datetime").toString());
				commodity.setCommodity_money(rs.getString("commodity_money"));
				commodity.setCommodity_school(rs.getInt("commodity_school"));
				commodity.setImg(rs.getString("img"));
				commodities.add(commodity);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return commodities;
	}

	public List<Commodity> findBySchool(int school) {
		List<Commodity> commodities = new ArrayList<Commodity>();
		String sql = "select * from commodity_info where commodity_school = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, school);
			rs = ps.executeQuery();
			while (rs.next()) {
				Commodity commodity = new Commodity();
				commodity.setId(Integer.parseInt(rs.getString("id")));
				commodity.setCommodity_content(rs.getString("commodity_content"));
				commodity.setCommodity_name(rs.getString("commodity_name"));
				commodity.setCommodity_type(Integer.parseInt(rs.getString("commodity_type")));
				commodity.setUsername(rs.getString("username"));
				commodity.setDatetime(rs.getTimestamp("datetime").toString());
				commodity.setCommodity_money(rs.getString("commodity_money"));
				commodity.setCommodity_school(rs.getInt("commodity_school"));
				commodity.setImg(rs.getString("img"));
				commodities.add(commodity);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return commodities;
	}
	@Override
	public int getAllContent() {
		int count = 0;
		String sql = "select count(id) as count from commodity_info";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				count = rs.getInt("count");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return count;
	}

	@Override
	public List<Commodity> findAllPaging(String keyWord, int currentPage, int pageSize) {
		List<Commodity> commodities = new ArrayList<Commodity>();
		if (keyWord != null) {
			String sql = "select * from Commodity_info where commodity_type = ? limit ?,?";
			try {
				ps = con.prepareStatement(sql);
				ps.setInt(1, Integer.parseInt(keyWord));
				ps.setInt(2, (currentPage - 1) * pageSize);
				ps.setInt(3, pageSize);
				rs = ps.executeQuery();
				while (rs.next()) {
					Commodity commodity = new Commodity();
					commodity.setId(Integer.parseInt(rs.getString("id")));
					commodity.setCommodity_content(rs.getString("commodity_content"));
					commodity.setCommodity_name(rs.getString("commodity_name"));
					commodity.setCommodity_type(Integer.parseInt(rs.getString("commodity_type")));
					commodity.setUsername(rs.getString("username"));
					commodity.setDatetime(rs.getTimestamp("datetime").toString());
					commodity.setCommodity_money(rs.getString("commodity_money"));
					commodity.setCommodity_school(rs.getInt("commodity_school"));
					commodity.setImg(rs.getString("img"));
					commodities.add(commodity);
				}
			} catch (NumberFormatException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else {
			String sql = "select * from Commodity_info limit ?,?";
			try {
				ps = con.prepareStatement(sql);
				ps.setInt(1, (currentPage - 1) * pageSize);
				ps.setInt(2, pageSize);
				rs = ps.executeQuery();
				while (rs.next()) {
					Commodity commodity = new Commodity();
					commodity.setId(Integer.parseInt(rs.getString("id")));
					commodity.setCommodity_content(rs.getString("commodity_content"));
					commodity.setCommodity_name(rs.getString("commodity_name"));
					commodity.setCommodity_type(Integer.parseInt(rs.getString("commodity_type")));
					commodity.setUsername(rs.getString("username"));
					commodity.setDatetime(rs.getTimestamp("datetime").toString());
					commodity.setCommodity_money(rs.getString("commodity_money"));
					commodity.setCommodity_school(rs.getInt("commodity_school"));
					commodity.setImg(rs.getString("img"));
					commodities.add(commodity);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return commodities;
	}

	@Override
	public Commodity findByName(String k) {
		return null;
	}

	@Override
	public Commodity findById(int id) {
		Commodity commodity = new Commodity();
		String sql = "select * from commodity_info where id = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				commodity.setId(Integer.parseInt(rs.getString("id")));
				commodity.setCommodity_content(rs.getString("commodity_content"));
				commodity.setCommodity_name(rs.getString("commodity_name"));
				commodity.setCommodity_type(Integer.parseInt(rs.getString("commodity_type")));
				commodity.setUsername(rs.getString("username"));
				commodity.setDatetime(rs.getTimestamp("datetime").toString());
				commodity.setCommodity_money(rs.getString("commodity_money"));
				commodity.setCommodity_school(rs.getInt("commodity_school"));
				commodity.setImg(rs.getString("img"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return commodity;
	}

}
