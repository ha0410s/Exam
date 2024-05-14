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

<style>
    textarea {
        padding-top: 5px;    /* 上部のパディングを小さくする */
        padding-bottom: 15px;  /* 下部のパディングを大きくする */
    }
</style>

<h2 class="studentmanage"
    style="
    width:79%;
    background-color:#DCDCDC; 
    padding: 5px; 
    margin-bottom: 10%;
    margin-left: 20%;">掲示板投稿</h2>

<div style="text-align: center; overflow: hidden;">
<form action="../post/PostCreate.action" method="post">
    <label style="float: left; padding-left: 170px">投稿者</label>
    <label style="float: left; padding-left: 80px">${teacher.id}</label>
    <br>
    <br>
    <label style="float: left; padding-left: 170px">投稿内容</label><br>
        <textarea name="content" placeholder="入力してください。" required
        style="width: 700px; height: 200px;"></textarea>
    <br>
    <input type="submit" value="投稿する" 
            style="    color: white;
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
