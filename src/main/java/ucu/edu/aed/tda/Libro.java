package ucu.edu.aed.tda;

public class Libro {
    String titulo;
    String autor;
    int ISBN;
    int stock;

    public Libro(String titulo, String autor, int ISBN, int stock) {

        this.titulo = titulo;
        this.autor = autor;
        this.ISBN = ISBN;

        this.stock = stock;

    }

    public Libro(String titulo, String autor, int ISBN) {

        this.titulo = titulo;
        this.autor = autor;
        this.ISBN = ISBN;
        this.stock = 0;

    }

    // agregar metrodo agregarStock

    public void agregarStock(int cantidad) {
        if (cantidad > 0) {
            this.stock += cantidad;
        }
    }

    @Override
    public String toString() {

        return "Titulo: " + this.titulo + ", Autor: " + this.autor + ", ISBN: " + this.ISBN + ", Stock: " + this.stock;
    }

}
