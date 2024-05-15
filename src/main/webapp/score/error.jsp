<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.io.BufferedReader, java.io.FileReader, java.io.BufferedWriter, java.io.FileWriter, java.io.IOException" %>
    
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>error.counter</title>
    <style>
        body {
            
            background-color: #4169e1;
            color: white;
        }
       
        }
        h1 {
            font-size: 80px;}
            
        
    </style>
</head>
<body>
    <div class="container">
        <%
            // カウンターのファイルパスを指定
            String filePath = "counter.txt";
            
            // カウンターの値を読み込む
            int count = 0;
            try {
                BufferedReader reader = new BufferedReader(new FileReader(filePath));
                count = Integer.parseInt(reader.readLine());
                reader.close();
            } catch (IOException e) {
                // ファイルが存在しない場合は新しく作成する
                count = 0;
            }
            
            // カウンターの値を更新する
            count++;
            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
                writer.write(String.valueOf(count));
                writer.close();
            } catch (IOException e) {
                // カウンターの値を保存できない場合はエラーメッセージを表示
                out.println("カウンターの更新に失敗しました。");
            }
        %>

        <h1>:(</h1>
    <h2> Error</h2>
    <p>tukuttetakedo, baguttayo...</p>
        <p>	<%= count %> % tukurukinaiyo</p>
    </div>
</body>
</html>
