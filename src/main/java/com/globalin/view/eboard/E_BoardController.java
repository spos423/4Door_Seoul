package com.globalin.view.eboard;

import java.io.File;
//import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
//import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartFile;

import com.globalin.biz.eboard.E_BoardVO;
import com.globalin.biz.eboard.impl.E_BoardDAO;

@Controller(value="e_boardService")
@SessionAttributes("e_board")
public class E_BoardController {
	
	@RequestMapping("/event/insertE_Board.do")
	public String insertBoard(E_BoardVO vo, E_BoardDAO dao) throws IOException {
		
		System.out.println("글 등록 처리");
	
		MultipartFile thumb_img1 = vo.getThumb_img1();
		if(!thumb_img1.isEmpty()) {
			
			String filename = thumb_img1.getOriginalFilename();
			thumb_img1.transferTo(new File("C:/ddd/"+filename));
		}
		
		dao.insertBoard(vo);
		return "/event/eventForm_Proc.jsp";
	}
	
	@RequestMapping("/event/eventlist.do")
	public String getE_BoardList(E_BoardVO vo) {
		
		return "/event/eventlist.jsp";
	}
}
