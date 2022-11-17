package javiervicedo.ejercicios.ut2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Borrado {
    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in);
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost/javier_vicedo","root","root");
            PreparedStatement ps = con.prepareStatement("DELETE * FROM DISCOS WHERE ID = ?");){

            System.out.println("Introduce el ID que quieres borrar: ");
            int id = sc.nextInt();

            ps.setInt(1,id);

            //ps.setString(1,"ID");
            //ps.setInt(2,3);

            ps.executeQuery();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
