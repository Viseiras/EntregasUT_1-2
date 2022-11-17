package javiervicedo.ejercicios.ut2;

import java.sql.*;

public class DeleteDatabase {
    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/javier_vicedo", "root", "root");
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery("DROP TABLE discos;");) {

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
