package com.office.service;

import java.util.List;

import com.office.common.exception.BusinessException;
import com.office.common.service.IBaseService;
import com.office.dto.Chengyu;
import com.office.entity.TChengyu;

public interface IChengyuService extends IBaseService<TChengyu> {
	
	public List<TChengyu> findChengyuByChengyu(Chengyu chengyu)throws BusinessException;
	
	public List<TChengyu> findChengyuByModel(Chengyu chengyu)throws BusinessException;
	
	public Integer findCountByModel(Chengyu chengyu)throws BusinessException;

}
