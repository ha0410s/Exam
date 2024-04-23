package subject;

import java.io.IOException;
import java.io.PrintWriter;

import bean.Subject;
import dao.SubjectDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tool.Page;

@WebServlet(urlPatterns={"/subject/delete"})
public class Delete extends HttpServlet {

	public void doPost (
		HttpServletRequest request, HttpServletResponse response
	) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		Page.header(out);
		try {
			String school_cd=request.getParameter("school_cd");
			String cd=request.getParameter("cd");
			String name=request.getParameter("name");
			
			Subject k=new Subject();
			k.setSchool_cd(school_cd);
			k.setCD(cd);
			k.setName(name);
			SubjectDAO dao=new SubjectDAO();
			int line=dao.delete(k);

			if (line>0) {
				response.sendRedirect("../subject/subject.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace(out);
		}
		Page.footer(out);
	}
}

