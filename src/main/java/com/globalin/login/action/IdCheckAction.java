package com.globalin.login.action;

import java.io.IOException;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.globalin.login.control.ActionForward;
import com.globalin.login.model.MembershipDAO;


public class IdCheckAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		MembershipDAO dao = MembershipDAO.getInstance();
		
		String id = request.getParameter("id");
		boolean check = dao.idCheck(id);
		
		request.setAttribute("id", id);
		request.setAttribute("check", check);
		
		
		return new ActionForward("/member/idCheck.jsp", false);
	}

}
