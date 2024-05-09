package subject;

import org.h2.jdbc.JdbcSQLException;

import bean.Subject;
import dao.SubjectDAO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import tool.Action;


public class InsertAction extends Action{
	public String execute(HttpServletRequest req, HttpServletResponse res
			)throws Exception{
		try {
		HttpSession session = req.getSession();
		
		String create_school_cd =req.getParameter("school_cd");
		String create_cd=req.getParameter("cd");
		String create_name=req.getParameter("name");
		
		Subject sj = new Subject();
		sj.setSchool_cd(create_school_cd);
		sj.setCD(create_cd);
		sj.setName(create_name);
		
		SubjectDAO dao=new SubjectDAO();
		int line=dao.insert(sj);
		session.setAttribute("line", line);
		
		 return "../subject/subjectinsertdone.jsp";
		}catch(JdbcSQLException e){
			return "../subject/subjectinserterror.jsp";
		}
	}
		
}