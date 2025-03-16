package com.colabfarm.dao;
import com.colabfarm.model.*;
import com.colabfarm.util.DBConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AgreementDAO {
    public void addAgreement(AgreementModel agreement) {
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "INSERT INTO agreement (user_id, service_id, property_id, status, start_date, end_date, time_duration, create_date) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, agreement.getUserId());
            stmt.setInt(2, agreement.getServiceId());
            stmt.setInt(3, agreement.getPropertyId());
            stmt.setString(4, agreement.getStatus());
            stmt.setDate(5, agreement.getStartDate());
            stmt.setDate(6, agreement.getEndDate());
            stmt.setInt(7, agreement.getTimeDuration());
            stmt.setDate(8, agreement.getCreateDate());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public List<AgreementModel> getAllAgreements() {
        List<AgreementModel> agreements = new ArrayList<>();
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "SELECT * FROM agreement";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                AgreementModel agreement = new AgreementModel(rs.getInt("agreement_id"), rs.getInt("user_id"), rs.getInt("service_id"), rs.getInt("property_id"), rs.getString("status"), rs.getDate("start_date"), rs.getDate("end_date"), rs.getInt("time_duration"), rs.getDate("create_date"));
                agreements.add(agreement);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return agreements;
    }
    
    public void updateAgreement(AgreementModel agreement) {
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "UPDATE agreement SET status=?, start_date=?, end_date=?, time_duration=? WHERE agreement_id=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, agreement.getStatus());
            stmt.setDate(2, agreement.getStartDate());
            stmt.setDate(3, agreement.getEndDate());
            stmt.setInt(4, agreement.getTimeDuration());
            stmt.setInt(5, agreement.getAgreementId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void deleteAgreement(int agreementId) {
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "DELETE FROM agreement WHERE agreement_id=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, agreementId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}