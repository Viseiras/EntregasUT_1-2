package javiervicedo.ejercicios.ut2;

import java.sql.*;
import java.util.Scanner;

public class Inyeccion {
    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in);
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/javier_vicedo","root","root");
            Statement stmt = con.createStatement();) {
            String sql = "SELECT * FROM discos WHERE id = 2 or 1=1";
            ResultSet rs =stmt.executeQuery(sql);
            while(rs.next())
                System.out.println(rs);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
