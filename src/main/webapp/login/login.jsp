<%-- ログイン画面JSP --%>
<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../header.html" %>

<form action="Login.action" method="post">
    <title>
        ログイン画面
    </title>
    <p>
        ログインID<input type="text" name="id">
    </p>
    <p>
        パスワード<input type="password" name="password">
    </p>
    <p>
        <input type="submit" value="ログイン">
    </p>
</form>

<%@include file="../footer.html" %>