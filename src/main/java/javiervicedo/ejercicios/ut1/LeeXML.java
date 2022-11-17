/*
Ejercicio 3

Nos permite leer XML con DOM
*/

package javiervicedo.ejercicios.ut1;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class LeeXML {
    public static void main(String[] args) {
        try{
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document document = db.parse("discos.xml");
            NodeList nodos= document.getElementsByTagName("disco");
            Node node;
            Element element;
            for(int i=0;i< nodos.getLength();i++)
            {
                node=nodos.item(i);
                element=(Element) node;
                /*System.out.println(element.getElementsByTagName("nombre").item(0).getTextContent());
                System.out.println(element.getElementsByTagName("precio").item(0).getTextContent());
                System.out.println(element.getElementsByTagName("artista").item(0).getTextContent());*/
                System.out.println(element.getTextContent());
            }

        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (SAXException e) {
            throw new RuntimeException(e);
        }
    }
}
