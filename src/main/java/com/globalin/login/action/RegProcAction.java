package com.globalin.login.action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.globalin.login.control.ActionForward;
import com.globalin.login.model.*;

public class RegProcAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

		request.setCharacterEncoding("utf-8");
		
		MembershipDAO dao = MembershipDAO.getInstance();
		
		MembershipVO vo = new MembershipVO(
				request.getParameter("id"),
				request.getParameter("pass"),
				request.getParameter("name"), 
				request.getParameter("phone1"),
				request.getParameter("phone2"),
				request.getParameter("phone3"),
				request.getParameter("email"),
				request.getParameter("adminyn"));
		
		 boolean flag = dao.memberInsert(vo);
		 
		 request.setAttribute("flag",flag);
		
		 return new ActionForward("/member/regProc.jsp", false);
	}

}
