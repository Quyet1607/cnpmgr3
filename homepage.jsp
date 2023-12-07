<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="../styles/stylehp.css">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Home page</title>
</head>
<body>
	<div id="header">
        <div class="header-top">
            <div class="header-top-left">
                <img src="../images/Group 145.png" alt="group-3-medicine">
            </div>
            <div class="header-top-right" >
                <img src="../images/Group 153.png" alt="user">
            </div>
        </div>
        <div class="header-bottom" >
            <div class="banner">
                <div class="banner-image">
                    <img src="../images/Rectangle 52.png" alt="">
                </div>
                <a href="addmedicine.jsp">
				<div class="banner-button">
					<p>KÊ ĐƠN THUỐC</p>
				</div>
				</a>
            </div>
        </div>
    </div>
    <div id="container" >
        <div class="button-login">
            <p>BÁC SĨ ĐĂNG NHẬP</p>
        </div>
        <script>
            document.querySelector('.button-login').addEventListener('click', function() {
                window.location.href = 'login.html';
            });
        </script>
    </div>
    <div id="footer">
        <div class="footer-left">
            <p>copyright @2023 Cong nghe phan mem</p>
        </div>
        <div class="footer-right" >
            <p>Group 3</p>
        </div>
    </div>
</body>
</html>