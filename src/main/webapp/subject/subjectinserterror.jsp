<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../header.html" %>
<%@include file="../sidebar.html" %>


<h2 class="subject"
	style="
	width:79%;
	background-color:#DCDCDC; 
	padding: 5px; 
	margin-bottom: 10%;
	margin-left: 20%;">科目情報登録</h2>

<div style="text-align: center; overflow: hidden;">
<form action="../subject/Insert.action" method="post">
    <label style="float: left; padding-left: 170px">学校コード</label><br>
		<input type="text" name="school_cd" placeholder="学校コードを入力してください。" required
		style="width: 700px; height: 40px;">
	<br>
	<br>
	<label style="float: left; padding-left: 170px">科目コード</label><br>
		<input type="text" name="cd" placeholder="科目コードを入力してください。" required
		style="width: 700px; height: 40px;">
	<br>
	<label style="color: red;float: left; padding-left: 200px">科目コードが重複しています。</label>
	<br>
	<label style="float: left; padding-left: 170px">科目名</label><br>
		<input type="text" name="name" placeholder="科目名を入力してください。" required
		style="width: 700px; height: 40px;">
	<br>
	<input type="submit" value="登録" 
			style="	color: white;
					margin-top: 50px;
					cursor: pointer;
					height: 55px;
					width: 97px; 
					background-color: #87CEEB;
					border-radius: 1rem;
					border-style: none;">
</form>
</div>


<%@include file="../footer.html" %>
