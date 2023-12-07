package com.moldels;

import java.sql.*;

import com.jdbc.JDBCUtil;

public class thuocDB {
	public static String getIDBYName(String tenthuoc) {
		String idthuoc = null;
		try (Connection connection = JDBCUtil.getConnection();
	             PreparedStatement preparedStatement = connection.prepareStatement(
	                     "SELECT idthuoc FROM thuoc WHERE tenthuoc = ?")){
							preparedStatement.setString(1, tenthuoc);
				
							ResultSet resultSet = preparedStatement.executeQuery();
							 if (resultSet.next()) {
				                    idthuoc = resultSet.getString("idthuoc");
				                }
			connection.close();
	        } catch (SQLException e) {
	            System.err.println("Error connecting to the database: " + e.getMessage());
	            e.printStackTrace();
	        }
		return idthuoc;
    }
	
	public static String getThuocNameById(String idthuoc) {
        String tenthuoc = null;

        try (Connection connection = JDBCUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "SELECT tenthuoc FROM thuoc WHERE idthuoc = ?")) {
            preparedStatement.setString(1, idthuoc);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                tenthuoc = resultSet.getString("tenthuoc");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return tenthuoc;
    }
	public static thuoc getThuocById(String idthuoc) {
        thuoc thuocInfo = null;

        try (Connection connection = JDBCUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "SELECT * FROM thuoc WHERE idthuoc = ?")) {
            preparedStatement.setString(1, idthuoc);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                thuocInfo = new thuoc();
                thuocInfo.setTenthuoc(resultSet.getString("tenthuoc"));
                thuocInfo.setLieumax(resultSet.getInt("lieumax"));
                thuocInfo.setLieumin(resultSet.getInt("lieumin"));
                thuocInfo.setTsmax(resultSet.getInt("tsmax"));
                thuocInfo.setUnit(resultSet.getInt("unit"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return thuocInfo;
    }
	public static String getMoTaByTenThuoc(String tenthuoc) {
        String mota = null;

        try (Connection connection = JDBCUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "SELECT mota FROM thuoc WHERE tenthuoc = ?")) {
            preparedStatement.setString(1, tenthuoc);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                mota = resultSet.getString("mota");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return mota;
    }
	public static String getMedicineDescription(String tenthuoc) {
        String mota = "";

        try (Connection connection = JDBCUtil.getConnection()) {
            String sql = "SELECT mota FROM thuoc WHERE tenthuoc = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
            	statement.setString(1, tenthuoc);

                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                    	mota = resultSet.getString("mota");
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return mota;
    }
}
