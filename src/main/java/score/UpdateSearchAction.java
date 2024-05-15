package score;

import java.util.List;

import bean.TestListScore;
import dao.TestListScoreDAO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tool.Action;

public class UpdateSearchAction extends Action {
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // フォームから送信されたデータを取得
        String ent_year = request.getParameter("ent_year");
        String class_num = request.getParameter("class_num");
        String subject_name = request.getParameter("subject");
        String test_no = request.getParameter("test_no");
        
        if (class_num == null || class_num.isEmpty() || subject_name == null || subject_name.isEmpty() || ent_year == null || ent_year.isEmpty() || test_no == null || test_no.isEmpty()) {
            request.setAttribute("errorMessage", "全ての項目を入力してください");
            // エラーメッセージを表示するためにエラーページにフォワード
            return "../score/updatescore.jsp";
        } else {
            // データベースから検索結果を取得
            TestListScoreDAO dao = new TestListScoreDAO();
            List<TestListScore> list = dao.updatesearch(ent_year, class_num, subject_name, test_no);
            
            // JSPに渡すために検索結果をリクエストにセット
            request.setAttribute("list", list);
            
            // 結果を表示するJSPへフォワード
            return "../score/updatescore.jsp";
        }
    }
}
