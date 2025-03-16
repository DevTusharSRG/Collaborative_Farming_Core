package com.colabfarm.dao;
import com.colabfarm.model.*;
import com.colabfarm.util.DBConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SchemeApplicationDAO {
    public void addApplication(SchemeApplicationModel application) {
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "INSERT INTO scheme_application (user_id, scheme_id, status, create_date) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, application.getUserId());
            stmt.setInt(2, application.getSchemeId());
            stmt.setString(3, application.getStatus());
            stmt.setDate(4, application.getCreateDate());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public List<SchemeApplicationModel> getAllApplications() {
        List<SchemeApplicationModel> applications = new ArrayList<>();
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "SELECT * FROM scheme_application";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                SchemeApplicationModel application = new SchemeApplicationModel(rs.getInt("application_id"), rs.getInt("user_id"), rs.getInt("scheme_id"), rs.getString("status"), rs.getDate("create_date"));
                applications.add(application);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return applications;
    }
}
