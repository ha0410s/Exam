<%@page contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="../header.html"%>
<%@include file="../sidebar.html"%>

<style>
    .table-container {
        display: flex;
        justify-content: center;
        
    }
    table {
        border-collapse: collapse;
        width: 750px;
        margin-left: 100px;
    }
    table, th, td {
        border: 1px solid black;
        padding: 10px;
    }
</style>

<h2 class="studentmanage"
    style="
    width:79%;
    background-color:#DCDCDC; 
    padding: 5px; 
    margin-bottom: 5%;
    margin-left: 20%;">掲示板</h2>
<div class="table-container">
    <section class="me-4" style="width: 100%;">
        <div style="margin-left:40px;margin-bottom:30px;">
			<div class="my-2 text-end px-4" style="margin-bottom: 1rem; margin-left: 500px;">
				<a href="../post/postcreate.jsp">新規登録</a>
			</div>
			
		</div>	
	
		<c:choose>
			<c:when test="${empty list}">
				検索結果：0件<br>
				投稿が存在しませんでした。
			</c:when>
        <c:otherwise>
            <table>
                <c:forEach var="post" items="${list}">
                    <c:if test="${post != null}">
                        <tr>
                            <td>${post.post_id}</td>
                            <td>${post.user_id}</td>
                            <td>${post.post_time}</td>
                            <td>${post.content}</td>
                        </tr>
                    </c:if>
                </c:forEach>
            </table>
        </c:otherwise>
        </c:choose>
    </section>
</div>
<%@include file="../footer.html"%>
	
	
	