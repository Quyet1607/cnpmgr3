<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link rel="stylesheet" href="../styles/stylelg.css">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>login</title>
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
        <div class="form-group">
            <form action="bs" method="get">
                <div class="form-group row">
                    <label class="col">ID bác sĩ:</label>
                    <div class="col-25">
                        <input class="form-control"  type="text" placeholder="Enter id" name="idbs"required><br>
                    </div>
                </div>
                <div class="form-group row">
                    <label class="col">Mật khẩu:</label>
                    <div class="col-20">
                        <input class="form-control" type="password" placeholder="Enter password" name="password" required><br>
                    </div>
                </div>
		        <input class="button-login" type="submit"  value="Đăng nhập">
            </form>
        </div>
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