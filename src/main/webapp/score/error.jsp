<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Rainbow Emoji Rotation</title>
    <style>
        /* Rainbow Styles */
        body {
            background: linear-gradient(to right, violet, indigo, blue, green, yellow, orange, red);
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            overflow: hidden;
            position: relative; /* 似顔絵の上に重ねるために position: relative; を追加 */
        }

        .rainbow-container {
            width: 300px;
            height: 300px;
            display: flex;
            justify-content: center;
            align-items: center;
            perspective: 1000px;
        }

        .emoji {
            font-size: 100px;
            animation: rotateEmoji 5s linear infinite, changeColor 5s linear infinite;
        }

        @keyframes rotateEmoji {
            0% {
                transform: rotate(0deg);
            }
            100% {
                transform: rotate(360deg);
            }
        }

        @keyframes changeColor {
            0% {
                filter: hue-rotate(0deg);
            }
            100% {
                filter: hue-rotate(360deg);
            }
        }

        h1 {
            position: absolute; /* 似顔絵の上に重ねるために position: absolute; を追加 */
            top: 50%; /* 上下中央に配置するために top: 50%; を追加 */
            left: 50%; /* 左右中央に配置するために left: 50%; を追加 */
            transform: translate(-50%, -50%); /* 中央配置の微調整 */
            font-size: 24px; /* フォントサイズを調整 */
            color: white; /* 文字色を白に設定 */
            mix-blend-mode: difference; /* 虹色の背景に対してコントラストの高い色になるように設定 */
        }
    </style>
</head>
<body>
    <div class="rainbow-container">
        <div class="emoji">😊</div>
        <h1>エラーページです。ブラウザを閉じてください。</h1> <!-- h1 タグを追加 -->
    </div>
</body>
</html>
