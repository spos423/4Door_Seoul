package com.globalin.view.eboard;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.globalin.biz.eboard.E_BoardVO;
import com.globalin.biz.eboard.impl.E_BoardDAO;

public class InsertE_BoardController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String zipcode = request.getParameter("zipcode");
		String address = request.getParameter("address");;
		String traf = request.getParameter("traf");;
		String price = request.getParameter("price");
		Timestamp startdate = Timestamp.valueOf(request.getParameter("startdate").substring(0, 10) +" "+ request.getParameter("startdate").substring(11)+":00");
		Timestamp enddate = Timestamp.valueOf(request.getParameter("enddate").substring(0, 10) +" "+ request.getParameter("enddate").substring(11)+":59");
		String tel = request.getParameter("tel");
		String uri = request.getParameter("uri");
		String writer = request.getParameter("writer");
		Timestamp writedate = new Timestamp(System.currentTimeMillis());
		String updater = request.getParameter("writer");;
		Timestamp updatedate  = new Timestamp(System.currentTimeMillis());
		String img1_url = request.getParameter("url_1");
		
		E_BoardVO vo = new E_BoardVO();
		vo.setTitle(title);
		vo.setContent(content);
		vo.setZipcode(Integer.parseInt(zipcode));
		vo.setAddress(address);
		vo.setTraf(traf);
		vo.setPrice(price);
		vo.setStartdate(startdate);
		vo.setEnddate(enddate);
		vo.setTel(tel);
		vo.setUri(uri);
		vo.setWriter(writer);
		vo.setWritedate(writedate);
		vo.setUpdater(updater);
		vo.setUpdatedate(updatedate);
		vo.setImg1_url(img1_url);
		
		E_BoardDAO boardDAO = new E_BoardDAO();
		boardDAO.insertBoard(vo);
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:eventForm_Proc.jsp");
		return mav;
	}
}
