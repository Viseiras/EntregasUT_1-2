package javiervicedo.ejercicios.ut1;

import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Guardanums {
    public static void main(String[] args) throws FileNotFoundException {

        final int TAM = Integer.SIZE/8 + Double.SIZE/8; //Pasas a bytes el valor máximo que puede tener cada registro.

        int Tamli= 2*(50+1)+2*Integer.SIZE/8;

        System.out.println("Tamaño total "+TAM);
        try(Scanner sc = new Scanner(System.in);
            RandomAccessFile raf = new RandomAccessFile("Tumadretiene.dat","rw");)
        {
            int val=1;
            double anyir=1;
            while(val!=0&&anyir!=0)
            {
                System.out.println("Introduce numeros en diferentes posiciones de memoria(acaba con 0)");
                System.out.println("Introduce un valor entero");
                val=sc.nextInt();
                if(val!=0) {
                    System.out.println("Introduce un valor real");
                    anyir = sc.nextDouble();
                    raf.seek((long) (val - 1) * TAM);
                    raf.writeInt(val);
                    raf.writeDouble(anyir);
                }
            }
        }
        catch(EOFException e)
        {

        }
        catch(InputMismatchException e)
        {
            e.printStackTrace();
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}

//El tamaño del fichero serán los KB que ocupa la lista en el valor más alto, en este caso 50 por el tamaño de cada objeto, un double son 8 y un int 4, así que un objeto vacío serían 50KB y uno lleno 62KB
