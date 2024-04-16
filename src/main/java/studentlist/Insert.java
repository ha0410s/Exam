package studentlist;

import java.io.IOException;
import java.io.PrintWriter;

import bean.Student;
import dao.StudentDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tool.Page;

@WebServlet(urlPatterns={"/studentlist/insert"})
public class Insert extends HttpServlet {

	public void doPost (
		HttpServletRequest request, HttpServletResponse response
	) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		Page.header(out);
		try {
			int no=Integer.parseInt(request.getParameter("no"));
			String name=request.getParameter("name");
			int ent_year=Integer.parseInt(request.getParameter("ent_year"));
			int class_num=Integer.parseInt(request.getParameter("class_num"));
			Boolean is_attend=Boolean.parseBoolean(request.getParameter("is_attend"));
			String school_cd=request.getParameter("school_cd");

			Student p=new Student();
			p.setNo(no);
			p.setName(name);
			p.setEnt_year(ent_year);
			p.setClass_num(class_num);
			p.setIs_attend(is_attend);
			p.setSchool_cd(school_cd);

			StudentDAO dao=new StudentDAO();
			int line=dao.insert(p);

			if (line>0) {
				response.sendRedirect("../studentmanage/student.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace(out);
		}
		Page.footer(out);
	}
}

