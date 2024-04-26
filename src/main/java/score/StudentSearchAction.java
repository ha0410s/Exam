package score;

import java.util.List;

import bean.TestListScore;
import dao.TestListScoreDAO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tool.Action;

public class StudentSearchAction extends Action {
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // フォームから送信されたデータを取得
        String student_no = request.getParameter("student_no");

        // データベースから検索結果を取得
        TestListScoreDAO dao = new TestListScoreDAO();
        List<TestListScore> list = dao.studentsearch(student_no);

        if (list.isEmpty()) {
            // 学生情報が存在しない場合のエラーメッセージを設定
            request.setAttribute("errorMessage2", "学生情報が存在しませんでした");
            // 適切な JSP ページにフォワード
            return "../score/search.jsp";
        } else {
            // JSP に渡すために検索結果をリクエストにセット
            request.setAttribute("list", list);
            // 結果を表示する JSP へフォワード
            return "../score/search.jsp";
        }
    }
}
