<%@page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="../header.html" %>
<%@include file="../index/menu.jsp" %>

<p>検索ワードを入力してください。</p>
<form action="Student.action" method="post">
<input type="text" name="keyword">
<input type="submit" value="検索">
</form>
<hr>

<p>学生情報の登録</p>
<form action="../studentmanage/insert.jsp" method="post">
<input type="submit" value="登録">
</form>
<hr>

<table style="border-collapse:separate;border-spacing:10px">
<c:forEach var="student" items="${list}">
	<tr>
	<td>${student.no}</td>
	<td>${student.name}</td>
	<td>${student.ent_year}</td>
	<td>${student.class_num}</td>
	<td>${student.is_attend}</td>
	<td><input type="submit" value="変更"></td>
	</tr>
</c:forEach>
</table>

<%@include file="../footer.html" %>