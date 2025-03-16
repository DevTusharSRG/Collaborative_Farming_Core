package com.colabfarm.dao;

import com.colabfarm.model.*;
import com.colabfarm.util.DBConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ServiceDAO {
    public void addService(ServiceModel service) {
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "INSERT INTO service (name, description, create_date) VALUES (?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, service.getName());
            stmt.setString(2, service.getDescription());
            stmt.setDate(3, service.getCreateDate());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public List<ServiceModel> getAllServices() {
        List<ServiceModel> services = new ArrayList<>();
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "SELECT * FROM service";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                ServiceModel service = new ServiceModel(rs.getInt("service_id"), rs.getString("name"), rs.getString("description"), rs.getDate("create_date"));
                services.add(service);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return services;
    }
}
