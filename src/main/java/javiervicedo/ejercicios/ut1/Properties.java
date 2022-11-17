package javiervicedo.ejercicios.ut1;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Properties {
    public static void main(String[] args) {
        java.util.Properties config = new java.util.Properties();
        config.setProperty("nombre","Javier");
        config.setProperty("apellidos","Vicedo Cerdán");
        config.setProperty("asignatura","Acceso a Datos");


        try{
            config.store(new FileOutputStream("configuracion.props"),"Fichero de configuración examen");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
