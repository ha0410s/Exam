package studentlist;

import java.util.List;

import bean.Student;
import dao.StudentDAO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import tool.Action;


public class StudentListAction extends Action{
	public String execute(
			HttpServletRequest req, HttpServletResponse res
			)throws Exception{
		
		HttpSession session = req.getSession();
		
		int select_ent_year=Integer.parseInt(req.getParameter("f1"));
		String select_class_num=req.getParameter("f2");
		String select_is_attend=req.getParameter("f3");
		
		boolean select_is_attend1 = true;
		
		if(select_is_attend == null) {
			select_is_attend1=false;
		}
		
		
		
		if(select_ent_year == 0 && select_class_num.equals("0") && select_is_attend1 == false) {
			StudentDAO dao=new StudentDAO();
			List<Student>list=dao.searchall();
			
			session.setAttribute("list", list);
			
		}
		else if(select_class_num.equals("0")) {
			StudentDAO dao=new StudentDAO();
			List<Student>list=dao.search3(select_ent_year, select_is_attend1);
			
			session.setAttribute("list", list);
			
		}
		else if(select_ent_year == 0){
			StudentDAO dao=new StudentDAO();
			List<Student>list=dao.search2(select_class_num, select_is_attend1);
			
			session.setAttribute("list", list);
			
		}
		
		
		else{
			StudentDAO dao=new StudentDAO();
			List<Student>list=dao.search1(select_ent_year, select_class_num, select_is_attend1);
		
		session.setAttribute("list", list);
		
		}
		
		return "../studentmanage/studentlist.jsp";
	
	}
	
	
}
