package com.globalin.biz;

import java.text.SimpleDateFormat;
import java.sql.Timestamp;
import java.sql.Date;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.globalin.biz.eboard.E_BoardVO;
import com.globalin.biz.eboard.ipml.E_BoardService;



public class E_BoardClient {

	public static void main(String[] args) {
		// 1. Spring 컨테이너 구동
		AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext.xml");
		
		// 2. Spring 컨테이너로부터 BoardServiceImpl(서비스)객체를 요청
		E_BoardService boardService = (E_BoardService)factory.getBean("E_BoardService");
		
		
		
		Date date = new Date(System.currentTimeMillis());
		SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		System.out.println(date);
		System.out.println(formatter.format(date));
		// 3. 글 등록 테스트
		E_BoardVO vo = new E_BoardVO();
		vo.setTitle("1111");
		vo.setContent("1111");
		vo.setZipcode(1111);
		vo.setAddress("1111");
		vo.setTraf("1111");
		vo.setPrice("1111");
		vo.setStartdate(new Timestamp(System.currentTimeMillis()));
		vo.setEnddate(new Timestamp(System.currentTimeMillis()));
		vo.setTel("111-1111-1111");
		vo.setUri("1111");
		vo.setWriter("1111");
		vo.setWritedate(new Timestamp(System.currentTimeMillis()));
		vo.setUpdater("1111");
		vo.setUpdatedate(new Timestamp(System.currentTimeMillis()));
		
		boardService.insertBoard(vo);
	}

}
