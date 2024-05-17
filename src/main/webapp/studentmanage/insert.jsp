<%@page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="../header.html" %>
<%@include file="../sidebar.html" %>
<%@ page import="java.time.LocalDate" %>
<%@ page import="java.util.stream.IntStream" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.stream.Collectors" %>
<%
    int currentYear = LocalDate.now().getYear();
    List<Integer> years = IntStream.rangeClosed(currentYear - 10, currentYear + 10).boxed().collect(Collectors.toList());
    request.setAttribute("years", years);
%>


<h2 class="studentmanage"
	style="
	width:79%;
	background-color:#DCDCDC; 
	padding: 5px; 
	margin-bottom: 10%;
	margin-left: 20%;">学生登録</h2>

<div style="text-align: center; overflow: hidden;">
<form action="../studentlist/StudentCreate.action" method="post">
	<label style="float: left; padding-left: 170px">入学年度</label><br> 
		<select class="form-select" id="ent_year" name="ent_year" style="width: 700px; height: 40px;">
    		<option value="0">------</option>
    			<c:forEach var="year" items="${years}">									
        			<option value="${year}">${year}</option>
    			</c:forEach>
		</select>
		
	<br>
	<label style="float: left; padding-left: 170px">学生番号</label><br>
		<input type="text" name="no" placeholder="学生番号を入力してください。" required
		style="width: 700px; height: 40px;">
	<br>
	<label style="float: left; padding-left: 170px">氏名</label><br>
		<input type="text" name="name" placeholder="氏名を入力してください。" required
		style="width: 700px; height: 40px;">
	<br>
	<label style="float: left; padding-left: 170px">クラス</label><br>
		<select class="form-select" id="class_num" name="class_num" style="width: 700px; height: 40px;">
    		<option value="0">------</option>
    		<c:forEach var="classNumArray" items="${classNums}">
        		<c:forEach var="classNum" items="${classNumArray}">									
            		<option value="${classNum}">${classNum}</option>
        		</c:forEach>
    		</c:forEach>
		</select>
		
	<br>
	<input type="submit" value="登録して終了"
			style="	color: white;
					margin-top: 50px;
					cursor: pointer;
					height: 55px;
					width: 97px; 
					background-color: #87CEEB;
					border-radius: 1rem;
					border-style: none;">
	<a href="../studentlist/StudentAllList.action" style="display: flex; padding: 60px 250px;">戻る</a>
</form>
</div>


<%@include file="../footer.html" %>
