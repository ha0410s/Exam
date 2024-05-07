<%-- ログイン画面JSP --%>
<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../beforeloginheader.html" %>


    <div style="text-align: center;">
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
    
    
    <input type="password" name="password" placeholder="パスワード" required
    style="width: 30%;
  	box-sizing: border-box;
 	margin: 1em 0;
  	padding: .8em;
  	border-radius: 1em;
  	border: 2px solid #aaa;">
    
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