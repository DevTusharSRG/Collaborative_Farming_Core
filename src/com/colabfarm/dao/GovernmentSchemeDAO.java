package com.colabfarm.dao;
import com.colabfarm.model.*;
import com.colabfarm.util.DBConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GovernmentSchemeDAO {
    public void addScheme(GovernmentSchemeModel scheme) {
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "INSERT INTO government_scheme (name, description, eligibility, create_date) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, scheme.getName());
            stmt.setString(2, scheme.getDescription());
            stmt.setString(3, scheme.getEligibility());
            stmt.setDate(4, scheme.getCreateDate());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public List<GovernmentSchemeModel> getAllSchemes() {
        List<GovernmentSchemeModel> schemes = new ArrayList<>();
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "SELECT * FROM government_scheme";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                GovernmentSchemeModel scheme = new GovernmentSchemeModel(rs.getInt("scheme_id"), rs.getString("name"), rs.getString("description"), rs.getString("eligibility"), rs.getDate("create_date"));
                schemes.add(scheme);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return schemes;
    }
}