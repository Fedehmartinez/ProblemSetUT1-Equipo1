package ucu.edu.aed.ejercicio24;

public class Alumno<T> implements Comparable<Alumno<T>> {
    String nombre;
    String apellido;
    int ci;

    public Alumno(String nombre, int ci, String apellido) {
        this.nombre = nombre;
        this.ci = ci;
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getCi() {
        return ci;
    }

    public void setCi(int ci) {
        this.ci = ci;
    }

    @Override
    public String toString() {
        return "Alumno{" +
                "nombre='" + nombre + '\'' +
                ", apellido =" + apellido +
                ", ci =" + ci +
                '}';
    }

    public static <T> boolean compareTo(Alumno<T> o1, Alumno<T> o2) {

        if (o1 == null || o2 == null)
            return false;
        if (o1.getClass() != o2.getClass())
            return false;
        if (o1.nombre.equals(o2.nombre) && o1.apellido.equals(o2.apellido) && o1.ci == o2.ci)
            return true;
        return false;
    }

    @Override
    public int compareTo(Alumno<T> o) {

        throw new UnsupportedOperationException("Unimplemented method 'compareTo'");
    }

}
