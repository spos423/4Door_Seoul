package com.globalin.view.frboardController;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import com.globalin.biz.frboard.FR_BoardVO;
import com.globalin.biz.frboard.service.FR_BoardService;

@Controller
@SessionAttributes("frboard")
public class FR_BoardController {
    
	@Autowired
	private FR_BoardService boardService;
	
	//글 입력
	@RequestMapping(value="/main/board/insertBoard.do")
	public String insertBoard(FR_BoardVO vo) throws IOException{
	    
		MultipartFile uploadFile = vo.getUploadFile();
		
		/*
		 * if(!uploadFile.isEmpty()) { String filename =
		 * uploadFile.getOriginalFilename(); uploadFile.transferTo(new
		 * File("C:\\Users\\USER\\eee"+filename)); }
		 */
		
	boardService.insertBoard(vo);
		
	return "redirect:/main/board/getBoardList.do";
	}
	
	//글 수정
	@RequestMapping("/main/board/updateBoard.do")
	public String updateBoard(@ModelAttribute("frboard") FR_BoardVO vo) {
	
	    boardService.updateBoard(vo);
	
	return "redirect:/main/board/getBoardList.do";
	}
	
	//글 삭제
	@RequestMapping("/main/board/deleteBoard.do")
	public String deleteBoard(FR_BoardVO vo) {
		
		
		boardService.deleteBoard(vo);
		
		return "redirect:/main/board/getBoardList.do";
	}
	
	
	//글 상세조회
	@RequestMapping(value= "/main/board/getBoard.do")
	public String getBoard(FR_BoardVO vo , Model model) {
		boardService.readcount(vo);
		
		model.addAttribute("frboard", boardService.getBoard(vo));

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
	@RequestMapping("/main/board/getBoardList.do")
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
		
		return "/main/board/getBoardList.jsp";
		
		
	}
}
