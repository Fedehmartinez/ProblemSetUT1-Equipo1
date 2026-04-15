package ucu.edu.aed.ejercicio24;

import ucu.edu.aed.tda.implementaciones.*;

public class Curso<T> extends Conjunto<T> {
    String nombre;
    ListaEnlazada<Alumno<T>> listaAlumnos;

    public Curso(String nombre, ListaEnlazada<Alumno<T>> listaAlumnos) {
        this.nombre = nombre;

        this.listaAlumnos = listaAlumnos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ListaEnlazada<Alumno<T>> getAlumnos() {
        return listaAlumnos;
    }

    public void agregarAlumno(Alumno<T> alumno, Curso<T> curso) {

        if (alumno == null) {
            throw new IllegalArgumentException("Alumno no puede ser null");
        }

        if (!listaAlumnos.contiene(alumno)) {
            listaAlumnos.agregar(alumno);
        }
    }

    public ListaEnlazada<Alumno<T>> listaAlumnos() {
        Nodo<Alumno<T>> actual = listaAlumnos.getCabeza();

        while (actual != null) {

            System.out.println("- " + actual.getDato().getNombre());
            actual = actual.getSiguiente();

        }
        return listaAlumnos;
    }

}
