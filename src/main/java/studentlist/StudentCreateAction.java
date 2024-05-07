package studentlist;

import org.h2.jdbc.JdbcSQLException;

import bean.Student;
import dao.StudentDAO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import tool.Action;


public class StudentCreateAction extends Action{
	public String execute(HttpServletRequest req, HttpServletResponse res
			)throws Exception{
		try {
		HttpSession session = req.getSession();
		
		int create_ent_year=Integer.parseInt(req.getParameter("ent_year"));
		String create_no=req.getParameter("no");
		String create_name=req.getParameter("name");
		String create_class_num=req.getParameter("class_num");
		String create_school_cd = "oom";
		boolean create_is_attend = true;
		
		if(create_class_num.equals("101")) {
			create_school_cd.equals("tky");
		}
		if(create_ent_year < 2022) {
			create_is_attend = false;
		}
		
		
		Student st = new Student();
		st.setNo(create_no);
		st.setName(create_name);
		st.setEnt_year(create_ent_year);
		st.setClass_num(create_class_num);
		st.setIs_attend(create_is_attend);
		st.setSchool_cd(create_school_cd);
		
		StudentDAO dao=new StudentDAO();
		int line=dao.insert(st);
		session.setAttribute("line", line);
		
		 return "../studentmanage/studentcreatedone.jsp";
		}catch(JdbcSQLException e){
			return "../studentmanage/studentcreateerror.jsp";
		}
	}
		
}