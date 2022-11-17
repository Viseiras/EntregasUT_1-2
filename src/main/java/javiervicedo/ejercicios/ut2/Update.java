package javiervicedo.ejercicios.ut2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Update {
    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in);
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/javier_vicedo","root","root");
            PreparedStatement ps = con.prepareStatement("UPDATE discos " +
                    "SET id=?,nombre=?,precio=? ");)
        {
            boolean var=true;
            while(var)
            {

                System.out.println("Introduce el ID:");
                ps.setInt(1,sc.nextInt());
                sc.nextLine();
                System.out.println("Introduce el Nombre:");
                ps.setString(2,sc.nextLine());
                System.out.println("Introduce el Precio:");
                ps.setFloat(3,sc.nextFloat());

                ps.executeQuery();
                

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
