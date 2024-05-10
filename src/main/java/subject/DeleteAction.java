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
		
		String delete_school_cd =req.getParameter("school_cd");
		String delete_cd=req.getParameter("cd");
		String delete_name=req.getParameter("name");
		
		Subject sj = new Subject();
		sj.setSchool_cd(delete_school_cd);
		sj.setCD(delete_cd);
		sj.setName(delete_name);
		
		SubjectDAO dao=new SubjectDAO();
		int line=dao.delete(sj);
		session.setAttribute("line", line);
		
		 return "../subject/subjectdeletedone.jsp";
		}catch(JdbcSQLException e){
			return "../subject/subjectdeleteerror.jsp";
		}
	}
}