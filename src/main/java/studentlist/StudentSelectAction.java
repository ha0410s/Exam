package studentlist;

import java.util.List;

import bean.Student;
import bean.Teacher;
import dao.ClassNumDAO;
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
		

		Teacher teacher = (Teacher) session.getAttribute("teacher");
		String school_cd = teacher.getSchool_cd();

        ClassNumDAO class_num_dao = new ClassNumDAO();
        List<String> classNums = class_num_dao.getClassNumsBySchoolCd(school_cd);

        req.setAttribute("classNums", classNums);
		
		String student_no=req.getParameter("no");
		
		StudentDAO dao=new StudentDAO();
		Student student=dao.searchstudent(student_no);
			
		session.setAttribute("student", student);
					
		return "../studentmanage/update.jsp";
	
	}
	
}
