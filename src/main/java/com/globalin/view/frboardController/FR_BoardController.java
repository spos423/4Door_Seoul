package com.globalin.view.frboardController;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.globalin.biz.dboard.D_BoardVO;
import com.globalin.biz.dboard.service.D_BoardService;
import com.globalin.biz.frboard.FR_BoardVO;
import com.globalin.biz.frboard.service.FR_BoardService;



@Controller
@SessionAttributes("frboard")
public class FR_BoardController {
    
	
	@Autowired
	private FR_BoardService boardService;
	@Autowired
	private D_BoardService dboardService;

	
	//글 입력
	@RequestMapping(value="/frboard/insertBoard.do")
	public String insertBoard(FR_BoardVO vo) throws IOException{
	    
		MultipartFile uploadFile = vo.getUploadFile();
		
		/*
		 * if(!uploadFile.isEmpty()) { String filename =
		 * uploadFile.getOriginalFilename(); uploadFile.transferTo(new
		 * File("C:\\Users\\USER\\eee"+filename)); }
		 */
		
	boardService.insertBoard(vo);
		
	return "redirect:/frboard/getBoardList.do";
	}
	
	//글 수정
	@RequestMapping("/frboard/updateBoard.do")
	public String updateBoard(@ModelAttribute("frboard") FR_BoardVO vo) {
	
	    boardService.updateBoard(vo);
	
	return "redirect:/frboard/getBoardList.do";
	}
	
	//글 삭제
	@RequestMapping("/frboard/deleteBoard.do")
	public String deleteBoard(FR_BoardVO vo) {
		
		
		boardService.deleteBoard(vo);
		
		return "redirect:/frboard/getBoardList.do";
	}
	
	
	//글 상세조회
	@RequestMapping(value= "/frboard/getBoard.do")
	public String getBoard(FR_BoardVO vo , Model model,int num) throws Exception {
		boardService.readcount(vo);
		
		FR_BoardVO frboard = boardService.getBoard(vo);
		model.addAttribute("frboard", boardService.getBoard(vo));
		
		 
		  
		 model.addAttribute("dboard", dboardService.getDBoardList(num));
		
		   
		
		
		
		return "getBoard.jsp";
	}
	

	
	 // 검색 조건 목록 설정
		@ModelAttribute("conditionMap")
		public Map<String, String> searchConditionMap() {
			
			Map<String, String> conditionMap = new HashMap<String, String>();
			conditionMap.put("제목", "TITLE");
			conditionMap.put("내용", "CONTENT");
			conditionMap.put("작성자", "writer");
			return conditionMap;
		}
	
	// 글 목록 조회
	@RequestMapping("/frboard/getBoardList.do")
	public String getBoarList(FR_BoardVO vo, Model model) {
		
		System.out.println("==============");
		System.out.println("===컨트롤 진입===");
		System.out.println("==============");
		System.out.println("조건 : " + vo.getSearchCondition());
		System.out.println("검색어 : "+vo.getSearchKeyword());
		
		if(vo.getSearchCondition() == null)
			vo.setSearchCondition("TITLE");
		
		if(vo.getSearchKeyword() == null)
			vo.setSearchKeyword("");
		
		
		model.addAttribute("frboardList",boardService.getBoardList(vo));
		
		return "/frboard/getBoardList.jsp";
		
		
	}


		
		
		
}
