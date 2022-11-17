package javiervicedo.ejercicios.ut2;

import java.sql.*;

public class Create {
    public static void main(String[] args) {
        Connection con = null;
        try{
            String SqlURL = "jdbc:postgresql://localhost:5432/postgres";
            Connection connection = DriverManager.getConnection(SqlURL,"root","root");
            PreparedStatement ps = connection.prepareStatement("DROP DATABASE IF EXISTS JAVIER_VICEDO;" +
                    "CREATE DATABASE JAVIER_VICEDO; ");
            ps.execute();




            /*Statement stmt = connection.createStatement();
            String sql= "DROP DATABASE IF EXISTS JAVIER_VICEDO;" +
                    "CREATE DATABASE JAVIER_VICEDO;" +
                    "CREATE TABLE DISCOS(" +
                    "ID integer(3) primary key" +
                    "nombre varchar(20)" +
                    "precio money(4) );";

            stmt.executeQuery(sql);*/
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

    }
}
