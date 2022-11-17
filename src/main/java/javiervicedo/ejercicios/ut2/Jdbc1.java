package javiervicedo.ejercicios.ut2;

import java.sql.*;
import java.util.Scanner;

public class Jdbc1 {
    public static void main(String[] args) {
        // TODO code application logic here
        Connection conn = null;
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("Conectando con la Base de datos...");

            String jdbcUrl = "jdbc:postgresql://localhost:5432/pedidos";
            Connection conexion = DriverManager.getConnection(jdbcUrl,"root","root");
            PreparedStatement ps = conexion.prepareStatement("SELECT * FROM categorias WHERE categoriaid<?");
            //Statement stmt = conexion.createStatement();
            System.out.println("Introduce hasta que ID quieres ver de la tabla:");
            int col=sc.nextInt();
            ps.setInt(1,col);
            //String sql = "SELECT * FROM categorias WHERE categoriaid<"+col;
            //ResultSet rs = stmt.executeQuery(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next())
                System.out.println("Id: "+rs.getInt("categoriaid")+"\nNombre: "+rs.getString("nombrecat"));




        } catch(SQLException se) {
            //Errores de JDBC
            se.printStackTrace();
        } catch(Exception e) {
            //Errores debidos al Class.forName
            e.printStackTrace();
        } finally {
            try {
                if(conn!=null)
                    conn.close();
            } catch(SQLException se) {
                se.printStackTrace();
            }//end finally try
        }//end try
    }

}