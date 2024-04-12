<%-- ログイン画面JSP --%>
<%@page content type="text/html; charset=UTF-8" %>
<%@include file="../header.html" %>

<form action="Login.action" method="post">
    <title>
        ログイン画面
    </title>
    <p>
        ログインID<input type="text" name="login">
    </p>
    <p>
        パスワード<input type="password" name="pssword">
    </p>
    <p>
        <input type="submit" value="ログイン">
    </p>
</form>

<%@include file="../footer.html" %>