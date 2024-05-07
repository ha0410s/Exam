<%@page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="../header.html" %>
<%@include file="../index/menu.jsp" %>

<p>科目の登録</p>
<form action="../subject/insert.jsp" method="post">
<input type="submit" value="登録">
</form>

<p>科目の削除<p>
<form action="../subject/delete.jsp" method="post">
<input type="submit" value="削除">
</form>
<hr>

<table style="margin:0 auto" table border="1">
<c:forEach var="subject" items="${list}">
	<tr>
	<td>学校コード</td>
	<td>${subject.school_cd}</td>
	<td>科目コード</td>
	<td>${subject.getCD()}</td>
	<td>科目名</td>
	<td>${subject.name}</td>
	<form action="../subject/update.jsp" method="post">
	<td><input type="submit" value="変更"></td>
	</form>
	</tr>
</c:forEach>
</table>

<%@include file="../footer.html" %>