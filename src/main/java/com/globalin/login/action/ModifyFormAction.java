package com.globalin.login.action;

import java.io.IOException;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.globalin.login.control.ActionForward;
import com.globalin.login.model.MembershipDAO;
import com.globalin.login.model.MembershipVO;

public class ModifyFormAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
	
		MembershipDAO dao = MembershipDAO.getInstance();
		HttpSession session = request.getSession();
		
		String loginID =(String)session.getAttribute("loginID");
		
		MembershipVO vo = dao.getMember(loginID);
		
		request.setAttribute("id", vo.getId());
		request.setAttribute("pass", vo.getPass());
		request.setAttribute("phone1", vo.getPhone1());
		request.setAttribute("phone2", vo.getPhone2());
		request.setAttribute("phone3", vo.getPhone3());
		request.setAttribute("email", vo.getEmail());
		request.setAttribute("name", vo.getName());
		request.setAttribute("adminyn", vo.getAdminyn());
		return new ActionForward("/member/modifyForm.jsp", false);
	}

}
