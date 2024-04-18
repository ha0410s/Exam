<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="bean.TestListScore" %>
<%@ page import="dao.TestListScoreDAO" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
</head>
<body>
    <h1>成績一覧</h1>

    <table border="1">
        <tr>
            <th>入学年度</th>
            <th>学籍番号</th>
            <th>氏名</th>
            <th>クラス番号</th>
            <th>学校コード</th>
            <th>点数</th>
        </tr>

        <% 
            TestListScoreDAO dao = new TestListScoreDAO(); // TestListScoreDAOを使用
            try {
                String keyword = request.getParameter("keyword"); // パラメータを取得
                List<TestListScore> scoreList;
                if (keyword != null && !keyword.isEmpty()) {
                    scoreList = dao.search(keyword); // 検索メソッドを使用
                } else {
                    scoreList = dao.getAllScore(); // 全成績取得メソッドを使用
                }
                for (TestListScore score : scoreList) {
        %>
                    <tr>
                        <td><%= score.getEnt_year() %></td>
                        <td><%= score.getStudent_no() %></td>
                        <td><%= score.getName() %></td> <!-- メソッド名を修正 -->
                        <td><%= score.getClass_num() %></td>
                        <td><%= score.getSchool_cd() %></td>
                        <td><%= score.getPoint() %></td>
                    </tr>
        <% 
                }
            } catch (Exception e) {
                out.println("データの取得に失敗しました：" + e.getMessage());
                e.printStackTrace();
            }
        %>
    </table>
</body>
</html>
