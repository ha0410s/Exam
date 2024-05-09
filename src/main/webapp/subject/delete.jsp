<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../header.html" %>
<%@include file="../sidebar.html" %>

<h2 class="subject"
	style="
	width:79%;
	background-color:#DCDCDC; 
	padding: 5px; 
	margin-bottom: 10%;
	margin-left: 20%;">科目情報削除</h2>

<div style="text-align: center; overflow: hidden;">
<form action="../subject/Delete.action" method ="post">	
		<div style="display: flex;">
		
 		<label style="float: left; padding-left: 50px; padding-bottom: 40px;">科目コード</label>
 		<br>
 			 <input value="${subject.getCD()}" readonly 
 			 style="width: 700px; height: 40px; margin: 40px 50px; border: none;">
 			 <input value="${subject.getName()}" readonly 
 			 style="width: 700px; height: 40px; margin: 40px 50px; border: none;">
 		</div>	 
		<div style="display: flex; padding: 60px 50px;">
			<input type="submit" value="削除" 
			style="	color: white;
					margin-top: 50px;
					cursor: pointer;
					height: 55px;
					width: 97px; 
					background-color: #FF0000;
					border-radius: 1rem;
					border-style: none;">
		</div>
</form>
</div>

<%@include file="../footer.html" %>