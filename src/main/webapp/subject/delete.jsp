<%@page contentType="text/html; charset=UTF-8"%>
<%@include file="../header.html" %>

<html>
    <head>
        <title>科目データを削除する</title>
    </head>
    <body>
        <div style="text-align:center">
            <h2 style="text-align:center">科目削除画面</h2>
            <hr style="height:3; background-color:#0000ff" />
            <br>
            <form action="../subject/delete" method="post">
                削除する科目のコードを入力してください。
                <table style="margin:0 auto">
                <br>
                    <tr>
                        <td style="width:90">科目コード</td>
                        <td ><input type=text size="30" name="cd"></input></td>
                        <td colspan=2 style="text-align:right">
                            <input type="submit" value="削除">
                        </td>
                    </tr>
                </table>
            </form>
            <br>
        </div>
    </body>
 </html>
<%@include file="../footer.html" %>