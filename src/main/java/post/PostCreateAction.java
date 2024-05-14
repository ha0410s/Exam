package post;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.h2.jdbc.JdbcSQLException;

import bean.Post;
import bean.Teacher;
import dao.PostDAO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import tool.Action;

public class PostCreateAction extends Action{
	public String execute(HttpServletRequest req, HttpServletResponse res
			)throws Exception{
		try {
			
		HttpSession session = req.getSession();
		
		Teacher teacher = (Teacher) session.getAttribute("teacher");
		String teacher_id = teacher.getId();
		
		Timestamp postTime = new Timestamp(System.currentTimeMillis());
		
		String user_id=teacher_id;
		String content=req.getParameter("content");

		String postTimeStr = req.getParameter("post_time");

		if (postTimeStr != null) {
		    try {
		        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		        Date parsedDate = dateFormat.parse(postTimeStr);
		        postTime = new Timestamp(parsedDate.getTime());
		    } catch (ParseException e) {
		        e.printStackTrace();
		    }
		}
		
		Post p = new Post();
		p.setUser_id(user_id);
		p.setContent(content);
		p.setPost_time(postTime);
		
		PostDAO dao=new PostDAO();
		int line=dao.insert(p);
		session.setAttribute("line", line);
		
		 return "../post/postcreatedone.jsp";
	
		}catch(JdbcSQLException e){
			return "../post/postcreateerror.jsp";
		}
		}
		
}
