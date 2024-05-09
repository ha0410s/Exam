package subject;

import org.h2.jdbc.JdbcSQLException;

import bean.Subject;
import dao.SubjectDAO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import tool.Action;


public class DeleteAction extends Action{
	public String execute(HttpServletRequest req, HttpServletResponse res
			)throws Exception{
		try {
		HttpSession session = req.getSession();
		
		String school_cd =req.getParameter("school_cd");
		String cd=req.getParameter("cd");
		String name=req.getParameter("name");
		
		Subject sj = new Subject();
		sj.setSchool_cd(school_cd);
		sj.setCD(cd);
		sj.setName(name);
		
		SubjectDAO dao=new SubjectDAO();
		int line=dao.delete(sj);
		session.setAttribute("line", line);
		
		 return "../subject/subjectdeletedone.jsp";
		}catch(JdbcSQLException e){
			return "../subject/subjectdeleteerror.jsp";
		}
	}
		
}