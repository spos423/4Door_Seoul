package com.globalin.view.travel;

import java.io.File;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.globalin.biz.travel.t_boardVO;
import com.globalin.biz.travel.impl.t_boardDAO;

@Controller
public class t_boardController {

	/*
		게시글 목록 조회 컨트롤러
	*/
	@RequestMapping("t_list.traveldo")
	public String getBoardList(
			@RequestParam(value = "searchKeyword", defaultValue = "", required = false) String searchKeyword,
			@RequestParam(value = "pageNum", defaultValue = "1", required = false) String pageNum,
			@RequestParam(value = "date_start", defaultValue = "", required = false) String date_start,
			@RequestParam(value = "date_end", defaultValue = "", required = false) String date_end,
			t_boardVO vo, t_boardDAO board, Model model, HttpServletRequest request) {
		
		System.out.println("@Controller @RequestMapping 게시글 목록 조회 처리");
	
		
		// 현재 페이지
		int currentPage = 1;
		
		if(pageNum.equals("")) {
			pageNum = "1";
		} else {
			currentPage = Integer.parseInt(pageNum);
		}
		
		// 해당 페이지 내에서 게시글 최대 개수
		int boardSize = 4;
		
		// 해당 페이지 내에서 첫번째 게시글의 번호
		int startRow = (currentPage - 1) * boardSize + 1;
		
		// 해당 페이지 내에서 마지막 게시글의 번호
		int endRow = currentPage * boardSize;
		
		// 게시물 총 개수
		int count = 0;
		
		
		List<t_boardVO> boardList = new ArrayList<t_boardVO>();
		
		
		if(vo.getCt_u()==0) { // 축제&행사
			
			// 검색 - 이용 기간 (시작)
			if(request.getParameter("date_start")!= null && !request.getParameter("date_start").isEmpty()) {
				date_start = request.getParameter("date_start").substring(0, 10);
			}
		
			// 검색 - 이용 기간 (종료)
			if(request.getParameter("date_end") != null && !request.getParameter("date_end").isEmpty()) {
				date_end = request.getParameter("date_end").substring(0, 10);
			}
			
			if(searchKeyword.equals("")) {
				if(date_start.equals("") && date_end.equals("")) { //  검색 X
					count = board.getBoardCount(vo);
					boardList = board.getBoardList(vo, startRow, endRow);
				} else { // 기간 검색 O
					count = board.getBoardCount(vo, date_start, date_end);
					boardList = board.getBoardList(vo, date_start, date_end, startRow, endRow);
				}
			} else { // 검색어 O
				count = board.getBoardCount(vo, searchKeyword);
				boardList = board.getBoardList(vo, searchKeyword, startRow, endRow);
			}
			
			// Model 정보를 저장
			model.addAttribute("date_start", date_start);
			model.addAttribute("date_end", date_end);
			
		} else { // 볼거리, 먹거리
			if(vo.getCt_d()==0) {
				vo.setCt_d(9);;
			}
			
			if(searchKeyword.equals("")) { // 검색 X
				count = board.getBoardCount(vo);
				boardList = board.getBoardList(vo, startRow, endRow);
			} else { // 검색어 O
				count = board.getBoardCount(vo, searchKeyword);
				boardList = board.getBoardList(vo, searchKeyword, startRow, endRow);
			}
			
		}
		
		
		// 게시물 총 개수 중 해당 페이지에서 출력할 게시글 번호
		int number = count - (currentPage - 1) * boardSize;
		
		
		// Model 정보를 저장
		model.addAttribute("ct_u", vo.getCt_u());
		model.addAttribute("ct_d", vo.getCt_d());
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("searchKeyword", searchKeyword);
		model.addAttribute("count", count);
		model.addAttribute("number", number);
		model.addAttribute("boardList", boardList);
		model.addAttribute("boardSize", boardSize);
	
		
		if(vo.getCt_u()==0) {
			return "/travel/t_list0.jsp";
		} else if(vo.getCt_u()==1) {
			return "/travel/t_list1.jsp";
		} else {
			return "/travel/t_list2.jsp";
		}
		
	}
	
	
	/*
		게시글 상세 조회  컨트롤러
	*/
	@RequestMapping("/t_detail.traveldo")
	public String getBoard(t_boardVO vo, t_boardDAO board, Model model, HttpServletRequest request) {
		
		System.out.println("@Controller @RequestMapping 게시글 조회 처리");
		
		// 페이지 번호 처리
		String pageNum = request.getParameter("pageNum");
		
		// 파라미터로 넘어온 하위 카테고리 처리
		String ct2 = request.getParameter("ct2");
		
		// 검색 키워드 처리
		String searchKeyword = "";
		if(request.getParameter("searchKeyword")!=null) {
			searchKeyword = request.getParameter("searchKeyword");
		}
		
		// 이용기간 (시작) 처리
		String date_start = "";
		if(request.getParameter("date_start")!=null && !request.getParameter("date_start").isEmpty()) {
			date_start = request.getParameter("date_start");
		}
		
		// 이용기간 (종료) 처리
		String date_end = "";
		if(request.getParameter("date_end")!=null && !request.getParameter("date_end").isEmpty()) {
			date_end = request.getParameter("date_end");
		}
		
		System.out.println("vo.getNum() = " + vo.getNum());
		
		t_boardVO t_vo = board.getBoard(vo);
		
		// 검색 결과와 화면 정보를 ModelAndView에 저장하여 반환한다.
		
		// Model 정보 저장
		model.addAttribute("num", vo.getNum());
		model.addAttribute("pageNum", pageNum);
		model.addAttribute("ct2", ct2);
		model.addAttribute("searchKeyword", searchKeyword);
		model.addAttribute("date_start", date_start);
		model.addAttribute("date_end", date_end);
		
		model.addAttribute("ct_u", t_vo.getCt_u());
		model.addAttribute("ct_d", t_vo.getCt_d());
		model.addAttribute("title", t_vo.getTitle());
		model.addAttribute("content", t_vo.getContent().replace("\n", "<br>"));
		model.addAttribute("zipcode", t_vo.getZipcode());
		model.addAttribute("address", t_vo.getAddress());
		model.addAttribute("traffic", t_vo.getTraffic().replace("\n", "<br>"));
		model.addAttribute("open_day", t_vo.getOpen_day().replace("\n", "<br>"));
		model.addAttribute("tel", t_vo.getTel());
		model.addAttribute("write_day", t_vo.getWrite_day());
		model.addAttribute("update_day", t_vo.getUpdate_day());
		model.addAttribute("filepath", t_vo.getFilepath());
		
		
		if(t_vo.getCt_u()!=2) {	
			model.addAttribute("uri", t_vo.getUri());
			model.addAttribute("price", t_vo.getPrice().replace("\n", "<br>"));
		}else {			
			model.addAttribute("bestmenu", t_vo.getBestmenu().replace("\n", "<br>"));
		}
		
		if(t_vo.getCt_u()==0) {
			model.addAttribute("time_s", t_vo.getTime_s().toString().substring(0, 10));
			model.addAttribute("time_e", t_vo.getTime_e().toString().substring(0, 10));
		}
		
		
		return "/travel/t_detail.jsp";
	}
	

