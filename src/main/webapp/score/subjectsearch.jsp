<%@page contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="../header.html"%>
<%@include file="../sidebar.html"%>

<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="../css/style.css">
    <style>
        body {
            padding-left: 250px; /* サイドバーの幅を考慮して左側に余白を追加 */
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
            background-color: #DCDCDC;
            top: 0; /* ヘッダーを画面上部に配置 */
            left: 250px; /* サイドバーの幅分だけ左にずらす */
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
            border-radius: 10px; /* 枠組みに丸みを持たせる */
        }

        /* サイドバーのスタイル */
        .sidebar {
            width: 250px;
            position: fixed;
            top: 0;
            left: 0;
            height: 100%;
            padding-top: 20px;
        }
        

    </style>
</head>

<body>

    <h2 >成績一覧(科目)</h2>
    <div class="search-section">
        <form action="Score.action" method="post" >
            <p style="display: inline-block; margin-right: 20px;">科目情報</p>
            <div style="display: inline-block; margin-right: 20px;">
                <p>クラス</p>
                <select name="class_num" id="class_num">
                    <option value="">--------</option>
                    <option value="101">101</option>
                    <option value="201">201</option>
                    <option value="131">131</option>
                    <!-- 他のクラスのオプションを追加 -->
                </select>
            </div>

            <div style="display: inline-block; margin-right: 20px;">
                <p>教科</p>
                <input type="text" name="subject" id="subject" placeholder="教科を入力">
            </div>

            <div style="display: inline-block;">
                <p>入学年度</p>
                <select name="ent_year" id="ent_year">
                    <option value="">---------</option>
                    <option value="2021">2021年</option>
                    <option value="2022">2022年</option>
                    <option value="2023">2023年</option>
                    <!-- 他の年度のオプションを追加 -->
                </select>
            </div>

            <input type="submit" value="検索">
        </form>
        <p style="color: #ffd700;">${errorMessage}</p>

        <hr>

        <form action="StudentSearch.action" method="post">
            <p style="display: inline-block; margin-right: 20px;">学生情報</p>
            <input type="text" name="student_no" placeholder="学生番号を入力してください">
            <input type="submit" value="検索">
        </form>
        <p style="color: black;">${errorMessage2}</p>
    </div>

    <a href="scorelist.jsp">一覧表示</a>
    <a href="error.jsp" style="color:white;">oo</a>

    <table style="border-collapse: separate; border-spacing: 10px">
        <tr>
            <th>教科</th>
            <th>入学年</th>
            <th>クラス</th>
            <th>学生番号</th>
            <th>名前</th>
            <th>回数</th>
            <th>点数</th>
        </tr>
        <c:forEach var="score" items="${list}">
            <tr>
                <td>${score.subject_name}</td>
                <td>${score.ent_year}年</td>
                <td>${score.class_num}</td>
                <td>${score.student_no}</td>
                <td>${score.name}</td>
                <td>${score.test_no }回目</td>
                <td>${score.point}点</td>
            </tr>
        </c:forEach>
        
    </table>
</body>

<%@include file="../footer.html"%>
