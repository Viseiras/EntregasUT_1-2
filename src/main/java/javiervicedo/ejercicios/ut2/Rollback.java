package javiervicedo.ejercicios.ut2;

import java.sql.*;

public class Rollback {
    static Connection con = null;
    static ResultSet idGenerados=null;
    static PreparedStatement ps = null;
    public static void main(String[] args) throws SQLException {
        try
        {
            con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/javier_vicedo","root","root");
            con.setAutoCommit(false);
            String sql = "INSERT INTO DISCOS(id,nombre,precio) values(?,?,?);";

            ps = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

            ps.setInt(1,18);
            ps.setString(2,"Achis");
            ps.setFloat(3, (float) 23.2);

            ps.executeUpdate();


            idGenerados = ps.getGeneratedKeys();
            idGenerados.next();
            int idProducto = idGenerados.getInt(1);
            ps.close();


            idGenerados.first();

            ps = con.prepareStatement(sql);
            ps.setInt(1,25);
            ps.setString(2,"Si tu me hubieras dicho siempre la verdad"); // es más largo de lo que debe para que se vea que hace el rollback del anterior bien
            ps.setFloat(3,(float)43.234);
            ps.executeUpdate();

            idGenerados.previous();
            idGenerados.moveToCurrentRow();
            idGenerados.moveToCurrentRow();

            con.commit();
        }
        catch (SQLException e) {
            con.rollback();
            e.printStackTrace();
        }
        finally {
            try{
                con.setAutoCommit(true);
                idGenerados.close();
                ps.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
