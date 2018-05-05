package com.ctgu.qmx.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ctgu.qmx.bean.Comment;
import com.ctgu.qmx.dao.IBaseDao;
import com.ctgu.qmx.utils.DBUtils;

public class CommentDaoImpl implements IBaseDao<String, Comment> {
	private Connection con;
	private PreparedStatement ps;
	ResultSet rs;
	public CommentDaoImpl() {
		try {
			this.con = DBUtils.getCon();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public boolean doInsert(Comment v) {
		String sql = "insert into commodity_comment(username,commodity_id,content) values(?,?,?)";
		try {
			this.ps = con.prepareStatement(sql);
			ps.setString(1, v.getUsername());
			ps.setInt(2, v.getCommodity_id());
			ps.setString(3, v.getContent());
			if(ps.executeUpdate() > 0){
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
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean doUpdate(Comment v) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Comment> findAll() {
		List<Comment> comments = new ArrayList<Comment>();
		String sql = "select * from commodity_comment";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				Comment comment = new Comment();
				comment.setId(rs.getInt("id"));
				comment.setUsername(rs.getString("username"));
				comment.setCommodity_id(rs.getInt("commodity_id"));
				comment.setContent(rs.getString("content"));
				comment.setDatetime(rs.getTimestamp("datetime").toString());
				comments.add(comment);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return comments;
	}

	@Override
	public List<Comment> findAllPaging(String keyWord, int currentPage, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getAllContent() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public Comment findByName(String k) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Comment findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public List<Comment> findId(int id){
		List<Comment> comments = new ArrayList<Comment>();
		String sql = "select * from commodity_comment";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				Comment comment = new Comment();
				comment.setId(Integer.parseInt(rs.getString("id")));
				comment.setUsername(rs.getString("username"));
				comment.setDatetime(rs.getTimestamp("datetime").toString());
				comment.setContent(rs.getString("content"));
				comments.add(comment);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return comments;
	}

}
