package com.colabfarm.dao;

import com.colabfarm.model.PaymentModel;
import com.colabfarm.util.DBConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PaymentDAO {

    // ✅ Add a new payment record
    public void addPayment(PaymentModel payment) {
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "INSERT INTO payment (agreement_id, total_amount, payment_method, payment_mode, payment_status, transaction_id, received_date) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, payment.getAgreementId());
            stmt.setDouble(2, payment.getTotalAmount());
            stmt.setString(3, payment.getPaymentMethod());
            stmt.setString(4, payment.getPaymentMode());
            stmt.setString(5, payment.getPaymentStatus());
            stmt.setString(6, payment.getTransactionId());
            stmt.setDate(7, new java.sql.Date(payment.getReceivedDate().getTime())); // Convert java.util.Date to java.sql.Date
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // ✅ Retrieve all payments
    public List<PaymentModel> getAllPayments() {
        List<PaymentModel> payments = new ArrayList<>();
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "SELECT * FROM payment";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                PaymentModel payment = new PaymentModel(
                    rs.getInt("payment_id"),
                    rs.getInt("agreement_id"),
                    rs.getDouble("total_amount"),
                    rs.getString("payment_method"),
                    rs.getString("payment_mode"),
                    rs.getString("payment_status"),
                    rs.getString("transaction_id"),
                    rs.getDate("received_date")
                );
                payments.add(payment);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return payments;
    }

    // ✅ Get a single payment by ID
    public PaymentModel getPaymentById(int paymentId) {
        PaymentModel payment = null;
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "SELECT * FROM payment WHERE payment_id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, paymentId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                payment = new PaymentModel(
                    rs.getInt("payment_id"),
                    rs.getInt("agreement_id"),
                    rs.getDouble("total_amount"),
                    rs.getString("payment_method"),
                    rs.getString("payment_mode"),
                    rs.getString("payment_status"),
                    rs.getString("transaction_id"),
                    rs.getDate("received_date")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return payment;
    }

    // ✅ Update an existing payment record
    public void updatePayment(PaymentModel payment) {
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "UPDATE payment SET agreement_id=?, total_amount=?, payment_method=?, payment_mode=?, payment_status=?, transaction_id=?, received_date=? WHERE payment_id=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, payment.getAgreementId());
            stmt.setDouble(2, payment.getTotalAmount());
            stmt.setString(3, payment.getPaymentMethod());
            stmt.setString(4, payment.getPaymentMode());
            stmt.setString(5, payment.getPaymentStatus());
            stmt.setString(6, payment.getTransactionId());
            stmt.setDate(7, new java.sql.Date(payment.getReceivedDate().getTime()));
            stmt.setInt(8, payment.getPaymentId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // ✅ Delete a payment by ID
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
