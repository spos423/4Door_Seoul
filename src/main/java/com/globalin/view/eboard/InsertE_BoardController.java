package com.globalin.view.eboard;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.multipart.MultipartRequest;
import org.springframework.web.servlet.ModelAndView;

import com.globalin.biz.eboard.E_BoardVO;
import com.globalin.biz.eboard.impl.E_BoardDAO;
//import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.globalin.biz.eboard.impl.E_BoardService;


public class InsertE_BoardController {
	
	E_BoardService e_boardService;
	
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		//String uploadPath = request.getSession().getServletContext().getRealPath("/"); //saveDirectory
		//int size = 10*1024*1024; //  10MB(단위는 byte), maxPostSize
		//DefaultFileRenamePolicy renamepolicy = new DefaultFileRenamePolicy();
		
		//MultipartRequest multi = new MultipartRequest(request, uploadPath, size, "utf-8", renamepolicy);
		
		String title = request.getParameter("title");
		System.out.println(title);
		String content = request.getParameter("content");
		System.out.println(content);
		String zipcode = request.getParameter("zipcode");
		System.out.println(zipcode);
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
	
	@RequestMapping("/event/eventlist.do")
	public String getBoardList(E_BoardVO vo) {
		
		return "/event/eventlist.jsp";
	}
	
}
