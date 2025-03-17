package com.colabfarm.dao;

import com.colabfarm.model.UserModel;
import com.colabfarm.util.DBConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    public void addUser(UserModel user) {
        String sql = "INSERT INTO users (name, contact, email, address, password, type_of_user, create_date) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, user.getName());
            stmt.setString(2, user.getContact());
            stmt.setString(3, user.getEmail());
            stmt.setString(4, user.getAddress());
            stmt.setString(5, user.getPassword());
            stmt.setString(6, user.getTypeOfUser());
            stmt.setDate(7, new Date(user.getCreateDate().getTime()));
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public UserModel getUserById(int id) {
        String sql = "SELECT * FROM users WHERE id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new UserModel(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("contact"),
                        rs.getString("email"),
                        rs.getString("address"),
                        rs.getString("password"),
                        rs.getString("type_of_user"),
                        rs.getDate("create_date")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    public List<UserModel> getAllUsers() {
        List<UserModel> users = new ArrayList<>();
        String sql = "SELECT * FROM users";
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                users.add(new UserModel(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("contact"),
                        rs.getString("email"),
                        rs.getString("address"),
                        rs.getString("password"),
                        rs.getString("type_of_user"),
                        rs.getDate("create_date")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    public void updateUser(UserModel user) {
        String sql = "UPDATE users SET name = ?, contact = ?, email = ?, address = ?, password = ?, type_of_user = ? WHERE id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, user.getName());
            stmt.setString(2, user.getContact());
            stmt.setString(3, user.getEmail());
            stmt.setString(4, user.getAddress());
            stmt.setString(5, user.getPassword());
            stmt.setString(6, user.getTypeOfUser());
            stmt.setInt(7, user.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteUser(int id) {
        String sql = "DELETE FROM users WHERE id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
