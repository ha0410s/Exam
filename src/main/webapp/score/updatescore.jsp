<%@page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="../header.html" %>
<%@include file="../sidebar.html"%>

<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="../css/style.css">
    <style>
        body {
            padding-left: 250px;
        }

        table {
            border-collapse: collapse;
            width: 100%;
        }

        th, td {
            border-bottom: 1px solid black;
            padding: 8px;
            text-align: left;
        }

        h2 {
            width: 79%;
            padding: 5px;
            margin-bottom: 5%;
            border-radius: 10px;
            top: 0;
            left: 250px;
            background-color:#DCDCDC;
        }

        input[type="submit"] {
            background-color: gray;
            color: white;
            border: none;
            padding: 5px 10px;
            cursor: pointer;
            border-radius: 5px;
        }

        .search-section {
            border: 1px solid black;
            padding: 10px;
            margin-bottom: 20px;
            border-radius: 10px;
        }

        .sidebar {
            width: 250px;
            position: fixed;
            top: 0;
            left: 0;
            height: 100%;
            padding-top: 20px;
        }

        .option-container {
            border: 1px solid black;
            border-radius: 10px;
            padding: 10px;
            margin-bottom: 20px;
        }

        .submit-container {
            margin-top: 20px;
        }
        
        select {
            display: inline-block;
        }

        option {
            display: inline-block;
            padding: 5px;
            margin-right: 10px;
        }
    </style>
</head>

<div class="management-container">
    <h2>成績管理</h2>
    <div class="option-container">
        <form action="../score/UpdateSearch.action" method="post">
            <div style="display: inline-block; margin-right: 20px;">
                <p>入学年度</p>
                <select name="ent_year">
                    <option value="">----</option>
                    <option value="2021">2021</option>
                    <option value="2022">2022</option>
                    <option value="2023">2023</option>
                    <!-- 他の年度のオプションを追加 -->
                </select>
            </div>
            <div style="display: inline-block; margin-right: 20px;">
                <p>クラス</p>
                <select name="class_num">
                    <option value="">---</option>
                    <option value="101">101</option>
                    <option value="201">201</option>
                    <option value="131">131</option>
                    <!-- 他のクラスのオプションを追加 -->
                </select>
            </div>
            
            <div style="display: inline-block;">        
                <p>科目</p>    
                <input type="text" name="subject" placeholder="科目名を入力">
            </div>
            
            <div style="display: inline-block;">
                <p>回数</p>
                <select name="test_no">
                    <option value="">--</option>
                    <option value="1">01</option>
                    <option value="2">02</option>
                </select>
            </div>
            <input type="submit" value="検索">
        </form>
    </div>

    <p style="color: #ffd700;">${errorMessage}</p>
    <hr>

    <form action="updatesuccess.jsp" method="post">
        <table style="border-collapse:separate;border-spacing:10px">
            <tr>
                <th>入学年</th>
                <th>クラス</th>
                <th>学生番号</th>
                <th>氏名</th>
                <th>点数</th>
            </tr>
            <c:forEach var="score" items="${list}">
                <tr>
                    <td>${score.subject_name}</td>
                    <td>${score.class_num}</td>
                    <td>${score.student_no}</td>
                    <td>${score.name}</td>
                    <td>
                        <input type="text" name="point" value="${score.point}">
                    </td>
                </tr>
            </c:forEach>
        </table>
        <p style="color: #ffd700;">${errorMessage4}</p>
        <c:if test="${not empty list}">
            <div class="submit-container">
                <input type="submit" value="保存して終了">
            </div>
        </c:if>
    </form>
</div>

<%@include file="../footer.html"%>
