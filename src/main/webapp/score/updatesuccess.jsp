<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../header.html" %>
<%@include file="../sidebar.html"%>


<h2 class = "score"
	style= "windth:79%;
			background-color:#DCDCDC; 
			padding: 5px;
			margin-bottom: 20px;
			margin-left: 20%;">成績登録</h2>
			
<h2 class="score"
	style="
	width:79%;
	background-color:#66cc99; 
	padding: 5px; 
	margin-bottom: 10%;
	margin-left: 20%;
	text-align: center;">登録が完了しました。</h2>
	
<div style="overflow: hidden;">
<a href="../score/updatescore.jsp" style="padding-left: 300px;">戻る</a>


<a href="../score/search.jsp" 
style="padding-left: 600px;">成績参照</a>
</div>


<%@include file="../footer.html" %>