	/*
		게시글 등록페이지 컨트롤러
	*/
	@RequestMapping("/t_write.traveldo")
	public String getWriteForm(t_boardVO vo, Model model) {
		
		System.out.println("@Controller @RequestMapping 게시글 등록 페이지 이동");
		
		// Spring에서 제공하는 MVC 이용
		
		if(vo.getCt_u()==0) {
			return "/travel/t_write0.jsp";
		} else if(vo.getCt_u()==1) {
			model.addAttribute("ct_d", vo.getCt_d());
			return "/travel/t_write1.jsp";
		} else {
			model.addAttribute("ct_d", vo.getCt_d());
			return "/travel/t_write2.jsp";
		}
		
	}
	
	
	/*
		게시글 수정페이지 컨트롤러
	*/
	@RequestMapping("/t_update.traveldo")
	public String getUpdateForm(t_boardVO vo, t_boardDAO board, Model model, HttpServletRequest request) {
		
		System.out.println("@Controller @RequestMapping 게시글 수정 페이지 이동");
		
		// 게시글 목록버튼에서 쓰일 하위 카테고리 처리
		String ct2 = request.getParameter("ct2");
		
		t_boardVO t_vo = board.getBoard(vo);
		
		// 검색결과와 화면정보를 ModelAndView에 저장하고 반환
		
		// Model 정보를 저장
		model.addAttribute("num", vo.getNum());
		model.addAttribute("ct2", ct2);
		model.addAttribute("ct_d", t_vo.getCt_d());
		model.addAttribute("title", t_vo.getTitle());
		model.addAttribute("content", t_vo.getContent());
		model.addAttribute("zipcode", t_vo.getZipcode());
		model.addAttribute("address", t_vo.getAddress());
		model.addAttribute("traffic", t_vo.getTraffic());
		model.addAttribute("open_day", t_vo.getOpen_day());
		model.addAttribute("tel", t_vo.getTel());
		model.addAttribute("writer", t_vo.getWriter());
		model.addAttribute("p_filepath", t_vo.getFilepath());
		model.addAttribute("p_filename", t_vo.getFilepath().substring(18));
		
		
		// View 정보를 저장
		if(t_vo.getCt_u()==0) {
			model.addAttribute("time_s", t_vo.getTime_s());
			model.addAttribute("time_e", t_vo.getTime_e());
			model.addAttribute("price", t_vo.getPrice());
			model.addAttribute("uri", t_vo.getUri());
			
			return "/travel/t_update0.jsp";
		} else if(t_vo.getCt_u()==1) {
			model.addAttribute("price", t_vo.getPrice());
			model.addAttribute("uri", t_vo.getUri());
			
			return "/travel/t_update1.jsp";
		} else {
			model.addAttribute("bestmenu", t_vo.getBestmenu());
			
			return "/travel/t_update2.jsp";
		}
	
	}
	

