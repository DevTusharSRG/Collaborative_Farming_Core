package com.colabfarm.main;

import com.colabfarm.dao.*;
import com.colabfarm.model.*;
import com.colabfarm.util.DBConnection;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Connection conn = DBConnection.getConnection()) {
            if (conn != null) {
                System.out.println("Database connected successfully!");
            } else {
                System.out.println("Failed to connect to database.");
                return;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return;
        }

        Scanner scanner = new Scanner(System.in);
        UserDAO userDAO = new UserDAO();
        PropertyDAO propertyDAO = new PropertyDAO();
        ServiceProviderDAO serviceProviderDAO = new ServiceProviderDAO();
        AgreementDAO agreementDAO = new AgreementDAO();
        PaymentDAO paymentDAO = new PaymentDAO();
        GovernmentSchemeDAO schemeDAO = new GovernmentSchemeDAO();
        SchemeApplicationDAO schemeApplicationDAO = new SchemeApplicationDAO();
        ServiceDAO serviceDAO = new ServiceDAO();

        while (true) {
            System.out.println("\n--- Collaborative Farming System ---");
            System.out.println("1. Add User");
            System.out.println("2. View All Users");
            System.out.println("3. Add Property");
            System.out.println("4. View All Properties");
            System.out.println("5. Add Service Provider");
            System.out.println("6. View All Service Providers");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Contact: ");
                    String contact = scanner.nextLine();
                    System.out.print("Enter Email: ");
                    String email = scanner.nextLine();
                    System.out.print("Enter Address: ");
                    String address = scanner.nextLine();
                    System.out.print("Enter Password: ");
                    String password = scanner.nextLine();
                    System.out.print("Enter User Type (admin, farmer, company, service_provider): ");
                    String userType = scanner.nextLine();

                    UserModel user = new UserModel(0, name, contact, email, address, password, userType, new java.sql.Date(System.currentTimeMillis()));
                    userDAO.addUser(user);
                    System.out.println("User added successfully!");
                    break;

                case 2:
                    List<UserModel> users = userDAO.getAllUsers();
                    for (UserModel u : users) {
                        System.out.println(u);
                    }
                    break;

                case 3:
                    System.out.print("Enter Farmer ID: ");
                    int farmerId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Location: ");
                    String location = scanner.nextLine();
                    System.out.print("Enter Land Type (Irrigated Land, Rainfed Land): ");
                    String landType = scanner.nextLine();
                    System.out.print("Enter Land Image Path: ");
                    String landImage = scanner.nextLine();
                    System.out.print("Enter Document Image Path: ");
                    String docImage = scanner.nextLine();
                    System.out.print("Enter Area (Acre): ");
                    double areaAcre = scanner.nextDouble();
                    System.out.print("Enter Area (Guntha): ");
                    double areaGuntha = scanner.nextDouble();

                    PropertyModel property = new PropertyModel(0, farmerId, location, landType, landImage, docImage, areaAcre, areaGuntha, new java.sql.Date(System.currentTimeMillis()));
                    propertyDAO.addProperty(property);
                    System.out.println("Property added successfully!");
                    break;

                case 4:
                    List<PropertyModel> properties = propertyDAO.getAllProperties();
                    for (PropertyModel p : properties) {
                        System.out.println(p);
                    }
                    break;

                    case 5:
                    System.out.print("Enter User ID: ");
                    int userId = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter Service ID: ");
                    int serviceId = scanner.nextInt();
                    scanner.nextLine();
                    
                    if (serviceDAO.getServiceById(serviceId) == null) {
                        System.out.println("Error: Service ID does not exist!");
                        break;
                    }

                    System.out.print("Enter Price: ");
                    double price = scanner.nextDouble();
                    System.out.print("Enter Duration (days): ");
                    int duration = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Description: ");
                    String description = scanner.nextLine();

                    ServiceProviderModel serviceProvider = new ServiceProviderModel(0, userId, serviceId, price, duration, "per acre", description, new java.sql.Date(System.currentTimeMillis()));

                    serviceProviderDAO.addServiceProvider(serviceProvider);
                    System.out.println("Service provider added successfully!");
                    break;

                case 6:
                    List<ServiceProviderModel> serviceProviders = serviceProviderDAO.getAllServiceProviders();
                    for (ServiceProviderModel sp : serviceProviders) {
                        System.out.println(sp);
                    }
                    break;

                case 7:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}
