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

    public void consultarprestados() {
        Nodo<Libro> cabeza = listalibrosenprestamo.cabeza;
        Nodo<Libro> actual = cabeza;

        System.out.println("Libros actualmente en préstamo:");
        while (actual != null) {
            System.out.println("ISBN: " + actual.getDato().ISBN + ", Título: " + actual.getDato().titulo);
            actual = actual.getSiguiente();
        }
    }

}
