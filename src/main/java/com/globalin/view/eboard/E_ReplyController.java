package com.globalin.view.eboard;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.globalin.biz.eboard.E_ReplyVO;
import com.globalin.biz.eboard.impl.E_ReplyDAO;

@Controller
@SessionAttributes("e_reply")
public class E_ReplyController {
	
	@RequestMapping("/event/insertE_Reply.do")
	public String insertBoard(E_ReplyVO vo, E_ReplyDAO dao) throws IOException {
		
		
		return null;
	}
	
	
}
