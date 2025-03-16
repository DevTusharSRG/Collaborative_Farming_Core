package com.colabfarm.dao;

import com.colabfarm.model.GovernmentSchemeModel;
import com.colabfarm.util.DBConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GovernmentSchemeDAO {

    // ✅ Add a new government scheme
    public void addScheme(GovernmentSchemeModel scheme) {
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "INSERT INTO government_scheme (title, price, start_date, last_date, description, created_date) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, scheme.getTitle());
            stmt.setDouble(2, scheme.getPrice());
            stmt.setDate(3, new java.sql.Date(scheme.getStartDate().getTime())); // Convert java.util.Date to java.sql.Date
            stmt.setDate(4, new java.sql.Date(scheme.getLastDate().getTime()));
            stmt.setString(5, scheme.getDescription());
            stmt.setDate(6, new java.sql.Date(scheme.getCreatedDate().getTime()));
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // ✅ Retrieve all government schemes
    public List<GovernmentSchemeModel> getAllSchemes() {
        List<GovernmentSchemeModel> schemes = new ArrayList<>();
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "SELECT * FROM government_scheme";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                GovernmentSchemeModel scheme = new GovernmentSchemeModel(
                    rs.getInt("scheme_id"),
                    rs.getString("title"),
                    rs.getDouble("price"),
                    rs.getDate("start_date"),
                    rs.getDate("last_date"),
                    rs.getString("description"),
                    rs.getDate("created_date")
                );
                schemes.add(scheme);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return schemes;
    }

    // ✅ Get a single scheme by ID
    public GovernmentSchemeModel getSchemeById(int schemeId) {
        GovernmentSchemeModel scheme = null;
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "SELECT * FROM government_scheme WHERE scheme_id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, schemeId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                scheme = new GovernmentSchemeModel(
                    rs.getInt("scheme_id"),
                    rs.getString("title"),
                    rs.getDouble("price"),
                    rs.getDate("start_date"),
                    rs.getDate("last_date"),
                    rs.getString("description"),
                    rs.getDate("created_date")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return scheme;
    }

    // ✅ Update an existing scheme
    public void updateScheme(GovernmentSchemeModel scheme) {
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "UPDATE government_scheme SET title=?, price=?, start_date=?, last_date=?, description=?, created_date=? WHERE scheme_id=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, scheme.getTitle());
            stmt.setDouble(2, scheme.getPrice());
            stmt.setDate(3, new java.sql.Date(scheme.getStartDate().getTime()));
            stmt.setDate(4, new java.sql.Date(scheme.getLastDate().getTime()));
            stmt.setString(5, scheme.getDescription());
            stmt.setDate(6, new java.sql.Date(scheme.getCreatedDate().getTime()));
            stmt.setInt(7, scheme.getSchemeId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // ✅ Delete a scheme by ID
    public void deleteScheme(int schemeId) {
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "DELETE FROM government_scheme WHERE scheme_id=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, schemeId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
