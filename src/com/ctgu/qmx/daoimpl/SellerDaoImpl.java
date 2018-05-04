package com.ctgu.qmx.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.ctgu.qmx.bean.User;
import com.ctgu.qmx.dao.IBaseDao;
import com.ctgu.qmx.utils.DBUtils;

public class SellerDaoImpl implements IBaseDao<String, User>{

	private Connection con;
	private PreparedStatement ps;
	ResultSet rs;
	public SellerDaoImpl() {
		try {
			this.con = DBUtils.getCon();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public boolean doInsert(User v) {
		String sql = "insert into seller_info(username,password,name,sex,age,address,phone) values(?,?,?,?,?,?,?)";
		try {
			this.ps = con.prepareStatement(sql);
			ps.setString(1, v.getUsername());
			ps.setString(2, v.getPassword());
			ps.setString(3, v.getName());
			ps.setString(4, v.getSex());
			ps.setInt(5, v.getAge());
			ps.setString(6, v.getAddress());
			ps.setString(7, v.getPhone());
			if(ps.executeUpdate() > 0){
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean doDelete(String k) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean doUpdate(User v) {
		String sql = "update seller_info set password = ?,name = ?,sex = ?,age = ?,address = ?,phone = ? WHERE username ="+v.getUsername();
		try {
			this.ps = con.prepareStatement(sql);
			ps.setString(1, v.getPassword());
			ps.setString(2, v.getName());
			ps.setString(3, v.getSex());
			ps.setInt(4, v.getAge());
			ps.setString(5, v.getAddress());
			ps.setString(6, v.getPhone());
			if(ps.executeUpdate() > 0){
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public User findByName(String k) {
		String sql = "select * from seller_info where username = ?";
		User user = null;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, k);
			rs = ps.executeQuery();
			while(rs.next()){
				user = new User();
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setName(rs.getString("name"));
				user.setSex(rs.getString("sex"));
				user.setAge(rs.getInt("age"));
				user.setAddress(rs.getString("address"));
				user.setPhone(rs.getString("phone"));
			}
			return user;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public int getAllContent() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public List<User> findAllPaging(String keyWord, int currentPage, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public User findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
