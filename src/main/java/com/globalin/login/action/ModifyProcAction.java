package com.globalin.login.action;

import java.io.IOException;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.globalin.login.control.ActionForward;
import com.globalin.login.model.MembershipDAO;
import com.globalin.login.model.MembershipVO;

public class ModifyProcAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		
		String loginID = (String)session.getAttribute("loginID");
		MembershipDAO dao = MembershipDAO.getInstance();
		
		MembershipVO vo = new MembershipVO(
				loginID, 
				request.getParameter("pass"), 
				request.getParameter("name"),
				request.getParameter("phone1"),
				request.getParameter("phone2"),
				request.getParameter("phone3"),
				request.getParameter("email"),
				request.getParameter("adminyn"));
		dao.updateMember(vo);
		
		return new ActionForward("/member/modifyProc.jsp", false);
	}

}
