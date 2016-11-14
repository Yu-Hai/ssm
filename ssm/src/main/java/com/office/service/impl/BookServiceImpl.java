package com.office.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.office.common.service.impl.BaseServiceImpl;
import com.office.dao.IBookDao;
import com.office.entity.TBook;
import com.office.service.IBookService;

@Service
public class BookServiceImpl extends BaseServiceImpl<TBook> implements IBookService {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	// 注入Service依赖
	@Autowired
	private IBookDao bookDao;



	
}
