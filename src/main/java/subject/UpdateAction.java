package subject;

import org.h2.jdbc.JdbcSQLException;

import bean.Subject;
import dao.SubjectDAO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import tool.Action;


public class UpdateAction extends Action{	
	public String execute(
		HttpServletRequest req, HttpServletResponse res)throws Exception{
		
		try {
		HttpSession session = req.getSession();

		
		String update_cd=req.getParameter("cd");
		String update_name=req.getParameter("name");
		
		Subject sj = new Subject();
		sj.setCD(update_cd);
		sj.setName(update_name);
		
		
		SubjectDAO dao=new SubjectDAO();
		int line=dao.update(update_cd, update_name);
		session.setAttribute("line", line);
		
		
		return "../subject/subjectupdatedone.jsp";
	    }catch(JdbcSQLException e){
		    return "../subject/subjectinserterror.jsp";
	    }
	
	}
}