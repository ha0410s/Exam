package subject;

import bean.Subject;
import dao.SubjectDAO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import tool.Action;


public class SubjectSelect2Action  extends Action{
	public String execute(
			HttpServletRequest req, HttpServletResponse res
			)throws Exception{
		
		HttpSession session = req.getSession();
		
		String cd=req.getParameter("cd");
		
		SubjectDAO dao=new SubjectDAO();
		Subject subject=dao.searchsubject(cd);
			
		session.setAttribute("subject", subject);
					
		return "../subject/delete.jsp";
	
	}
	
}
