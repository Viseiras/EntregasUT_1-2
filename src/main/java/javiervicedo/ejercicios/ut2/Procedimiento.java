package javiervicedo.ejercicios.ut2;


import java.sql.*;

public class Procedimiento
{
    public static void main(String[] args)
    {
        String sqlProcedure = "call borraDisco(?)";
        String sqlFunction = "SELECT cuentaDiscos()";
        try(Connection conn = ConnectionPool.getInstance().getConnection();
            CallableStatement cstmt = conn.prepareCall(sqlProcedure);
            PreparedStatement pstmt = conn.prepareStatement(sqlFunction,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
            ResultSet resultSet = pstmt.executeQuery())
        {
            //Ejecutamos el procedure.
            cstmt.setString(1,"Vino Tinto");
            cstmt.execute();
            System.out.println("El disco se ha borrado correctamente.");
            //Ejecutamos la function.
            resultSet.first();
            if(resultSet.getInt(1)>0)
                System.out.println("Hay "+resultSet.getString(1)+" discos.");
            else
                System.out.println("No hay discos dados de alta");
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
    }
}
