package ucu.edu.aed.ejercicio24;

import ucu.edu.aed.ejercicio23.Sucursal;
import ucu.edu.aed.tda.implementaciones.Nodo;
import ucu.edu.aed.tda.implementaciones.TDAListaEnlazada;

public class Curso<T> extends TDAConjunto<Alumno<T>> {
    String nombre;
    TDAListaEnlazada<Alumno<T>> listaAlumnos;

    public Curso(String nombre, String codigo) {
        this.nombre = nombre;

        this.listaAlumnos = new TDAListaEnlazada<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public TDAListaEnlazada<Alumno<T>> getAlumnos() {
        return listaAlumnos;
    }

    public void agregarAlumno(Alumno<T> alumno, Curso<T> curso) {
        // Alumno<T> alumno = new Alumno<T>(alumno.getNombre(), alumno.getCi(),
        // alumno.getApellido());
        if (alumno == null) {
            throw new IllegalArgumentException("Alumno no puede ser null");
        }
        if (!listaAlumnos.contiene(alumno)) {
            listaAlumnos.agregar(alumno);
        }
    }

    public TDAListaEnlazada<Alumno<T>> listaAlumnos() {
        Nodo<Alumno<T>> actual = listaAlumnos.getCabeza();

        while (actual != null) {

            System.out.println("- " + actual.getDato().getNombre());
            actual = actual.getSiguiente();

        }
        return listaAlumnos;
    }

}
