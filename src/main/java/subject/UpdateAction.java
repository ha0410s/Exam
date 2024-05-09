package subject;

import bean.Subject;
import dao.SubjectDAO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import tool.Action;


public class UpdateAction extends Action{	
	public String execute(
		HttpServletRequest req, HttpServletResponse res)throws Exception{
		
		HttpSession session = req.getSession();

		
		String cd=req.getParameter("cd");
		String name=req.getParameter("name");
		
		Subject sj = new Subject();
		sj.setCD(cd);
		sj.setName(name);
		
		
		SubjectDAO dao=new SubjectDAO();
		int line=dao.update(cd, name);
		session.setAttribute("line", line);
		
		
		return "../subject/subjectupdatedone.jsp";
	
	}
}