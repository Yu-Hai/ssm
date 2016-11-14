package com.office.common.service;

import java.util.List;

import com.office.common.bean.ReturnData;
import com.office.common.exception.BusinessException;

public interface IBaseService<T> {

	ReturnData insert(T t) throws BusinessException;

	ReturnData delete(T t) throws BusinessException;

	ReturnData batchDelete(T[] info) throws BusinessException;

	ReturnData update(T t) throws BusinessException;

	List<T> findAll() throws BusinessException;

	T findById(T t) throws BusinessException;
	
	T findByObj(T t) throws BusinessException;

	List<T> getListByObj(T t) throws BusinessException;

	Integer getCountByObj(T t) throws BusinessException;

}
