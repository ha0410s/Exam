<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../header.html" %>

<html>
    <head>
        <title>データを登録する</title>
    </head>
    <body>
        <div style="text-align:center">
            <h2 style="text-align:center">登録データ入力画面</h2>
            <hr style="height:3; background-color:#0000ff" />
            <br>
            <form action="../subject/insert" method="post">
                登録する科目の情報を入力してください。
                <table style="margin:0 auto">
                    <tr>
                        <td style="width:90">学校コード</td>
                        <td ><input type=text size="30" name="school_cd"></input></td>
                    </tr>
                <br>
                    <tr>
                        <td style="width:90">科目コード</td>
                        <td ><input type=text size="30" name="cd"></input></td>
                    </tr>
                    <tr>
                        <td style="width:70">科目名</td>
                        <td ><input type=text size="30" name="name"></input></td>
                    </tr>
                    <tr>
                        <td colspan=2 style="text-align:right">
                            <input type="submit" value="登録">
                        </td>
                    </tr>
                </table>
            </form>
            <br>
        </div>
    </body>
 </html>

<%@include file="../footer.html" %>