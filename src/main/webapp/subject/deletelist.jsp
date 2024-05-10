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
	margin-left: 20%;">科目情報削除</h2>
	
<div style="width:50%; margin-left:25%;">
<section class="me-4" style="width: 100%;">
	
<table width="750" style="border-collapse:  collapse;">
<tr style="border-bottom:1px solid #000000;">
<th>科目コード</th>
<th>科目名</th>
</tr>
<c:forEach var="subject" items="${list}">
<tr style="text-align: center; border-bottom:1px solid gainsboro; padding: 30px 40px;">
<form action="../subject/SubjectSelect2.action">
<td><input type="text" value="${subject.CD}" name="cd" readonly style="border:none; text-align: center;"></td>
<td>${subject.name}</td>
<td><input type="submit" value="削除"></td>
</form>
</c:forEach>
</tr>
</table>
</div>
</section>
<%@include file="../footer.html" %>
