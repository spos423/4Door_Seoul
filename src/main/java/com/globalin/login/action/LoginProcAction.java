package com.globalin.login.action;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.globalin.login.control.ActionForward;
import com.globalin.login.model.MembershipDAO;


public class LoginProcAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

		MembershipDAO dao =MembershipDAO.getInstance();
		
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		
		int check = dao.loginCheck(id, pass);
		
		System.out.println("check = " + check);
		
		if(check == 1) {
			int  yn = dao.getyn(id);
			HttpSession session = request.getSession();
			session.setAttribute("loginID", id);
			session.setAttribute("yn", yn);
		}else if(id != null && pass != null) {
			request.setAttribute("check",check);
		}
		
		return new ActionForward("/", true);
		
	}

}
