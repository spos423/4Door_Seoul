package com.globalin.view.gmboardController;

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

import com.globalin.biz.gmboard.GM_BoardVO;
import com.globalin.biz.gmboard.service.GM_BoardService;



@Controller
@SessionAttributes("gmboard")
public class GM_BoardController {
    
	@Autowired
	private GM_BoardService boardService;
	
	//글 입력
	@RequestMapping(value="/gmboard/insertgmBoard.do")
	public String insertgmBoard(GM_BoardVO vo) throws IOException{
	    
		/*
		 * MultipartFile uploadFile = vo.getUploadFile();
		 * 
		 * if(!uploadFile.isEmpty()) { String filename =
		 * uploadFile.getOriginalFilename(); uploadFile.transferTo(new
		 * File("C:\\Users\\USER\\eee"+filename)); }
		 */
		
	boardService.insertgmBoard(vo);
		
	return "redirect:/gmboard/getgmBoardList.do";
	}
	
	//글 수정
	@RequestMapping("/gmboard/updategmBoard.do")
	public String updategmBoard(@ModelAttribute("gmboard") GM_BoardVO vo) {
	
	    boardService.updategmBoard(vo);
	
	return "redirect:/gmboard/getgmBoardList.do";
	}
	
	//글 삭제
	@RequestMapping("/gmboard/deletegmBoard.do")
	public String deletegmBoard(GM_BoardVO vo) {
		
		
		boardService.deletegmBoard(vo);
		
		return "redirect:/gmboard/getgmBoardList.do";
	}
	
	
	//글 상세조회
	@RequestMapping(value= "/gmboard/getgmBoard.do")
	public String getBoard(GM_BoardVO vo , Model model) {
		boardService.readcount(vo);
		
		model.addAttribute("gmboard", boardService.getgmBoard(vo));

		return "getgmBoard.jsp";
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
	@RequestMapping("/gmboard/getgmBoardList.do")
	public String getBoarList(GM_BoardVO vo, Model model) {
		
		System.out.println("==============");
		System.out.println("===컨트롤 진입===");
		System.out.println("==============");
		System.out.println("조건 : " + vo.getSearchCondition());
		System.out.println("검색어 : "+vo.getSearchKeyword());
		
		if(vo.getSearchCondition() == null)
			vo.setSearchCondition("TITLE");
		
		if(vo.getSearchKeyword() == null)
			vo.setSearchKeyword("");
		
		
		model.addAttribute("gmboardList",boardService.getgmBoardList(vo));
		
		return "/gmboard/getgmBoardList.jsp";
		
		
	}
}
