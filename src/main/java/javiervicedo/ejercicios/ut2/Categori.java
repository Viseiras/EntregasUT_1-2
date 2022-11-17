package javiervicedo.ejercicios.ut2;


import java.sql.*;
import java.util.Scanner;

public class Categori {
    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in);
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/pedidos","root","root");
            PreparedStatement ps=con.prepareStatement("SELECT * FROM CATEGORIAS WHERE CATEGORIAID < ?");)
        {
            System.out.println("Introduce el valor máximo del ID:");
            int col= sc.nextInt();

            ps.setInt(1,col);
            ResultSet rs = ps.executeQuery();

            while(rs.next())
                System.out.println("ID: "+rs.getInt("categoriaid")+" Nombre de la Categoria: "+rs.getString("nombrecat"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
