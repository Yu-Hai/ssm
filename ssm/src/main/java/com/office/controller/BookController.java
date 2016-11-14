package com.office.controller;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.office.common.bean.ReturnData;
import com.office.common.controller.BaseController;
import com.office.common.exception.BusinessException;
import com.office.entity.TBook;
import com.office.service.IBookService;

@Controller
@RequestMapping("/book")
public class BookController extends BaseController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private IBookService bookService;

	@RequestMapping("/list.do")
	private ModelAndView list() {
		List<TBook> list = null;
		try {
			list = bookService.findAll();
		} catch (BusinessException e) {
			logger.error("查询TBook List 失败！",e);
		}
		logger.info("list 出参=====>>>:"+list);
		return success(list, "list");
	}
	
	@RequestMapping("toEditUI.do")
	private ModelAndView toEditUI(TBook book){
		logger.info("toEditUI 入参======>>>:"+book);
		TBook _book=null;
		try {
			if (!StringUtils.isEmpty(book.getIdBook())) {
				_book=bookService.findById(book);
			}
		} catch (BusinessException e) {
			logger.error("查询TBook 失败！",e);
		} catch (Exception e) {
			logger.error("查询TBook 失败！",e);
		}
		logger.info("toEditUI 入参======>>>:"+_book);
		return success("edit").addObject("book", _book);
	}
	
	@RequestMapping("/addBook.do")
	private ModelAndView addBook(TBook book){
		logger.info("addBook 入参=====>>>:"+book);
		ReturnData returnData=null;
		try {
			returnData=bookService.insert(book);
		} catch (BusinessException e) {
			logger.error("保存TBook 失败！",e);
		} catch (Exception e) {
			logger.error("保存TBook 失败！",e);
		}
		if(returnData.isSuccess()){
			return list();
		}else {
			return toEditUI(book).addObject("book", book);
		}
	}

	@Override
	protected String getForwardPrefix() {
		return "book";
	}

}
