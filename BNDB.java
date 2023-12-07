package com.moldels;

import java.sql.*;

import com.jdbc.JDBCUtil;
import com.moldels.*;

public class BNDB {

	public static BN getBNByIdbn(String idbn) {
        BN bn = null;
        try (Connection connection = JDBCUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "SELECT * FROM benhnhan WHERE IDBN = ?")) {
            preparedStatement.setString(1, idbn);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    bn = new BN(
                            resultSet.getString("IDBN"),
                            resultSet.getString("TENBN"),
                            resultSet.getString("NS"),
                            resultSet.getString("GT"),
                            resultSet.getString("SDT"),
                            resultSet.getString("DC")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bn;
    }
}
