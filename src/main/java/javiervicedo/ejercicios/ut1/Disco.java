package javiervicedo.ejercicios.ut1;

public class Disco {
    private double precio;
    private String artista;
    private String nombre;
    public Disco() {
    }

    ;

    public Disco(String nombre, double precio, String artista) {
        this.nombre = nombre;
        this.precio = precio;
        this.artista = artista;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }



    @Override
    public String toString() {
        return "disco{" +
                "nombre='" + nombre + '\'' +
                ", precio=" + precio +
                ", artista='" + artista + '\'' +
                '}';
    }




}


