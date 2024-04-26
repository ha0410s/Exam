<%@page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="../header.html" %>
<%@include file="../index/menu.jsp" %>
<h1>成績参照</h1>
<p>検索したい成績を入力してください</p>
<form action="Score.action" method="post">
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

<p>検索したい学生情報を入力</p>
<form action="StudentSearch.action"method="post">
<input type="text" name="student_no"placeholder="学生番号を入力してください">
<input type="submit" value="検索">
</form>
<p>${errorMessage2 }</p>
<a href="scorelist.jsp">一覧表示</a> 

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
    <td>${score.point}点</td> 
  </tr>
</c:forEach>
<c:forEach var="studentsearch" items="${list}">
  <tr>
    <td>${studentsearch.subject_name}</td>
    <td>${studentsearch.ent_year}年</td>
    <td>${studentsearch.class_num}</td>
    <td>${studentsearch.student_no}</td>
    <td>${studentsearch.name}</td>
    <td>${studentsearch.test_no }回目</td>
    <td>${studentsearch.point}点</td>  
  </tr>
</c:forEach>
</table>
