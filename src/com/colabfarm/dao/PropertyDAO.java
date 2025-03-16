package com.colabfarm.dao;

import com.colabfarm.model.PropertyModel;
import com.colabfarm.util.DBConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PropertyDAO {
    public void addProperty(PropertyModel property) {
        String sql = "INSERT INTO property (farmer_id, location, type_of_land, land_image, document_image, area_acre, area_guntha, create_date) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, property.getFarmerId());
            stmt.setString(2, property.getLocation());
            stmt.setString(3, property.getTypeOfLand());
            stmt.setString(4, property.getLandImage());
            stmt.setString(5, property.getDocumentImage());
            stmt.setDouble(6, property.getAreaAcre());
            stmt.setDouble(7, property.getAreaGuntha());
            stmt.setDate(8, new Date(property.getCreateDate().getTime()));
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public PropertyModel getPropertyById(int id) {
        String sql = "SELECT * FROM property WHERE property_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new PropertyModel(
                        rs.getInt("property_id"),
                        rs.getInt("farmer_id"),
                        rs.getString("location"),
                        rs.getString("type_of_land"),
                        rs.getString("land_image"),
                        rs.getString("document_image"),
                        rs.getDouble("area_acre"),
                        rs.getDouble("area_guntha"),
                        rs.getDate("create_date")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<PropertyModel> getAllProperties() {
        List<PropertyModel> properties = new ArrayList<>();
        String sql = "SELECT * FROM property";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                properties.add(new PropertyModel(
                        rs.getInt("property_id"),
                        rs.getInt("farmer_id"),
                        rs.getString("location"),
                        rs.getString("type_of_land"),
                        rs.getString("land_image"),
                        rs.getString("document_image"),
                        rs.getDouble("area_acre"),
                        rs.getDouble("area_guntha"),
                        rs.getDate("create_date")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return properties;
    }
}
