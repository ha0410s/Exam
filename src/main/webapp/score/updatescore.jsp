<%@page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="../header.html" %>
<%@include file="../sidebar.html"%>


<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="../css/style.css">
    <style>
        body {
            padding-left: 250px; /* サイドバーの幅を考慮して左側に余白を追加 */
        }

        table {
            border-collapse: collapse;
            width: 100%;
        }

        th, td {
            border-bottom: 1px solid black;
            padding: 8px;
            text-align: left;
        }

       h1 {
            width: 79%;
            padding: 5px;
            margin-bottom: 5%;
            border-radius: 10px; 
            top: 0; /* ヘッダーを画面上部に配置 */
            left: 250px; /* サイドバーの幅分だけ左にずらす */
        }
        input[type="submit"] {
            background-color: gray;
            color: white;
            border: none;
            padding: 5px 10px;
            cursor: pointer;
            border-radius: 5px;
        }

        .search-section {
            border: 1px solid black;
            padding: 10px;
            margin-bottom: 20px;
            border-radius: 10px; /* 枠組みに丸みを持たせる */
        }

        /* サイドバーのスタイル */
        .sidebar {
            width: 250px;
            position: fixed;
            top: 0;
            left: 0;
            height: 100%;
            padding-top: 20px;
        }
        

    </style>
</head>



<h1>成績登録</h1>
<p>変更したい成績を検索してください</p>
<form action="UpdateScore.action" method="post">
    <select name="class_num">
        <!-- クラスのオプションを追加 -->
        <option value="">クラスを選択してください</option>
        <option value="101">101</option>
        <option value="201">201</option>
        <option value="131">131</option>
        <!-- 他のクラスのオプションを追加 -->
    </select>
    <!-- 教科のテキスト入力フィールド -->
    <input type="text" name="subject" placeholder="教科を入力してください">
    <select name="ent_year">
        <option value="">入学年度を選択してください</option>
        <option value="2021">2021年</option>
        <option value="2022">2022年</option>
        <option value="2023">2023年</option>
        <!-- 他の年度のオプションを追加 -->
    </select>
    <input type="submit" value="検索">
</form>
<p>${errorMessage}</p>
<hr>

<form action="UpdateScores.action" method="post">
<table style="border-collapse:separate;border-spacing:10px">
  <tr>
    <th>教科</th>
    <th>入学年</th>
    <th>クラス</th>
    <th>学生番号</th>
    <th>名前</th>
    <th>回数</th>
    <th>点数</th>
  </tr>
  <c:forEach var="score" items="${list}">
    <tr>
      <td>${score.subject_name}</td>
      <td>${score.ent_year}年</td>
      <td>${score.class_num}</td>
      <td>${score.student_no}</td>
      <td>${score.name}</td>
      <td>${score.test_no }回目</td>
      <td>
      <input type="text"name="point"value="${score.point}">
      </td>
      <td>
      <a href="update2.jsp">更新</a>
      </td>
    </tr>
  </c:forEach>
</table>

<%@include file="../footer.html"%>

</form>
