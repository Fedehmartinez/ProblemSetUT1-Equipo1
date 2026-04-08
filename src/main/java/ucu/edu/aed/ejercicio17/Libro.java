package ucu.edu.aed.ejercicio17;

public class Libro {
    String titulo;
    String ISBN;
    int stock;
    double precio;

    public Libro(String titulo, String ISBN, int stock, double precio) {

        this.titulo = titulo;
        this.ISBN = ISBN;
        this.precio = precio;
        this.stock = stock;

    }
    public Libro(String titulo, String ISBN) {

        this.titulo = titulo;
        this.ISBN = ISBN;
        this.precio = 0.0;
        this.stock = 0;

    }
    @Override
    public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;
    Libro otro = (Libro) obj;
    return ISBN.equals(otro.ISBN);
    }

    public Libro(String titulo, String ISBN, double precio) {

        this.titulo = titulo;
        this.ISBN = ISBN;
        this.stock = 0;
        this.precio = precio;

    }

    public void agregarStock(int cantidad) {
        if (cantidad > 0) {
            this.stock += cantidad;
        }
    }

    @Override
    public String toString() {

        return "Titulo: " + this.titulo + ", ISBN: " + this.ISBN + ", Precio: " + this.precio + ", Stock: " + this.stock;
    }
    public String getTitulo() {
        return titulo;
    }
    public int getEjemplaresDisponibles() {
        return stock;
    }
    public void setEjemplaresDisponibles(int stock) {
        this.stock = stock;
    }

}
