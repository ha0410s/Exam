<%@page pageEncoding="UTF-8" %>
<%@include file="../header.html" %>
<%@include file="../sidebar.html" %>


<h2 style="width:79%;
	background-color:#DCDCDC; 
	padding: 5px; 
	margin-bottom: 10%;
	margin-left: 20%;
	overflow: hidden;">メニュー</h2>

<div class="menu" 
	style="display: flex; 
	justify-content: space-around; 
	font-size: 30px; 
	text-align: center;
	margin-left: 20%;
	width: 80%;
	overflow: hidden;">
	<div class=""
		style="
			width: 20%;
			height: 10rem; 
			background-color: #dbb;
			border-radius: 1em;">
		<a href="../studentmanage/studentlist.jsp" style="line-height: 150px;">学生管理</a>
	</div>
	<div style="
			width: 20%;
			height: 10rem; 
			background-color: 	#8FBC8F;
			border-radius: 1em;
			text-align: center;">
				<li style="list-style: none;">成績管理</li>
				<li style="list-style: none;"><a href="">成績登録</a></li>
				<li style="list-style: none;"><a href="../score/search.jsp">成績参照</a></li>
	</div>
	<div style="
		width: 20%;
		height: 10rem; 
		background-color: 	#B0E0E6;
		border-radius: 1em;
		text-align: center;">
		<a href="" style="line-height: 150px;">科目管理</a>
	</div>
</div>


<%@include file="../footer.html" %>