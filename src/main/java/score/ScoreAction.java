package score;

import java.util.List;

import bean.TestListScore;
import dao.TestListScoreDAO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tool.Action;

public class ScoreAction extends Action{
	public String execute(
			HttpServletRequest request, HttpServletResponse response
			)throws Exception{
		// HttpSession session = request.getSession();
		
		String keyword=request.getParameter("keyword");
		if(keyword==null) keyword="";
		
		TestListScoreDAO dao=new TestListScoreDAO();
		List<TestListScore>list=dao.search(keyword);
		
		request.setAttribute("list", list);
		
		return "../score/search.jsp";
	}
	}
