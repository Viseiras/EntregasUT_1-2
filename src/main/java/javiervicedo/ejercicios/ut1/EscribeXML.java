/*
Ejercicio 3

Nos permite Escribir a XML con DOM
*/
package javiervicedo.ejercicios.ut1;

import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.ArrayList;

class EscribeXML {
    public static void main(String[] args) {
        try{
            ArrayList<Disco> Discos = new ArrayList<Disco>();
            Discos.add(new Disco("Mi carro",23,"Paquito el chocolatero"));
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            DOMImplementation domi = db.getDOMImplementation();
            Document docu = domi.createDocument(null,"xml",null);
            Element root = docu.createElement("discos");
            docu.getDocumentElement().appendChild(root);
            Element nodoDatos,nodoDiscos;
            Text texto;
            for(Disco d: Discos)
            {
                nodoDiscos=docu.createElement("disco");
                root.appendChild(nodoDiscos);

                nodoDatos=docu.createElement("nombre");
                nodoDiscos.appendChild(nodoDatos);
                texto=docu.createTextNode(d.getNombre());
                nodoDatos.appendChild(texto);

                nodoDatos=docu.createElement("precio");
                nodoDiscos.appendChild(nodoDatos);
                texto=docu.createTextNode(String.valueOf(d.getPrecio()));
                nodoDatos.appendChild(texto);

                nodoDatos=docu.createElement("artista");
                nodoDiscos.appendChild(nodoDatos);
                texto=docu.createTextNode(d.getArtista());
                nodoDatos.appendChild(texto);
            }
            Source source = new DOMSource(docu);
            Result result = new StreamResult(new File("discos.xml"));
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.setOutputProperty("indent","yes");
            transformer.transform(source,result);

        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        } catch (TransformerConfigurationException e) {
            throw new RuntimeException(e);
        } catch (TransformerException e) {
            throw new RuntimeException(e);
        }
    }
}
