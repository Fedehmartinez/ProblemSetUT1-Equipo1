package ucu.edu.aed.tda;

public class Biblioteca extends TDAListaEnlazada<Libro> {


    public void agregarLibro(Libro libro) {
        this.agregar(libro);
    }

    public void buscarLibro(int ISBN) {
        Libro libroBusqueda = new Libro("", "", ISBN);
        this.buscar(libroBusqueda);
    }

    public void registrarTransaccion(int ISBN, int cantidad, String tipoTransaccion) {
        Libro libroBusqueda = new Libro("", "", ISBN);
        Nodo<Libro> actual = cabeza;
        while (actual != null) {
            if (actual.getDato().equals(libroBusqueda)) {
                Libro libroEncontrado = actual.getDato();
                if (tipoTransaccion.equalsIgnoreCase("donar")) {
                    if (libroEncontrado.stock >= 1) {
                        libroEncontrado.stock -= cantidad;
                        System.out.println("Donación registrada: Se donaron " + cantidad + " ejemplares de " + libroEncontrado.titulo);
                    } else {
                        System.out.println("No hay suficiente stock para la donación de " + cantidad + " ejemplares de " + libroEncontrado.titulo);
                    }
                } else if (tipoTransaccion.equalsIgnoreCase("comprar")) {
                    libroEncontrado.stock += cantidad;
                    System.out.println("Compra registrada: " + cantidad + " ejemplares de " + libroEncontrado.titulo);
                } else {
                    System.out.println("Tipo de transacción no reconocido: " + tipoTransaccion);
                }
                return;
            }
            actual = actual.getSiguiente();
        }
        System.out.println("ISBN no encontrado para la transacción: " + ISBN);
    }
    


}
