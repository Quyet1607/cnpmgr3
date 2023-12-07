package com.moldels;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.jdbc.JDBCUtil;

public class ctdonthuocDB {
	public static void insertctdonthuoc(ctdonthuoc ctdonthuoc) {
		try (Connection connection = JDBCUtil.getConnection();
	             PreparedStatement preparedStatement = connection.prepareStatement(
	                     "INSERT INTO ctdonthuoc (iddt, idthuoc, lieuluong, ts, sl, dang) VALUES (?, ?, ?, ?, ?, ?)")) {
				preparedStatement.setInt(1, ctdonthuoc.getIddt());
				preparedStatement.setString(2, ctdonthuoc.getIdthuoc());
				preparedStatement.setInt(3, ctdonthuoc.getLieuluong());
				preparedStatement.setInt(4, ctdonthuoc.getTs());
				preparedStatement.setInt(5, ctdonthuoc.getSl());
				preparedStatement.setString(6, ctdonthuoc.getDang());
				
				preparedStatement.executeUpdate();
				

	        } catch (SQLException e) {
	            System.err.println("Error connecting to the database: " + e.getMessage());
	            e.printStackTrace();
	        }
    }
	
	public static List<ctdonthuoc> getAllCTByIddt(int IDDT) {
        List<ctdonthuoc> ctList = new ArrayList<>();

        try (Connection connection = JDBCUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "SELECT * FROM ctdonthuoc WHERE IDDT=?")) {
            preparedStatement.setInt(1, IDDT);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                ctdonthuoc ct = new ctdonthuoc();
                ct.setIddt(resultSet.getInt("IDDT"));
                ct.setIdthuoc(resultSet.getString("IDTHUOC"));
                ct.setLieuluong(resultSet.getInt("LIEULUONG"));
                ct.setTs(resultSet.getInt("TS"));
                ct.setSl(resultSet.getInt("SL"));
                ct.setDang(resultSet.getString("DANG"));

                ctList.add(ct);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ctList;
    }
	public static boolean updateCTById(int IDDT,String IDTHUOC, ctdonthuoc ctdt) {
        try (Connection connection = JDBCUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "UPDATE ctdonthuoc SET IDTHUOC=?, LIEULUONG=?, TS=?, SL=?, DANG=? WHERE IDDT=? AND IDTHUOC=?")) {
            preparedStatement.setString(1, ctdt.getIdthuoc());
            preparedStatement.setInt(2, ctdt.getLieuluong());
            preparedStatement.setInt(3, ctdt.getTs());
            preparedStatement.setInt(4, ctdt.getSl());
            preparedStatement.setString(5, ctdt.getDang());
            preparedStatement.setInt(6, IDDT);
            preparedStatement.setString(7, IDTHUOC);

            int affectedRows = preparedStatement.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("Cập nhật ct thành công");
            } else {
                System.out.println("Cập nhật ct thất bại");
                System.out.println("IDDT: " + IDDT);
                System.out.println("IDTHUOC: " + IDTHUOC);
                System.out.println("IDTHUOC mới: " + ctdt.getIdthuoc());
                System.out.println("LIEULUONG: " + ctdt.getLieuluong());
                System.out.println("TS: " + ctdt.getTs());
                System.out.println("SL: " + ctdt.getSl());
                System.out.println("DANG: " + ctdt.getDang());
            }
            return affectedRows > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
	public static boolean deleteCTById(int IDDT, String IDTHUOC) {
        try (Connection connection = JDBCUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "DELETE FROM ctdonthuoc WHERE IDDT=? AND IDTHUOC=?")) {
            preparedStatement.setInt(1, IDDT);
            preparedStatement.setString(2, IDTHUOC);

            int affectedRows = preparedStatement.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("Xóa dữ liệu thành công");
            } else {
                System.out.println("Không có dữ liệu nào được xóa");
            }
            return affectedRows > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
	}
	public static ctdonthuoc getCTDonThuocByIds(int idDonThuoc, String idThuoc) {
	    ctdonthuoc ctDonThuoc = null;

	    try (Connection connection = JDBCUtil.getConnection();
	         PreparedStatement preparedStatement = connection.prepareStatement(
	                 "SELECT * FROM ctdonthuoc WHERE IDDT = ? AND IDTHUOC = ?")) {
	        preparedStatement.setInt(1, idDonThuoc);
	        preparedStatement.setString(2, idThuoc);

	        ResultSet resultSet = preparedStatement.executeQuery();
	        if (resultSet.next()) {
	            int iddt = resultSet.getInt("IDDT");
	            String idthuoc = resultSet.getString("IDTHUOC");
	            int lieuluong = resultSet.getInt("LIEULUONG");
	            int ts = resultSet.getInt("TS");
	            int sl = resultSet.getInt("SL");
	            String dang = resultSet.getString("DANG");
	            // Lấy các trường khác tương tự

	            ctDonThuoc = new ctdonthuoc(iddt, idthuoc, lieuluong, ts, sl, dang);
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return ctDonThuoc;
	}

}
