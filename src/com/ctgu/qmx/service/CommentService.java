package com.ctgu.qmx.service;

import java.util.List;

import com.ctgu.qmx.bean.Comment;
import com.ctgu.qmx.daoimpl.CommentDaoImpl;

public class CommentService {
	CommentDaoImpl commentDaoImpl;

	public CommentService() {
		commentDaoImpl = new CommentDaoImpl();
	}

	public boolean commentInsert(Comment comment) {
		if (commentDaoImpl.doInsert(comment)) {
			return true;
		}
		return false;
	}

	public List<Comment> getComment(int commodity_id) {
		List<Comment> comments1 = commentDaoImpl.findId(commodity_id);
		return comments1;
	}
}
