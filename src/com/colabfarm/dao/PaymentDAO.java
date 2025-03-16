package com.colabfarm.dao;
import com.colabfarm.model.*;
import com.colabfarm.util.DBConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PaymentDAO {
    public void addPayment(PaymentModel payment) {
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "INSERT INTO payment (user_id, amount, status, create_date) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, payment.getUserId());
            stmt.setDouble(2, payment.getAmount());
            stmt.setString(3, payment.getStatus());
            stmt.setDate(4, payment.getCreateDate());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public List<PaymentModel> getAllPayments() {
        List<PaymentModel> payments = new ArrayList<>();
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "SELECT * FROM payment";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                PaymentModel payment = new PaymentModel(rs.getInt("payment_id"), rs.getInt("user_id"), rs.getDouble("amount"), rs.getString("status"), rs.getDate("create_date"));
                payments.add(payment);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return payments;
    }
    
    public void updatePayment(PaymentModel payment) {
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "UPDATE payment SET status=? WHERE payment_id=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, payment.getStatus());
            stmt.setInt(2, payment.getPaymentId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void deletePayment(int paymentId) {
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "DELETE FROM payment WHERE payment_id=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, paymentId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}