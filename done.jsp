	<%@page import="com.moldels.donthuocDB"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	    pageEncoding="UTF-8"%>
	<%@ page
		import="java.time.LocalDate, java.time.Period, java.time.format.DateTimeFormatter"%>
	<%@ page import="com.moldels.BNDB"%>
	<%@ page import="com.moldels.BN"%>
	<%@ page import="com.moldels.ctdonthuocDB"%>
	<%@ page import="com.moldels.ctdonthuoc"%>
	<%@ page import="com.moldels.thuocDB"%>
	<%@page import="java.util.List"%>
	<!DOCTYPE html>
	<html>
	<head>
	    <link rel="stylesheet" href="../styles/styledonee.css">
	    <meta charset="UTF-8">
	    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	    <title>Done
	    </title>
	</head>
	
	<body>
	    <%
		String id = request.getParameter("idbn");
		BN bn = BNDB.getBNByIdbn(id);
		String iddt = request.getParameter("iddt");
		int iddt1 = Integer.parseInt(iddt);
		String idbs = request.getParameter("idbs");
		LocalDate birthdate = LocalDate.parse(bn.getNs(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		int age = Period.between(birthdate, LocalDate.now()).getYears();
		%>
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
		</br>
		<div id="container">
			<form action="done.jsp">
				</br>
				<div id="IDDT">
					<b>ID: DT<%=iddt.trim()%></b>
				</div>
				</br>
				<div id="tab">
					<table>
						<tr>
							<td>ID bệnh nhân:</td>
							<td><%=bn.getIdbn()%></td>
						</tr>
						<tr>
							<td>Tên bệnh nhân:</td>
							<td><%=bn.getTenbn()%></td>
						</tr>
						<tr>
							<td>Địa chỉ:</td>
							<td><%=bn.getDc()%></td>
						</tr>
						<tr>
							<td>SĐT:</td>
							<td><%=bn.getSdt()%></td>
						</tr>
						<tr>
							<td>Phái:</td>
							<td><%=bn.getGt()%></td>
						</tr>
						<tr>
							<td>Tuổi:</td>
							<td><%=age%></td>
						</tr>
					</table>
				</div>
				</br>
				<div id="CT">
					<table>
						<tbody id="medicinesTableBody">
							<%
								List<ctdonthuoc> ctdt = ctdonthuocDB.getAllCTByIddt(iddt1);
								int stt = 1;
								String ngayLapString = donthuocDB.getNTByID(iddt1);
							    DateTimeFormatter oldFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
							    DateTimeFormatter newFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
							    LocalDate ngayLap = LocalDate.parse(ngayLapString, oldFormatter);
							    String formattedNgayLap = ngayLap.format(newFormatter);
								for (ctdonthuoc ct: ctdt){
									String idThuoc = ct.getIdthuoc();
							        String tenthuoc = thuocDB.getThuocNameById(idThuoc);
							%>
							<tr>
								<td style="vertical-align: top; padding-right: 20px"><%= stt++ %>.</td>
								<td>
									<div><%=tenthuoc %></div>
									<div style="font-size: 30px; vertical-align: top;">Ngày uống <%=ct.getTs() %> lần, mỗi lần <%= ct.getLieuluong() %> viên</div>
								</td>
								<td style="width: 100px; text-align: right; vertical-align: top;"><%=ct.getSl() %></td>
								<td style="width: 100px; text-align: center; vertical-align: top; padding-left: 10px;"><%= ct.getDang() %></td>
							</tr>
							<%}%>
						</tbody>
					</table>
				</div>
				</br>
				<div>
	            <p>
	                <span class="nlap"><b>Ngày kê đơn:</b> <%= formattedNgayLap %></span>
	                <span class="id-right" style="margin-top: 50px; margin-bottom: 50px">
					<b>ID Bác sĩ phụ trách:</b><%=idbs.trim()%></span>
	            </p>
	        </div>
				</br> <input type="submit" name="ht-btn" class="ht-btn"
					value="In đơn thuốc">
			</form>
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