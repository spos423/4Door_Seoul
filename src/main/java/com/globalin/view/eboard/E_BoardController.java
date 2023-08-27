package com.globalin.view.eboard;

import java.io.File;
//import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
//import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartFile;

import com.globalin.biz.eboard.E_BoardVO;
import com.globalin.biz.eboard.impl.E_BoardDAO;

@Controller(value="e_boardService")
@SessionAttributes("e_board")
public class E_BoardController {
	
	@RequestMapping("/event/insertE_Board.do")
	public String insertE_Board(E_BoardVO vo, E_BoardDAO dao, 
	@RequestParam(value="startdate") String startdate,
	@RequestParam(value="enddate") String enddate, HttpServletRequest request,
	@RequestParam(value="thumb_img1") MultipartFile thumb_img1) throws IOException {
		
		thumb_img1 = vo.getThumb_img1();
		if(!thumb_img1.isEmpty()) {
			
			String filename = thumb_img1.getOriginalFilename();
			thumb_img1.transferTo(new File(request.getSession().getServletContext().getRealPath("/event/upload/") + filename));
			
			String savepath = "./upload/" + filename;
			System.out.println(savepath);
			vo.setImg1_url(savepath);
			
		}
		
		dao.insertBoard(vo);
		return "redirect:/event/eventForm_Proc.jsp";
	}
	
	@RequestMapping("/event/eventlist.do")
	public String getE_BoardList(E_BoardVO vo, E_BoardDAO dao, Model model,
			@RequestParam(value="pageNum", required=false) String pageNum, 
			@RequestParam(value="searchCondition", required=false) String searchCondition,
			@RequestParam(value="keyword", required=false) String keyword,
			@RequestParam(value="search_startDate", required=false) String search_startDate, 
			@RequestParam(value="search_endDate", required=false) String search_endDate,
			@RequestParam(value="status", required=false) String status) {
		
	    if(pageNum == null) {
	        pageNum = "1";
	    }
	      
	    int pageSize = 4;
	    int currentPage = Integer.parseInt(pageNum);
	      
	    int startRow = (currentPage-1)*pageSize+1;
	    int endRow = currentPage*pageSize;
	      
	    int count = 0;
	    int number = 0;
	      
	    //키워드 검색을 위한 변수선언
	    if(searchCondition==null)  searchCondition = "title";
	    if(keyword==null) keyword = "";
	     
	    List<E_BoardVO> e_boardList = null;
	      
	    if(search_startDate != null && search_endDate != null || status != null) {
	    	count = dao.getArticleCount(search_startDate, search_endDate, status);
	    } else {
	    	count = dao.getArticleCount(searchCondition, keyword);
	    }
	    
	    if(count > 0) {
	    	if(search_startDate != null && search_endDate != null || status != null) {
	    		e_boardList = dao.getBoardList(startRow, endRow, search_startDate, search_endDate, status);
	    		
	    	} else {
	    		e_boardList = dao.getBoardList(startRow, endRow, searchCondition, keyword);
	    	}
	    	 
	    }else {
	    	e_boardList = Collections.emptyList();
	    }
	      // 글 목록에 표시할 글 번호
	      number = count-(currentPage-1)*pageSize;
	      
	      // 해당 뷰에서 사용할 속성 저장
	      model.addAttribute("currentPage", new Integer(currentPage));
	      model.addAttribute("startRow", new Integer(startRow));
	      model.addAttribute("endRow", new Integer(endRow));
	      model.addAttribute("count", new Integer(count));
	      model.addAttribute("pageSize", new Integer(pageSize));
	      model.addAttribute("number", new Integer(number));
	      model.addAttribute("e_boardList", e_boardList);
	      model.addAttribute("searchCondition", new String(searchCondition));
	      model.addAttribute("keyword", new String(keyword));

		return "/event/eventlist.jsp";
	}
	
	@RequestMapping("/event/eventboard.do")
	public String getE_Board(E_BoardVO vo, E_BoardDAO dao, Model model, 
			@RequestParam(value="num", required=false)String num) {
		
		E_BoardVO e_board = new E_BoardVO(); 
		
		e_board = dao.getBoard(vo, num);
		
		model.addAttribute("e_board", e_board);
		
		return "/event/eventboard.jsp";
	}
	
	@RequestMapping("/event/deleteE_Board.do")
	public String deleteE_Board(E_BoardVO vo, E_BoardDAO dao, 
		@RequestParam(value="num")String num) {
		
		System.out.println("/event/deleteE_Board.do : 컨트롤러 진입 확인");
		
		vo.setNum(Integer.parseInt(num));
		dao.deleteBoard(vo);
		
		return "/event/eventlist.do";
	}
	
	
	
	
}
