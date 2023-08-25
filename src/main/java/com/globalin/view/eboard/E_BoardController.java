package com.globalin.view.eboard;

//import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
//import org.springframework.web.multipart.MultipartFile;

import com.globalin.biz.eboard.E_BoardVO;
import com.globalin.biz.eboard.ipml.E_BoardService;

//@Controller
//@SessionAttributes("E_Board")
public class E_BoardController {
	
	//@Autowired
	private E_BoardService e_boardService;
	
	
	//@RequestMapping("/biz/event/insertE_Board.do")
	public String insertBoard(E_BoardVO vo) throws IOException {
		
		System.out.println("湲� �벑濡� 泥섎━");
		/*
		MultipartFile uploadFile = vo.getUploadFile();
		if(!uploadFile.isEmpty()) {
			String filename = uploadFile.getOriginalFilename();
			uploadFile.transferTo(new File("C:/ddd/"+filename));
		}
		*/
		e_boardService.insertBoard(vo);
		return "redirect:/event/eventlist.jsp";
	}
	
	@RequestMapping("/eventlist.do")
	public String searchBoardList(E_BoardVO vo) {
		
		
		return "/event/eventlist.jsp";
	}
}
