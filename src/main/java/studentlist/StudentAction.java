package studentlist;

import java.util.List;

import bean.Student;
import dao.StudentDAO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import tool.Action;


public class StudentAction extends Action{
	public String execute(
			HttpServletRequest request, HttpServletResponse response
			)throws Exception{
		
		HttpSession session = request.getSession();
		
		String keyword=request.getParameter("keyword");
		if(keyword==null) keyword="";
		
		StudentDAO dao=new StudentDAO();
		List<Student>list=dao.search(keyword);
		
		session.setAttribute("list", list);
		
		return "../studentmanage/student.jsp";
	}
}
