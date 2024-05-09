<%@page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="../header.html" %>
<%@include file="../sidebar.html" %>

<h2 class="subject"
	style="
	width:79%;
	background-color:#DCDCDC; 
	padding: 5px; 
	margin-bottom: 5%;
	margin-left: 20%;">科目管理</h2>
	
<a href="../subject/insert.jsp" method="post">新規登録</a>
<a href="../subject/deletelist.jsp" method="post">科目削除</a>

<table style="border-collapse:  collapse;">
<tr style="border-bottom:1px solid #000000;">
<th>科目コード</th>
<th>科目名</th>
</tr>
<c:forEach var="subject" items="${list}">
<tr style="text-align: center; border-bottom:1px solid gainsboro; padding: 30px 40px;">
<form action="../subject/SubjectSelect.action">
<td><input type="text" value="${subject.getCD()}" name="cd" readonly style="border:none; text-align: center;"></td>
<td>${subject.name}</td>
<td><input type="submit" value="変更"></td>
</form>
</c:forEach>
</tr>
</table>

<%@include file="../footer.html" %>
