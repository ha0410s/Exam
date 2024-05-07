package studentlist;

import bean.Student;
import dao.StudentDAO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import tool.Action;

public class StudentSelectAction  extends Action{
	public String execute(
			HttpServletRequest req, HttpServletResponse res
			)throws Exception{
		
		HttpSession session = req.getSession();
		
		String student_no=req.getParameter("no");
		
		StudentDAO dao=new StudentDAO();
		Student student=dao.searchstudent(student_no);
			
		session.setAttribute("student", student);
					
		return "../studentmanage/update.jsp";
	
	}
	
}
