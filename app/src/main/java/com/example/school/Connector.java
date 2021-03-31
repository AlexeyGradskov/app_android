package com.example.school;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Connector {
    private static final String IP = "192.168.0.106";
    private static final String PORT = "49172";
    private static final String DB = "TutorServiceDB";
    private static final String USER = "sa";
    private static final String PASSWORD = "flotridaz58rus";
    private static final String URL = "jdbc:jtds:sqlserver://" + IP + ":" + PORT + "/" + DB;

    private Connector() {

    }

    public static List<Service> getServices() throws SQLException {
        ArrayList<Service> services = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            Statement statement = connection.createStatement();
            fillServices(services, statement);

        }
        return services;
    }

    private static void fillServices(ArrayList<Service> services, Statement statement) throws SQLException {
        try (ResultSet set = statement.executeQuery("EXEC select_from_service;")) {
            while (set.next()) {
                int id = set.getInt("ID");
                String title = set.getString("Title");
                int cost = set.getInt("Cost");
                int duration = set.getInt("DurationInSeconds");
                float discount = set.getFloat("Discount");
                byte[] photo = set.getBytes("Photo");
                Service service = new Service(id, title, cost, duration, discount, photo);
                services.add(service);
            }
        }
    }
}
