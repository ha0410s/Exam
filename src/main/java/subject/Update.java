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

@WebServlet(urlPatterns={"/subject/update"})
public class Update extends HttpServlet {

	public void doPost (
		HttpServletRequest request, HttpServletResponse response
	) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		Page.header(out);
		try {
			String school_cd=request.getParameter("school_cd");
			String name=request.getParameter("name");
			String cd=request.getParameter("cd");
			
			Subject k=new Subject();
			k.setSchool_cd(school_cd);
			k.setName(name);
			k.setCD(cd);
			SubjectDAO dao=new SubjectDAO();
			int line=dao.update(k);

			if (line>0) {
				response.sendRedirect("../subject/subject.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace(out);
		}
		Page.footer(out);
	}
}

