package com.ctgu.qmx.service;

import java.util.ArrayList;
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
		List<Comment> comments1 = commentDaoImpl.findAll();
		List<Comment> comments2 = new ArrayList<Comment>();
		for(int i = 0;i < comments1.size();i++){
			if(comments1.get(i).getId() == commodity_id){
				comments2.add(comments1.get(i));
			}
		}
		return comments2;
	}
}
