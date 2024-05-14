package studentlist;

import java.util.List;

import bean.Student;
import bean.Teacher;
import dao.StudentDAO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import tool.Action;


public  class StudentAllListAction extends Action{
	public String execute(HttpServletRequest req, HttpServletResponse res
			)throws Exception{
		
		HttpSession session = req.getSession();
		
		Teacher teacher = (Teacher) session.getAttribute("teacher");
		String teacher_school_cd = teacher.getSchool_cd();
		
		
		StudentDAO dao=new StudentDAO();
		List<Student>list=dao.searchall(teacher_school_cd);
	
	session.setAttribute("list", list);
	
	return "../studentmanage/studentlist.jsp";
	}
}
