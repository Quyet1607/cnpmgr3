<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link rel="stylesheet" href="../styles/styleadd.css">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add medicine</title>
</head>
<body>
    <div id="header">
        <div class="header-top">
            <div class="header-top-left">
                <img src="../images/Group 145.png" alt="group-3-medicine">
            </div>
            <div class="header-top-r" >
                <div class="header-top-center">
					<form action="check.jsp">
						<input type="submit" style="font-size: 20px; width: 300px;height: 40px; margin-right: 20px" class="button-login ls" value="Lịch sử đơn thuốc" >
					</form>
				</div>
                <div class="header-top-right" >
                    <img src="../images/Group 153.png" alt="user">
                </div>
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
        <h2 style="font-size: 50px; margin-bottom: 30px;">Tiến hành kê đơn</h2>
        <div class="form-group">
            <form  action="createpre" method="get">
                <div class="form-group1">
                    <label>Chọn ID bệnh nhân:</label>
                    <div >
                        <input class="form-control"  type="text" placeholder="Enter id" name="idbn"required><br>    
                    </div>
                    <div>
                    	<%
                    		String idbs = request.getParameter("idbs");
                    	%>
                    	<input type="hidden" name="idbs" value="<%=idbs%>">
                    	<input type="submit" class="form-control" value="Xác nhận" style="background-color: #24BEE0; border-radius: 47px; color: white">
                    </div>
                </div>
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