package com.colabfarm.dao;

import com.colabfarm.model.SchemeApplicationModel;
import com.colabfarm.util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SchemeApplicationDAO {

    // ✅ Add a new scheme application
    public void addSchemeApplication(SchemeApplicationModel application) {
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "INSERT INTO scheme_application (scheme_id, farmer_id, register_date, status) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, application.getSchemeId());
            stmt.setInt(2, application.getFarmerId());
            stmt.setDate(3, new java.sql.Date(application.getRegisterDate().getTime())); // Convert java.util.Date to java.sql.Date
            stmt.setString(4, application.getStatus());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // ✅ Retrieve all scheme applications
    public List<SchemeApplicationModel> getAllSchemeApplications() {
        List<SchemeApplicationModel> applications = new ArrayList<>();
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "SELECT * FROM scheme_application";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                SchemeApplicationModel application = new SchemeApplicationModel(
                    rs.getInt("application_id"),
                    rs.getInt("scheme_id"),
                    rs.getInt("farmer_id"),
                    rs.getDate("register_date"),
                    rs.getString("status")
                );
                applications.add(application);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return applications;
    }

    // ✅ Get a single scheme application by ID
    public SchemeApplicationModel getSchemeApplicationById(int applicationId) {
        SchemeApplicationModel application = null;
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "SELECT * FROM scheme_application WHERE application_id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, applicationId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                application = new SchemeApplicationModel(
                    rs.getInt("application_id"),
                    rs.getInt("scheme_id"),
                    rs.getInt("farmer_id"),
                    rs.getDate("register_date"),
                    rs.getString("status")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return application;
    }

    // ✅ Update an existing scheme application
    public void updateSchemeApplication(SchemeApplicationModel application) {
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "UPDATE scheme_application SET scheme_id=?, farmer_id=?, register_date=?, status=? WHERE application_id=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, application.getSchemeId());
            stmt.setInt(2, application.getFarmerId());
            stmt.setDate(3, new java.sql.Date(application.getRegisterDate().getTime()));
            stmt.setString(4, application.getStatus());
            stmt.setInt(5, application.getApplicationId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // ✅ Delete a scheme application by ID
    public void deleteSchemeApplication(int applicationId) {
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "DELETE FROM scheme_application WHERE application_id=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, applicationId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
