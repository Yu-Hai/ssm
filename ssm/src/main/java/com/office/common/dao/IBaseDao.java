package com.office.common.dao;

import java.util.List;

public interface IBaseDao<T> {

	int insert(T t);

	int delete(T t);
	
	int batchDelete(T[] info);

	int update(T t);

	List<T> findAll();
	
	T findById(T t);
	
	T findByObj(T t);

	List<T> getListByObj(T t);

	Integer getCountByObj(T t);

}

