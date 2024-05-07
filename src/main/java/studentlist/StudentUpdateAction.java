package studentlist;

import bean.Student;
import dao.StudentDAO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import tool.Action;

public class StudentUpdateAction extends Action{	
	public String execute(
		HttpServletRequest req, HttpServletResponse res)throws Exception{
		
		HttpSession session = req.getSession();

		
		String student_no=req.getParameter("no");
		String update_name=req.getParameter("f1");
		String update_class_num=req.getParameter("f2");
		String update_is_attend=req.getParameter("f3");
		
		boolean update_is_attend1 = true;
		
		if(update_is_attend == null) {
			update_is_attend1=false;
		}
		
		Student st = new Student();
		st.setNo(student_no);
		st.setName(update_name);
		st.setClass_num(update_class_num);
		st.setIs_attend(update_is_attend1);
		
		
	
		StudentDAO dao=new StudentDAO();
		int line=dao.update(student_no, update_name, update_class_num, update_is_attend1);
		session.setAttribute("line", line);
		
		
		return "../studentmanage/stundetupdatedone.jsp";
	
	}
	
}
