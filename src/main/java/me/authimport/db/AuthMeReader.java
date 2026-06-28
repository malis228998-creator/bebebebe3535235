package me.authimport.db;

import java.sql.*;
import java.io.File;
import java.util.*;

public class AuthMeReader {
    private final Connection connection;

    public AuthMeReader(File db) throws SQLException {
        connection = DriverManager.getConnection("jdbc:sqlite:" + db.getAbsolutePath());
    }

    public Map<String,String> loadUsers() throws SQLException {
        Map<String,String> map = new HashMap<>();
        String sql = "SELECT username, password FROM authme";
        try (PreparedStatement ps = connection.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                map.put(rs.getString("username").toLowerCase(),
                        rs.getString("password"));
            }
        }
        return map;
    }
}
