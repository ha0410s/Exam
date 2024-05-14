package post;

import java.util.List;

import bean.Post;
import bean.Teacher;
import dao.PostDAO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import tool.Action;

public class PostListAction extends Action{
		public String execute(HttpServletRequest req, HttpServletResponse res
				)throws Exception{
			
			HttpSession session = req.getSession();
			
			Teacher teacher = (Teacher) session.getAttribute("teacher");
			String user_id = teacher.getId();
					
			
			PostDAO dao=new PostDAO();
			List<Post>list=dao.searchall(user_id);
		
		session.setAttribute("list", list);
		
		return "../post/postlist.jsp";
	}
}

