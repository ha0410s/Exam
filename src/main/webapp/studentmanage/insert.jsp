<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../header.html" %>

<p>学生情報を入力してください。</p>
<form action="../studentlist/insert" method="post">
学生番号<input type="text" name="no">
氏名<input type="text" name="name">
入学年<input type="text" name="ent_year">
クラス<input type="text" name="class_num">
出席<input type="text" name="is_attend">
学校<input type="text" name="school_cd">
<input type="submit" value="追加">
</form>

<%@include file="../footer.html" %>
