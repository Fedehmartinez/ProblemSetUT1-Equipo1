package ucu.edu.aed.tda;

public class Biblioteca extends TDAListaEnlazada {

    TDAListaEnlazada<Libro> listalibros = new TDAListaEnlazada<>();
    TDAListaEnlazada<Libro> listalibrosenprestamo = new TDAListaEnlazada<>();

    public void RegistrarPrestamo(int ISBN) {
        
        Nodo<Libro> cabeza = listalibros.cabeza;
        Nodo<Libro> actual = cabeza;

        while (actual != null) {
            if (actual.getDato().equals(ISBN)) {
                if (actual.getDato().stock >0) {
                    actual.getDato().stock--;
                    System.out.println("Préstamo registrado para ISBN: " + actual.getDato().ISBN);
                    System.out.println("Stock restante: " + actual.getDato().stock);
                    listalibrosenprestamo.agregar(actual.getDato());
                    return;
                }
                else {
                    System.out.println("No hay stock disponible para ISBN: " + actual.getDato().ISBN);
                    return;
                }
            }
            actual = actual.getSiguiente();
        }
        System.out.println("ISBN no encontrado: " + ISBN);
    }

    public void RegistrarDevolucion(int ISBN) {
        Nodo<Libro> cabeza = listalibros.cabeza;
        Nodo<Libro> actual = cabeza;

        while (actual != null) {
            if (actual.getDato().equals(ISBN)) {
                actual.getDato().stock++;
                System.out.println("Devolución registrada para ISBN: " + actual.getDato().ISBN);
                System.out.println("Stock actualizado: " + actual.getDato().stock);
                listalibrosenprestamo.eliminar(actual.getDato());
                return;
            }
            actual = actual.getSiguiente();
        }
        System.out.println("ISBN no encontrado: " + ISBN);
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
                    System.out.println("Tipo de transacción no reconocido: " + tipoTransaccion + ". Use 'donar' o 'comprar'.");
                }
                return;
            }
            actual = actual.getSiguiente();
        }
        System.out.println("ISBN no encontrado para la transacción: " + ISBN);
    }
    


}
