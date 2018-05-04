package com.ctgu.qmx.dao;

import java.util.List;

public interface IBaseDao<K,V> {
	public boolean doInsert(V v);
	public boolean doDelete(K k);
	public boolean doUpdate(V v);
	public V findByName(K k);
	public V findById(int id);
	public List<V> findAll();
	public List<V> findAllPaging(String keyWord,int currentPage,int pageSize);
	public int getAllContent();
}
