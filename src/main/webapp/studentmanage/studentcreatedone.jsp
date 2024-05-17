<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../header.html" %>
<%@include file="../sidebar.html" %>


<h2 class="studentmanage"
	style="
	width:79%;
	background-color:#DCDCDC; 
	padding: 5px; 
	margin-bottom: 20px;
	margin-left: 20%;">学生情報登録</h2>

<h2 class="studentmanage"
	style="
	width:79%;
	background-color:#66cc99; 
	padding: 5px; 
	margin-bottom: 10%;
	margin-left: 20%;
	text-align: center;">登録が完了しました。</h2>
<div style="overflow: hidden;">
<a href="../studentmanage/insert.jsp" style="padding-left: 300px;">戻る</a>

<a href="../studentlist/StudentAllList.action" 
style="padding-left: 600px;">学生一覧</a>
</div>


<%@include file="../footer.html" %>
