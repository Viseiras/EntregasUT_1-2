package javiervicedo.ejercicios.ut1;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.ArrayList;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Discos {
    private ArrayList<Disco> Discos;
    public Discos()
    {
        Discos =new ArrayList<>();
    }

    public void addDisco(Disco disco)
    {
        Discos.add(disco);
    }

    public void muestradisco()
    {
        for(Disco disco: Discos)
            System.out.println(disco);
    }
}


