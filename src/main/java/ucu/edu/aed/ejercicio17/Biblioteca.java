package ucu.edu.aed.tda;

public class Biblioteca {

    TDAListaEnlazada<Libro> listalibros = new TDAListaEnlazada<>();
    TDAListaEnlazada<Libro> listalibrosenprestamo = new TDAListaEnlazada<>();

    public void RegistrarPrestamo(String ISBN) {
        Nodo<Libro> actual = listalibros.cabeza;
        while (actual != null) {
            if (actual.getDato().equals(ISBN)) {
                if (actual.getDato().stock > 0) {
                    actual.getDato().stock--;
                    System.out.println("Préstamo registrado para ISBN: " + actual.getDato().ISBN);
                    System.out.println("Stock restante: " + actual.getDato().stock);
                    listalibrosenprestamo.agregar(actual.getDato());
                    return;
                } else {
                    System.out.println("No hay stock disponible para ISBN: " + actual.getDato().ISBN);
                    return;
                }
            }
            actual = actual.getSiguiente();
        }
        System.out.println("ISBN no encontrado: " + ISBN);
    }

    public void RegistrarDevolucion(String ISBN) {
        Nodo<Libro> actual = listalibros.cabeza;
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
        Nodo<Libro> actual = listalibrosenprestamo.cabeza;
        System.out.println("Libros actualmente en préstamo:");
        while (actual != null) {
            System.out.println("ISBN: " + actual.getDato().ISBN + ", Título: " + actual.getDato().titulo);
            actual = actual.getSiguiente();
        }
    }

    public void registrarTransaccion(String ISBN, int cantidad, String tipoTransaccion) {
        Libro libroBusqueda = new Libro("", ISBN);
        Nodo<Libro> actual = listalibros.cabeza;
        while (actual != null) {
            if (actual.getDato().equals(libroBusqueda)) {
                Libro libroEncontrado = actual.getDato();
                if (tipoTransaccion.equalsIgnoreCase("donar")) {
                    if (libroEncontrado.stock >= cantidad) { // <-- fix
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

    public Libro retirarLibro(String ISBN) {
        Libro libroBusqueda = new Libro("", ISBN);
        Nodo<Libro> actual = listalibros.cabeza; 
        while (actual != null) {
            if (actual.getDato().equals(libroBusqueda)) {
                Libro libroEncontrado = actual.getDato();
                listalibros.eliminar(libroEncontrado);
                System.out.println("Libro retirado: " + libroEncontrado.titulo + " con ISBN: " + libroEncontrado.ISBN);
                return libroEncontrado;
            }
            actual = actual.getSiguiente();
        }
        System.out.println("ISBN no encontrado para retirar libro: " + ISBN);
        return null;
    }

    public Libro consultarExistenciaLibro(String ISBN) {
        Libro libroBusqueda = new Libro("", ISBN, 0, 0.0);
        Nodo<Libro> actual = listalibros.cabeza; 
        while (actual != null) {
            if (actual.getDato().equals(libroBusqueda)) {
                Libro libroEncontrado = actual.getDato();
                System.out.println("Libro encontrado: " + libroEncontrado.titulo + " con ISBN: " + libroEncontrado.ISBN + " y stock: " + libroEncontrado.stock);
                return libroEncontrado;
            }
            actual = actual.getSiguiente();
        }
        System.out.println("ISBN no encontrado para consultar existencia: " + ISBN);
        return null;
    }

    public String listarLibros() {
        Nodo<Libro> actual = listalibros.cabeza;
        StringBuilder resultado = new StringBuilder("Libros en la biblioteca:\n");
        while (actual != null) {
            resultado.append("ISBN: ").append(actual.getDato().ISBN)
                    .append(", Título: ").append(actual.getDato().titulo)
                    .append(", Stock: ").append(actual.getDato().stock)
                    .append("\n");
            actual = actual.getSiguiente();
        }
        return resultado.toString();
    }

    public void agregarLibro(Libro libro) {
        listalibros.agregar(libro);
        System.out.println("Libro agregado: " + libro.titulo + " con ISBN: " + libro.ISBN);
    }

    public Libro buscarPorCodigo(String ISBN) {
        Libro libroBusqueda = new Libro("", ISBN, 0, 0.0);
        Nodo<Libro> actual = listalibros.cabeza; 
        while (actual != null) {
            if (actual.getDato().equals(libroBusqueda)) {
                Libro libroEncontrado = actual.getDato();
                System.out.println("Libro encontrado: " + libroEncontrado.titulo + " con ISBN: " + libroEncontrado.ISBN);
                return libroEncontrado;
            }
            actual = actual.getSiguiente();
        }
        System.out.println("ISBN no encontrado para buscar por código: " + ISBN);
        return null;
    }
}