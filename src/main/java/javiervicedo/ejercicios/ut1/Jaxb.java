/*
Ejercicio 4

Ejercicio de JAXB que permite leer, escribir y realizar anotaciones XML
*/
package javiervicedo.ejercicios.ut1;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;

import java.io.File;
//Inicio de la clase
public class Jaxb {
    public static void main(String[] args) {
        //Declaración del arraylist en el que se almacenan los objetos
        Discos discos = new Discos();
        //Creación de los objetos
        Disco d1 = new Disco("SIuuuuuuuuu",34.23,"El bicho");
        Disco d2 = new Disco("Papa",72,"King");
        //Añadimos los objetos al ArrayList
        discos.addDisco(d1);
        discos.addDisco(d2);

        try{
            //Escribimos a XML
            JAXBContext context = JAXBContext.newInstance(discos.getClass());
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);
            marshaller.marshal(discos,new File("Copia.xml"));
            //Leemos por terminal el XML
            JAXBContext context2= JAXBContext.newInstance(Discos.class);
            Unmarshaller unmarshaller= context2.createUnmarshaller();
            Discos discos2 = (Discos) unmarshaller.unmarshal(new File("Copia.xml"));
            discos2.muestradisco();
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }
}
