package com.moldels;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.jdbc.JDBCUtil;

public class donthuocDB {
	public static int insertDonThuoc(donthuoc donthuoc) {
		try (Connection connection = JDBCUtil.getConnection();
	             PreparedStatement preparedStatement = connection.prepareStatement(
	                     "INSERT INTO donthuoc (idbn, idbs, ngaytao, trangthai) VALUES (?, ?, ?, ?)",
	                     PreparedStatement.RETURN_GENERATED_KEYS)) {
				preparedStatement.setString(1, donthuoc.getIdbn());
				preparedStatement.setString(2, donthuoc.getIdbs());
				preparedStatement.setString(3, donthuoc.getNgaytao());
				preparedStatement.setString(4, donthuoc.getTrangthai());
				
				int affectedRows = preparedStatement.executeUpdate();
				
				if(affectedRows > 0) {
					try(ResultSet generatedKeys = preparedStatement.getGeneratedKeys()){
						if(generatedKeys.next()) {
							int generatedID = generatedKeys.getInt(1);
							donthuoc.setIddt(generatedID);
							System.out.println("ID vừa được tạo " + generatedID);
							return generatedID;
						} else {
							System.out.println("Không thể lấy ID được tạo.");
							return 0;
						}
					}
				}else {
					System.out.println("Thêm đơn thuốc thất bại");
					return 0;
				}

	        } catch (SQLException e) {
	            System.err.println("Error connecting to the database: " + e.getMessage());
	            e.printStackTrace();
	            return 0;
	        }
    }
	public static boolean updateTrangThai(int IDDT) {
        try (Connection connection = JDBCUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "UPDATE donthuoc SET TRANGTHAI='hoàn thành' WHERE IDDT=?")) {
            preparedStatement.setInt(1, IDDT);

            int affectedRows = preparedStatement.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("Cập nhật trạng thái thành công");
            } else {
                System.out.println("Không có dữ liệu nào được cập nhật");
            }
            return affectedRows > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
	
	public static String getNTByID(int iddt) {
        String ngaytao = null;

        try (Connection connection = JDBCUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "SELECT NGAYTAO FROM donthuoc WHERE iddt = ?")) {
            preparedStatement.setInt(1, iddt);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                ngaytao = resultSet.getString("NGAYTAO");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ngaytao;
    }
	private static final String SELECT_BY_PATIENT_ID = "SELECT * FROM donthuoc WHERE IDBN = ?";

    public static List<donthuoc> getAllByPatientId(String patientId) {
        List<donthuoc> prescriptions = new ArrayList<>();
        try (Connection connection = JDBCUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_PATIENT_ID)) {
            preparedStatement.setString(1, patientId);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    donthuoc donthuoc = new donthuoc();
                    donthuoc.setIddt(resultSet.getInt("IDDT"));
                    donthuoc.setIdbn(resultSet.getString("IDBN"));
                    donthuoc.setIdbs(resultSet.getString("IDBS"));
                    donthuoc.setNgaytao(resultSet.getString("NGAYTAO"));
                    donthuoc.setTrangthai(resultSet.getString("TRANGTHAI"));
                    prescriptions.add(donthuoc);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return prescriptions;
    }
}
