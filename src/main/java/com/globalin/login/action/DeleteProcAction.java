package com.globalin.login.action;

import java.io.IOException;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.globalin.login.control.ActionForward;
import com.globalin.login.model.MembershipDAO;


public class DeleteProcAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
	
		request.setCharacterEncoding("utf-8");
		MembershipDAO dao = MembershipDAO.getInstance();
		
		HttpSession session = request.getSession();
		String loginID = (String)session.getAttribute("loginID");
		String pass = request.getParameter("pass");
		
		int result = dao.deleteMember(loginID, pass);
		
		if(result != 0) {
			session.invalidate();
		}
		
		request.setAttribute("result", result);
		
		return new ActionForward("/member/deleteProc.jsp", false);
	}

}
