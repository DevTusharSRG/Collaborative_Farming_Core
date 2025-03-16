package com.colabfarm.dao;

import com.colabfarm.model.ServiceModel;
import com.colabfarm.util.DBConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ServiceDAO {

    // ✅ Add a new service
    public void addService(ServiceModel service) {
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "INSERT INTO services (service_name) VALUES (?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, service.getServiceName());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // ✅ Retrieve all services
    public List<ServiceModel> getAllServices() {
        List<ServiceModel> services = new ArrayList<>();
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "SELECT * FROM services";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                ServiceModel service = new ServiceModel(
                    rs.getInt("service_id"),
                    rs.getString("service_name")
                );
                services.add(service);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return services;
    }

    // ✅ Get a single service by ID
    public ServiceModel getServiceById(int serviceId) {
        ServiceModel service = null;
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "SELECT * FROM services WHERE service_id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, serviceId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                service = new ServiceModel(
                    rs.getInt("service_id"),
                    rs.getString("service_name")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return service;
    }

    // ✅ Update an existing service
    public void updateService(ServiceModel service) {
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "UPDATE services SET service_name=? WHERE service_id=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, service.getServiceName());
            stmt.setInt(2, service.getServiceId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // ✅ Delete a service by ID
    public void deleteService(int serviceId) {
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "DELETE FROM services WHERE service_id=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, serviceId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
