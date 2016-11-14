package com.office.dao;

import java.util.List;

import com.office.common.dao.IBaseDao;
import com.office.dto.Chengyu;
import com.office.entity.TChengyu;

public interface IChengyuDao extends IBaseDao<TChengyu> {
	
	List<TChengyu> findChengyuByChengyu(Chengyu chengyu);
	
	List<TChengyu> findChengyuByModel(Chengyu chengyu);
	
	Integer findCountByModel(Chengyu chengyu);

}
