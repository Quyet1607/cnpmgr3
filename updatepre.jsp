<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<link rel="stylesheet" href="../styles/styleadd.css">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Add medicine 1</title>
</head>
<body>
	<div id="header">
		<div class="header-top">
			<div class="header-top-left">
				<img src="../images/Group 145.png" alt="group-3-medicine">
			</div>
			<div class="header-top-r">
				<div class="header-top-center">
					<button style="font-size: 20px;" class="button-login ls">Lịch
						sử đơn thuốc</button>
				</div>
				<div class="header-top-right">
					<img src="../images/Group 153.png" alt="user">
				</div>
			</div>

		</div>
		<div class="header-bottom">
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
	<div id="container">
		<h2 style="font-size: 50px; margin-bottom: 30px;">Tiến hành kê
			đơn</h2>
		<div class="form-group">
			<%
			String idbn = request.getParameter("idbn");
			String idThuoc = request.getParameter("idthuoc");
			%>
			<form action="updatectThuoc" method="get">
			<div class="form-group1" style="margin-bottom: 30px">
				ID bệnh nhân:
				<%=idbn%>
			</div>
				<div class="main-form">
					<div class="form-group row">
						<label for="medicineName">Tên thuốc:</label>
						<div>
							<input class="form-control" type="text" name="tenthuoc" id="medicineName" onblur="checkAndRenderTable()" onblur="testMedication()" required><br>
						</div>
					</div>
					<div class="decriptions">
						<div style="font-size: 20px;" class="decrip" id="medicineDescription">
							<script type="text/javascript">
							function checkAndRenderTable() {
							    const medicineName = document.getElementById('medicineName').value;
							    fetch('/cnpmapp/views/getMedicineDescriptionServlet?medicineName=' + encodeURIComponent(medicineName))
							        .then(response => response.text())
							        .then(description => {
							            // Hiển thị mô tả thuốc
							            const descriptionDiv = document.getElementById('medicineDescription');
							            descriptionDiv.innerHTML = description;
							        })
							        .catch(error => console.error('Error:', error));
							}
							</script>
						</div>
					</div>
					<div class="sldt row">
						<div class="col">
							<div class="form-group1">
								<label for="medicineSL">Số lượng:</label>
								<div>
									<input class="form-control" type="text" name="sl" id="medicineSL"  required><br>
								</div>
							</div>
						</div>
						<div class="col">
							<div class="form-group1">
								<label for="medicineLoai">Dạng thuốc:</label> 
								<select class="form-control" name="dang" id="medicineLoai" >
									<option value="Viên">Viên</option>
									<option value="Ống">Ống</option>
									<option value="Chai">Chai</option>
								</select>
							</div>
						</div>
					</div>
					<div class="form-group row">
						<label for="medicineLL">Liều lượng:</label>
						<div>
							<input
								style="margin-left: 15px; max-width: 50px; margin-right: 10px;" id="medicineLL"
								class="form-control" type="text" name="lieuluong" onblur="testMedication()" required><br>

						</div>
						<span> viên 200mg</span>
					</div>
					<div class="form-group row">
						<label for="medicinefre">Tần suất:</label>
						<div>
							<input style="max-width: 50px; margin-right: 10px;" id="medicinefre"
								class="form-control" type="text" name="ts" value=0 onblur="testMedication()" required><br>
						</div>
						<span> \ ngày</span>
					</div>
					<div class="unit" >
					<div style="font-size: 20px; color:red;" id="result">
						<script type="text/javascript">
						function testMedication() {
						    const medicineName = document.getElementById('medicineName').value;
						    const medicineLL = document.getElementById('medicineLL').value;
						    const medicinefre = document.getElementById('medicinefre').value;

						    fetch('/cnpmapp/views/getUnit?medicineName=' + encodeURIComponent(medicineName) + '&medicineLL=' + encodeURIComponent(medicineLL) + '&medicinefre=' + encodeURIComponent(medicinefre))
						        .then(response => response.text())
						        .then(result => {
						            // Hiển thị kết quả unit test
						            const unitDiv = document.getElementById('result');
						            unitDiv.innerHTML = result;
						        })
						        .catch(error => console.error('Error:', error));
						}
						</script>
					</div>
					</div>
				</div>
				<div class="add row">
					<div>
						<table id="medicineTable" style="display: none;">
                        	<tbody id="medicinesTableBody">
								
                        </tbody>
                    </table>
					</div>
					<div class="col">
						<input type="hidden" name="idbn" value="<%= idbn%>">
						<input type="hidden" name="iddt" value="${dt.iddt}">
						<input type="hidden" name="idbs" value="${dt.idbs}">
						<input type="hidden" name="idthuoc" value="<%=idThuoc%>">
						<input style="color: black; font-size: 14px;" class="button-login"
							type="submit" value="Lưu" >
					</div>
				</div>
			</form>
		</div>
		
		
		
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