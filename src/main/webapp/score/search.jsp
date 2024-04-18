<%@page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="../header.html" %>
<%@include file="../index/menu.jsp" %>

<p>検索ワードを入力してください</p>
<form action="Score.action" method="post">
<input type="text" name="keyword">
    <input type="submit" value="検索">
</form>
<hr>

<a href="scorelist.jsp">一覧表示</a> 

<table style="border-collapse:separate;border-spacing:10px">
<c:forEach var="score" items="${list}">
	<tr>
	<td>${score.point}</td>
	<td>${score.name}</td>
	<td><input type="submit" value="変更"></td>
	</tr>
</c:forEach>
</table>
