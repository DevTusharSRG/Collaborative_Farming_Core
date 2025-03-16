package com.colabfarm.dao;

import com.colabfarm.model.ServiceProviderModel;
import com.colabfarm.util.DBConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ServiceProviderDAO {

    // ✅ Add a new service provider
    public void addServiceProvider(ServiceProviderModel provider) {
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "INSERT INTO service_provider (service_id, service_provider_id, price, duration, unit_type, description, create_date) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, provider.getServiceId());
            stmt.setInt(2, provider.getServiceProviderId());
            stmt.setDouble(3, provider.getPrice());
            stmt.setInt(4, provider.getDuration());
            stmt.setString(5, provider.getUnitType()); // New field
            stmt.setString(6, provider.getDescription());
            stmt.setDate(7, new java.sql.Date(provider.getCreateDate().getTime()));

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // ✅ Retrieve all service providers
    public List<ServiceProviderModel> getAllServiceProviders() {
        List<ServiceProviderModel> providers = new ArrayList<>();
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "SELECT * FROM service_provider";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                ServiceProviderModel provider = new ServiceProviderModel(
                        rs.getInt("id"),
                        rs.getInt("service_id"),
                        rs.getInt("service_provider_id"),
                        rs.getDouble("price"),
                        rs.getInt("duration"),
                        rs.getString("unit_type"), // New field
                        rs.getString("description"),
                        rs.getDate("create_date"));
                providers.add(provider);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return providers;
    }

    // ✅ Get a single service provider by ID
    public ServiceProviderModel getServiceProviderById(int id) {
        ServiceProviderModel provider = null;
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "SELECT * FROM service_provider WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                provider = new ServiceProviderModel(
                        rs.getInt("id"),
                        rs.getInt("service_id"),
                        rs.getInt("service_provider_id"),
                        rs.getDouble("price"),
                        rs.getInt("duration"),
                        rs.getString("unit_type"), // New field
                        rs.getString("description"),
                        rs.getDate("create_date"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return provider;
    }

    // ✅ Update an existing service provider
    public void updateServiceProvider(ServiceProviderModel provider) {
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "UPDATE service_provider SET service_id=?, service_provider_id=?, price=?, duration=?, unit_type=?, description=?, create_date=? WHERE id=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, provider.getServiceId());
            stmt.setInt(2, provider.getServiceProviderId());
            stmt.setDouble(3, provider.getPrice());
            stmt.setInt(4, provider.getDuration());
            stmt.setString(5, provider.getUnitType()); // New field
            stmt.setString(6, provider.getDescription());
            stmt.setDate(7, new java.sql.Date(provider.getCreateDate().getTime()));
            stmt.setInt(8, provider.getId());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // ✅ Delete a service provider by ID
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