	/*
		게시글 등록 처리 컨트롤러
	*/
	@RequestMapping("/t_write_proc.traveldo")
	public ModelAndView insertBoard(t_boardVO vo, t_boardDAO board, ModelAndView mav, HttpServletRequest request) {
		
		System.out.println("@Controller @RequestMapping 게시글 등록 처리");
		
		// 화면 네비게이션에서 사용할 상위 카테고리 저장할 변수
		int ct1 = 0;
		
		// 화면 네비게이션에서 사용할 하위 카테고리 저장할 변수
		int ct2 = 0;
		
		// 업로드할 파일 경로
		String uploadPath = request.getSession().getServletContext().getRealPath("/resources/upload");
		
		// 파일 최대 크기 지정
		int size = 10*1024*1024;
		
		// 업로드하는 파일의 원본 이름이 아닌 실제 업로드될 때 지정되는 이름
		String filename = "";
		
		try {
			
			MultipartRequest multi =
					new MultipartRequest(request, uploadPath, size, "utf-8", new DefaultFileRenamePolicy());
			
			// getFileNames() - enctype="multipart/form-data"인 form에서 전송된 
			//                  input type="file"의 name을 객체배열(Enumeration)에 할당
			Enumeration files = multi.getFileNames();
			
			// nextElement() - 첫번째 파일의 input type="file"의 name속성 값을 반환
			String file = (String)files.nextElement();
			
			// getFilesystemName() - 업로드하는 파일의 원본 이름이 아닌 실제 폴더에 업로드될 때 지정되는 이름 반환
			filename = multi.getFilesystemName(file);
			
			// 상위 카테고리
			int ct_u = 0;
			if(multi.getParameter("ct_u")!=null) {
				ct_u = Integer.parseInt(multi.getParameter("ct_u"));
			}
			
			// 하위 카테고리
			int ct_d = 9;
			if(multi.getParameter("ct_d")!=null) {
				ct_d = Integer.parseInt(multi.getParameter("ct_d"));
			}
			
			vo.setCt_u(ct_u);
			vo.setTitle(multi.getParameter("title"));
			vo.setContent(multi.getParameter("content"));
			vo.setZipcode(multi.getParameter("zipcode"));
			vo.setAddress(multi.getParameter("address"));
			vo.setTraffic(multi.getParameter("traffic"));
			vo.setOpen_day(multi.getParameter("open_day"));
			vo.setTel(multi.getParameter("tel"));
			vo.setWriter(multi.getParameter("writer"));
			vo.setFilepath("/resources/upload/"+filename);
			
			if(ct_u!=2) {
				vo.setPrice(multi.getParameter("price"));
				vo.setUri(multi.getParameter("uri"));
			}
			
			if(ct_u==2) {
				vo.setBestmenu(multi.getParameter("bestmenu"));
			}
			
			if(ct_u==0) {
				Timestamp time_s = Timestamp.valueOf(multi.getParameter("start_datetime").substring(0, 10) + " " 
						                           + multi.getParameter("start_datetime").substring(11) + ":00");
				
				Timestamp time_e = Timestamp.valueOf(multi.getParameter("end_datetime").substring(0, 10) + " " 
						                           + multi.getParameter("end_datetime").substring(11) + ":00");
				
				vo.setTime_s(time_s);
				vo.setTime_e(time_e);
				
				String str1 = multi.getParameter("start_datetime").substring(0,4)
					        + multi.getParameter("start_datetime").substring(5,7)
					        + multi.getParameter("start_datetime").substring(8,10);
				
				int start = Integer.parseInt(str1);
				
				String pattern = "yyyyMMdd";
				SimpleDateFormat sdf = new SimpleDateFormat(pattern);
				String str_today = sdf.format(new Date());
				
				int today = Integer.parseInt(str_today);
				
				if(start > today) {
					vo.setCt_d(1);
					ct_d = 1;
					ct2 = 1;
				} else {
					vo.setCt_d(0);
					ct_d = 0;
					ct2 = 0;
				}
			} else {
				vo.setCt_d(ct_d);
				ct2 = ct_d;
			}
			
			board.insertBoard(vo);
			
			ct1 = ct_u;
			
		} catch(Exception e) {
			e.printStackTrace();
		} 
			
		// Spring에서 제공하는 MVC 적용
		
		mav.addObject("ct_u", ct1);
		mav.addObject("ct_d", ct2);
		
		mav.setViewName("redirect:t_list.traveldo");
		return mav;
	}
	
	
	/*
		게시글 수정 처리 컨트롤러
	*/
	@RequestMapping("/t_update_proc.traveldo")
	public ModelAndView updateBoard(t_boardVO vo, t_boardDAO board, ModelAndView mav, HttpServletRequest request) {
		
		System.out.println("@Controller @Requestmapping 게시글 수정 처리");
		
		// 게시글 번호
		int num = 0;
		
		// 게시글 목록에서 사용할 상위 카테고리 
		int ct1 = 0;
		
		// 게시글 목록에서 사용할 하위 카테고리
		int ct2 = 9;
		
		// 파일 업로드 경로
		String uploadPath = request.getSession().getServletContext().getRealPath("/resources/upload");
		
		// 파일 크기 지정
		int size = 10*1024*1024;
		
		// 파일의 원본 이름이 아니라 실제 업로드 될 때 지정되는 이름
		String filename = "";
		
		try {
			MultipartRequest multi =
					new MultipartRequest(request, uploadPath, size, "utf-8", new DefaultFileRenamePolicy());
			
			// getFileNames() - enctype="multipart/form-data"인 form에서 전송된 
			//                  input type="file"의 name을 객체배열(Enumeration)에 할당
			Enumeration files = multi.getFileNames();
			
			// nextElement() - 첫번째 파일의 input type="file"의 name속성 값을 반환
			String file = (String)files.nextElement();
			
			// getFilesystemName() - 업로드하는 파일의 원본 이름이 아닌 실제 폴더에 업로드될 때 지정되는 이름 반환
			if(multi.getFilesystemName(file)!=null) {
				filename = multi.getFilesystemName(file);
			}
			
			num = Integer.parseInt(multi.getParameter("num"));
			ct1 = Integer.parseInt(multi.getParameter("ct_u"));
			
			vo.setNum(num);
			vo.setCt_u(Integer.parseInt(multi.getParameter("ct_u")));
			vo.setTitle(multi.getParameter("title"));
			vo.setContent(multi.getParameter("content"));
			vo.setZipcode(multi.getParameter("zipcode"));
			vo.setAddress(multi.getParameter("address"));
			vo.setTraffic(multi.getParameter("traffic"));
			vo.setOpen_day(multi.getParameter("open_day"));
			vo.setTel(multi.getParameter("tel"));
			vo.setUpdater(multi.getParameter("updater"));
			
			if(filename.equals("")){ // 이미지 파일 수정 X
				vo.setFilepath(filename);
			} else { // 이미지 파일 수정 O
				
				// 기존의 이미지 삭제
				File img = new File(uploadPath + multi.getParameter("p_filepath").substring(17));
				
				System.out.println("img = " + img);
				
				if(img.exists()){
					img.delete();
				}
				
				vo.setFilepath("/resources/upload/" + filename);
			}
			
			if(ct1!=2) {
				vo.setPrice(multi.getParameter("price"));
				vo.setUri(multi.getParameter("uri"));
			} else {
				vo.setBestmenu(multi.getParameter("bestmenu"));
			}
			
			if(ct1==0) {
				
				Timestamp time_s = Timestamp.valueOf(multi.getParameter("start_datetime").substring(0, 10) + " "
						                           + multi.getParameter("start_datetime").substring(11) + ":00");
				
				Timestamp time_e = Timestamp.valueOf(multi.getParameter("end_datetime").substring(0, 10) + " "
												   + multi.getParameter("end_datetime").substring(11) + ":00");
				
				vo.setTime_s(time_s);
				vo.setTime_e(time_e);
				
				String str1 = multi.getParameter("start_datetime").substring(0, 4)
						    + multi.getParameter("start_datetime").substring(5, 7)
						    + multi.getParameter("start_datetime").substring(8, 10);
				
				int start = Integer.parseInt(str1);
				
				String pattern = "yyyyMMdd";
				SimpleDateFormat sdf = new SimpleDateFormat(pattern);
				String str_today = sdf.format(new Date());
				
				int today = Integer.parseInt(str_today);
				
				if(start > today) {
					vo.setCt_d(1);
					ct2 = 1;
				} else {
					vo.setCt_d(0);
					ct2 = 0;
				}
				
			} else {
				vo.setCt_d(Integer.parseInt(multi.getParameter("ct_d")));
				ct2 = Integer.parseInt(multi.getParameter("ct_d"));
			}
			
			board.updateBoard(vo);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		// Spring에서 지원해주는 MVC 이용
		
		mav.addObject("num", num);
		mav.addObject("ct_u", ct1);
		mav.addObject("ct2", ct2);
		
		mav.setViewName("redirect:t_detail.traveldo");
		return mav;
	}
	
	
	/*
		게시글 삭제 처리 컨트롤러
	*/
	@RequestMapping("/t_delete_proc.traveldo")
	public ModelAndView deleteBoard(t_boardVO vo, t_boardDAO board, ModelAndView mav) {
		
		System.out.println("@Controller @RequestMapping 게시글 삭제 처리");
		
		board.deleteBoard(vo);
		
		mav.addObject("ct_u", vo.getCt_u());
		mav.addObject("ct_d", vo.getCt_d());
		
		mav.setViewName("redirect:t_list.traveldo");
		
		return mav;
	}
	
	
}
