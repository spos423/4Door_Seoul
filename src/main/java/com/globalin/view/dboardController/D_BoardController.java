package com.globalin.view.dboardController;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.globalin.biz.dboard.D_BoardVO;
import com.globalin.biz.dboard.service.D_BoardService;
import com.globalin.biz.frboard.FR_BoardVO;
import com.globalin.biz.frboard.service.FR_BoardService;

@Controller
@SessionAttributes("dboard")
public class D_BoardController {

    @Autowired
    private D_BoardService dboardService;
    @Autowired
    private FR_BoardService boardService;
   

    @RequestMapping(value="/frboard/insertDBoard.do")
    public String insertDBoard(D_BoardVO vo,FR_BoardVO num) {
    	boardService.getBoard(num);
        dboardService.insertDBoard(vo);
        int a = vo.getD_num();
        System.out.println(a);
        return "redirect:/frboard/getBoard.do?num="+ vo.getD_num();
    }
    
    @RequestMapping("/frboard/updateDBoard.do")
    public String updateDBoard(@ModelAttribute("dboard") D_BoardVO vo) {
    	
        dboardService.updateDBoard(vo);
        return "redirect:/frboard/getBoard.do?num=" + vo.getD_num();
    }

    @RequestMapping("/frboard/deleteDBoard.do")
    public String deleteDBoard(D_BoardVO vo,FR_BoardVO num ) {
    	
        dboardService.deleteDBoard(vo);
        
        
        return "redirect:/frboard/getBoard.do?num=" + num.getNum();
    }
}