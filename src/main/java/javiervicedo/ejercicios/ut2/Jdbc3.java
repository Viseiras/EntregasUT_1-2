package javiervicedo.ejercicios.ut2;

import java.sql.*;

public class Jdbc3 {
    public static void main(String[] args) {
        String sql= "CREATE TABLE DISCOS(" +
                "ID integer primary key," +
                "nombre varchar(20)," +
                "precio float);";
        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/javier_vicedo", "root", "root");
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql);)
        {
            System.out.println("Operación completada");
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
