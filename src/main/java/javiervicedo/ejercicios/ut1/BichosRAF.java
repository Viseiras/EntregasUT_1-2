/*
Ejercicio 1

En este ejercicio haciendo uso de un RAF creamos un archivo que guarda la información de nuestra colección, en este caso de Bichos
*/

package javiervicedo.ejercicios.ut1;
//Imports
import java.io.*;
import java.util.Scanner;

//Inicio de la clase
class Bichos {
    //Declaración de variables
    private static final int maxString = 50;
    private static final int tamLista = 2 * (maxString + 1) + 2 * Integer.SIZE / 8;
    private int cod;
    private String nombre;
    private int patas;
    private String descubridor;

    //Constructor con parametros
    public Bichos(int c, String n, int p, String d)
    {
        cod = c;
        patas = p;
        if (n.length() > maxString)
            nombre = n.substring(0, maxString);
        else
            nombre = n;

        if (d.length() > maxString)
            descubridor = d.substring(0, maxString);
        else
            descubridor = d;
    }

    //Comprueba si el bicho introducido está ya en la base de datos
    public boolean isDuplicated(RandomAccessFile raf)
    {
        try
        {
            raf.seek((long) (cod - 1) * tamLista);
            int codDup = raf.readInt();
            return cod==codDup;
        }
        catch (EOFException f)
        {

        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return false;
    }

    //Nos muestrra por pantalla el bicho
    public void Muestra()
    {
        if (cod != 0)
            System.out.printf("\n%d.%s\nPatas:%d \nDescubierto por: %s\n\n---\n", cod, nombre, patas, descubridor);
        else
            System.out.println("Este bicho no esta en la lista");
    }


    //Escribe en el archivio bichos.dat
    public void writeFile(RandomAccessFile raf)
    {
        try
        {
            raf.seek((cod - 1) * tamLista);
            raf.writeInt(cod);
            raf.writeUTF(nombre);
            raf.writeInt(patas);
            raf.writeUTF(descubridor);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
    //Escribe en el archivo duplicados.dat
    public void writeDupplicated()
    {
        try(DataOutputStream dos=new DataOutputStream(new FileOutputStream("duplicados.dat",true)))
        {
            dos.writeInt(cod);
            dos.writeUTF(nombre);
            dos.writeInt(patas);
            dos.writeUTF(descubridor);
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }
    //Lee el archivo bichos.dat y lo muestra por pantalla
    public void readFile (RandomAccessFile raf)
    {
        try
        {
            raf.seek((cod - 1) * tamLista);
            int cod = raf.readInt();
            if (cod != 0)
            {
                nombre = raf.readUTF();
                patas = raf.readInt();
                descubridor = raf.readUTF();
            }
        }
        catch (EOFException f)
        {
            System.out.println("Este bicho no existe");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
    //Lee el archivo duplicados.dat y lo muestra por pantalla
    public void readDuplicated(Bichos b)
    {
        try(DataInputStream dis= new DataInputStream(new FileInputStream("duplicados.dat")))
        {
            System.out.println("\t--Estos son los duplicados--\t");
            while(true)
            {
                dis.readInt();
                dis.readUTF();
                dis.readInt();
                dis.readUTF();
                b.Muestra();
            }
        }
        catch(EOFException e)
        {
            System.out.println("\n\t--Final de los duplicados--\n");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
    public int getPatas()
    {
        return patas;
    }
}

//Inicio de la clase de prueba
public class BichosRAF
{
    public static void main(String[] args) throws FileNotFoundException,IOException
    {
        Scanner sc=new Scanner(System.in);
        RandomAccessFile raf=new RandomAccessFile("bichos.dat","rw");

        //Bucle que nos permite tener repeticiones infinitas del Menú y por tanto de las ordenes que ejecutamos
        while(true)
        {
            System.out.printf("Gestión de Enciclopedia\n\t1. Añadir un insecto\n\t2. Consultar un insecto\n\t3. Borra una entrada\n\t4. Mira los duplicados\n\t5. Copia los datos del fichero binario \n\t0. Salir\n Elige una opción:\n\n");
            int menu=sc.nextInt();
            int c; Bichos b;
            //Inicio del switch
            switch (menu)
            {
                //ALTA / Introduce un nuevo bicho
                case 1:
                    System.out.println("Introduce el código del bicho");
                    c=sc.nextInt();
                    sc.nextLine();
                    System.out.printf("Introduce el nombre:\n");
                    String n =sc.nextLine();
                    System.out.printf("Introduce las patas que tiene tu insecto:\n");
                    int p=sc.nextInt();
                    sc.nextLine();
                    System.out.printf("Introduce el cientifico que descubrió este insecto:\n");
                    String d=sc.nextLine();
                    b = new Bichos(c,n,p,d);
                    if(b.isDuplicated(raf))
                        b.writeDupplicated();
                    else
                        b.writeFile(raf);
                    break;
                //MUESTRA / Muestra por pantalla el código del bicho introducido
                case 2:
                    System.out.printf("Introduce el codigo:\n");
                    c=sc.nextInt();
                    b=new Bichos(c,"",0,"");
                    b.readFile(raf);
                    if(b.getPatas()!=0)
                        b.Muestra();
                    break;
                //BORRADO / Borra un bicho pasandole el código
                case 3:
                    System.out.println("Introduce el codigo que quieres borrar:\n");
                    c=sc.nextInt();
                    String vacio=new String();
                    b=new Bichos(c,vacio,0,vacio);
                    b.writeFile(raf);
                    System.out.println("Se ha borrado la posisicón satisfactoriamente");
                    break;
                //DUPLICADOS / Lee los duplicados y los muestra por pantalla
                case 4:
                    b= new Bichos(1000,"",0,"");
                    b.readDuplicated(b);
                    break;
                //COPIA / Nos permite clonar cualquier archivo por ejemplo para hacer una copia de seguridad de nuestro registro
                case 5:
                    Nio.copia();
                    break;
                //Acaba con el programa y cierra el RAF
                case 0:
                    if(raf!=null)
                        raf.close();
                    System.out.printf("Fin del programa");
                    System.exit(0);
            }
        }
    }
}

