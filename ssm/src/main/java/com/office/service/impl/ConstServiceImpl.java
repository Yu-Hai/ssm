package com.office.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.office.common.service.impl.BaseServiceImpl;
import com.office.dao.IConstDao;
import com.office.entity.TConst;
import com.office.service.IConstService;

@Service
public class ConstServiceImpl extends BaseServiceImpl<TConst> implements IConstService {
	@Autowired
	IConstDao constDao;

}
