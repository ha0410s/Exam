<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../beforeloginheader.html" %>

<script>
function togglePasswordVisibility() {
    var passwordInput = document.getElementById("password");
    if (passwordInput.type === "password") {
        passwordInput.type = "text";
    } else {
        passwordInput.type = "password";
    }
}
</script>

<div style="text-align: center;">
	<ul id="error-messages" style="list-style:none;">
        <li>ログインに失敗しました。IDまたはパスワードが正しくありません。</li>
    </ul>
    <form action="Login.action" method="post">
    <title>
        ログイン画面
    </title>
    <input type="text" name="id" placeholder="ID" required
    style="
    width: 30%;
    box-sizing: border-box;
    margin: 1em 0;
    padding: .8em;
    border-radius: 1em;
    border: 2px solid #aaa;">
    <br>
    
    <input type="password" id="password" name="password" placeholder="パスワード" required
    style="width: 30%;
    box-sizing: border-box;
    margin: 1em 0;
    padding: .8em;
    border-radius: 1em;
    border: 2px solid #aaa;">
    <br>
    <input type="checkbox" onclick="togglePasswordVisibility()" > パスワードを表示する
    <br>
    
    <input type="submit" value="ログイン" 
    style="
    width: 10%; 
    background-color: #87CEFA; 
    color: white; 
    box-sizing: border-box;
    margin: 1em 0;
    padding: .8em;
    border-radius: 1em;
    border: 2px solid #aaa;">
    </form>   
</div>

<%@include file="../footer.html" %>


   