package com.globalin.login.control;

import java.io.IOException;



//import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.globalin.login.action.Action;



public class ControlServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

request.setCharacterEncoding("utf-8");
		
		String cmd = request.getParameter("cmd");
		
		if(cmd != null) {// 명령 파라미터가 있을 경우
			ActionFactory factory = ActionFactory.getInstance();
			 Action action = factory.getAction(cmd);
			 
			 ActionForward af = action.execute(request, response);
			 
			if(af.isRedirect()) {
				response.sendRedirect(af.getUrl());
			}else {
				RequestDispatcher rd = 
						request.getRequestDispatcher(af.getUrl());
				rd.forward(request, response);
			}
			
			
		}
		/*else {// 명령 파라미터가 없을 경우
			
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			
			out.println("<html>");
			out.println("<head><title>Error</title></head>");
			out.println("<body>");
			out.println("<h4>올바른 요청이 아닐때 </h4>");
			out.println("<h4>http://localhost:9090/mvcmem/member.mdo?cmd=요청키워드</h4>");			
			out.println("</body>");
			out.println("</html>");
			
		}
		*/

		
		
	
	}
	

}
