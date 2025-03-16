package com.colabfarm.dao;
import com.colabfarm.model.*;
import com.colabfarm.util.DBConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ServiceProviderDAO {
    public void addServiceProvider(ServiceProviderModel provider) {
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "INSERT INTO service_provider (service_id, user_id, price, duration, description, create_date) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, provider.getServiceId());
            stmt.setInt(2, provider.getUserId());
            stmt.setDouble(3, provider.getPrice());
            stmt.setInt(4, provider.getDuration());
            stmt.setString(5, provider.getDescription());
            stmt.setDate(6, provider.getCreateDate());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public List<ServiceProviderModel> getAllServiceProviders() {
        List<ServiceProviderModel> providers = new ArrayList<>();
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "SELECT * FROM service_provider";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                ServiceProviderModel provider = new ServiceProviderModel(rs.getInt("id"), rs.getInt("service_id"), rs.getInt("user_id"), rs.getDouble("price"), rs.getInt("duration"), rs.getString("description"), rs.getDate("create_date"));
                providers.add(provider);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return providers;
    }
    
    public void updateServiceProvider(ServiceProviderModel provider) {
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "UPDATE service_provider SET service_id=?, user_id=?, price=?, duration=?, description=? WHERE id=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, provider.getServiceId());
            stmt.setInt(2, provider.getUserId());
            stmt.setDouble(3, provider.getPrice());
            stmt.setInt(4, provider.getDuration());
            stmt.setString(5, provider.getDescription());
            stmt.setInt(6, provider.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void deleteServiceProvider(int id) {
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "DELETE FROM service_provider WHERE id=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
