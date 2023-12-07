
<%@page import="com.moldels.donthuocDB"%>
<%@page import="com.moldels.donthuoc"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="../styles/stylecheck1.css">
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Check</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
</head>

<body>
	<div id="header">
		<div class="header-top">
			<div class="header-top-left">
				<img src="../images/Group 145.png" alt="group-3-medicine">
			</div>
			<div class="header-top-right">
				<img src="../images/Group 153.png" alt="user">
			</div>
		</div>
		<div class="header-bottom">
			<div class="banner">
				<div class="banner-image">
					<img src="../images/Rectangle 52.png" alt="">
				</div>
				<a href="login.jsp">
				<div class="banner-button">
					<p>KÊ ĐƠN THUỐC</p>
				</div>
				</a>
			</div>
		</div>
	</div>
	<div id="container">
		<h2 style="font-size: 50px; margin-bottom: 30px; margin-top:30px">Lịch sử đơn thuốc</h2>
        <div class="form-group">
                <div class="form-group1">
                    <%
					String idbn = request.getParameter("idbn");
					%>
					<div class="form-group1" style="margin-bottom: 30px">
						ID bệnh nhân:
						<%=idbn%>
					</div>
                </div>
        </div>
        <table class="table">
        	<thead class="thead-light">
        		<tr>
        			<th scope="col">ID đơn thuốc</th>
        			<th scope="col">ID bác sĩ</th>
        			<th scope="col">Ngày tạo</th>
        			<th scope="col">Trạng thái</th>
        			<th scope="col"></th>
        		</tr>
        	</thead>
        	<tbody>
        		<%
        			List<donthuoc> dt = donthuocDB.getAllByPatientId(idbn);
        			for (donthuoc dt1 : dt){
        		%>
        		<tr>
        			<td>DT<%= dt1.getIddt() %></td>
        			<td><%= dt1.getIdbs() %></td>
        			<td><%= dt1.getNgaytao() %></td>
        			<td><%= dt1.getTrangthai() %></td>
        			<td>
        				<form action="done.jsp">
        					<input type="hidden" name="idbn" value="<%= idbn%>">
							<input type="hidden" name="iddt" value="<%= dt1.getIddt()%>">
							<input type="hidden" name="idbs" value="<%= dt1.getIdbs()%>">
							<input class="btn btn-outline-info" type="submit" value="Xem đơn">
        				</form>
        			</td>
        		</tr>
        		<%} %>
        	</tbody>
        </table>
		
	</div>
		<div id="footer">
		<div class="footer-left">
			<p>copyright @2023 Cong nghe phan mem</p>
		</div>
		<div class="footer-right">
			<p>Group 3</p>
		</div>
	</div>
</body>
</html>