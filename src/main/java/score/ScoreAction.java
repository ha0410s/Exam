package score;

import java.util.List;

import bean.TestListScore;
import dao.TestListScoreDAO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tool.Action;

public class ScoreAction extends Action {
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // フォームから送信されたデータを取得
        String class_num = request.getParameter("class_num");
        String subject_name = request.getParameter("subject");
        String ent_year = request.getParameter("ent_year");
        
        // 全ての項目が入力されているかチェック
        if (class_num == null || class_num.isEmpty() || subject_name == null || subject_name.isEmpty() || ent_year ==null || ent_year.isEmpty()) {
            // エラーメッセージをリクエスト属性に設定
            request.setAttribute("errorMessage", "全ての項目を入力してください");
            // エラーページにフォワード
            return "../score/search.jsp"; // エラーメッセージを表示するJSPのパスに修正
        } else {
            // データベースから検索結果を取得
            TestListScoreDAO dao = new TestListScoreDAO();
            List<TestListScore> list = dao.search(class_num, subject_name, ent_year);
            
            // 検索結果が空でないかチェック
            if (list.isEmpty()) {
                // 学生情報が存在しない場合のエラーメッセージをリクエスト属性に設定
                request.setAttribute("errorMessage", "該当する学生情報が見つかりませんでした");
                // エラーページにフォワード
                return "../score/search.jsp"; // エラーメッセージを表示するJSPのパスに修正
            } else {
                // 検索結果をリクエスト属性に設定
                request.setAttribute("list", list);
                // 科目情報の検索結果を表示するJSPにフォワード
                return "../score/subjectsearch.jsp"; // 科目情報の検索結果を表示するJSPのパスに修正
            }
        }
    }
}
