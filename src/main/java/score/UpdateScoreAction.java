package score;

import java.util.List;

import bean.TestListScore;
import dao.TestListScoreDAO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tool.Action;

public class UpdateScoreAction extends Action {
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // フォームから送信されたデータを取得
        String class_num = request.getParameter("class_num");
        String subject_name = request.getParameter("subject");
        String ent_year = request.getParameter("ent_year");
        
        if (class_num == null || class_num.isEmpty() || subject_name == null || subject_name.isEmpty() || ent_year ==null || ent_year.isEmpty()) {
            request.setAttribute("errorMessage", "全ての項目を入力してください");
            // エラーメッセージを表示するためにエラーページにフォワード
            return "../score/updatescore.jsp";
        } else {
            // データベースから検索結果を取得
            TestListScoreDAO dao = new TestListScoreDAO();
            List<TestListScore> list = dao.search(class_num, subject_name, ent_year);
            
            // JSPに渡すために検索結果をリクエストにセット
            request.setAttribute("list", list);
            
            // 結果を表示するJSPへフォワード
            return "../score/updatescore.jsp";
        }
        
    }
}
