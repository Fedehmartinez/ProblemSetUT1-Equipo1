package ucu.edu.aed.ejercicio24;

import junit.framework.TestCase;
import ucu.edu.aed.tda.implementaciones.ListaEnlazada;
import ucu.edu.aed.tda.interfaces.TDAConjunto;

public class ConjuntoTest extends TestCase {

    private Conjunto<String> conjuntoA;
    private Conjunto<String> conjuntoB;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        conjuntoA = new Conjunto<>();
        conjuntoB = new Conjunto<>();
    }

    // Tests de Unión

    public void testUnionAmbosVacios() {
        TDAConjunto<String> resultado = conjuntoA.union(conjuntoB);
        assertEquals(0, resultado.tamaño());
    }

    public void testUnionL1VaciaL2ConElementos() {
        conjuntoB.agregar("B");
        conjuntoB.agregar("C");

        TDAConjunto<String> resultado = conjuntoA.union(conjuntoB);

        assertEquals(2, resultado.tamaño());
        assertTrue(resultado.contiene("B"));
        assertTrue(resultado.contiene("C"));
    }

    public void testUnionL2Vacia() {
        conjuntoA.agregar("A");
        conjuntoA.agregar("B");

        TDAConjunto<String> resultado = conjuntoA.union(conjuntoB);

        assertEquals(2, resultado.tamaño());
        assertTrue(resultado.contiene("A"));
        assertTrue(resultado.contiene("B"));
    }

    public void testUnionConElementosEnComun() {
        conjuntoA.agregar("A");
        conjuntoA.agregar("B");
        conjuntoA.agregar("C");
        conjuntoB.agregar("B");
        conjuntoB.agregar("C");
        conjuntoB.agregar("D");

        TDAConjunto<String> resultado = conjuntoA.union(conjuntoB);

        assertEquals(4, resultado.tamaño());
        assertTrue(resultado.contiene("A"));
        assertTrue(resultado.contiene("B"));
        assertTrue(resultado.contiene("C"));
        assertTrue(resultado.contiene("D"));
    }

    public void testUnionConjuntosIdenticos() {
        conjuntoA.agregar("A");
        conjuntoA.agregar("B");
        conjuntoA.agregar("C");
        conjuntoB.agregar("A");
        conjuntoB.agregar("B");
        conjuntoB.agregar("C");

        TDAConjunto<String> resultado = conjuntoA.union(conjuntoB);

        assertEquals(3, resultado.tamaño());
        assertTrue(resultado.contiene("A"));
        assertTrue(resultado.contiene("B"));
        assertTrue(resultado.contiene("C"));
    }

    public void testUnionSinElementosEnComun() {
        conjuntoA.agregar("A");
        conjuntoB.agregar("B");

        TDAConjunto<String> resultado = conjuntoA.union(conjuntoB);

        assertEquals(2, resultado.tamaño());
        assertTrue(resultado.contiene("A"));
        assertTrue(resultado.contiene("B"));
    }

    // Tests de Intersección

    public void testInterseccionAmbosVacios() {
        TDAConjunto<String> resultado = conjuntoA.interseccion(conjuntoB);
        assertEquals(0, resultado.tamaño());
    }

    public void testInterseccionL2Vacia() {
        conjuntoA.agregar("A");
        conjuntoA.agregar("B");

        TDAConjunto<String> resultado = conjuntoA.interseccion(conjuntoB);

        assertEquals(0, resultado.tamaño());
    }

    public void testInterseccionDevuelveSoloElementosComunes() {
        conjuntoA.agregar("A");
        conjuntoA.agregar("B");
        conjuntoA.agregar("C");
        conjuntoB.agregar("B");
        conjuntoB.agregar("C");
        conjuntoB.agregar("D");

        TDAConjunto<String> resultado = conjuntoA.interseccion(conjuntoB);

        assertEquals(2, resultado.tamaño());
        assertTrue(resultado.contiene("B"));
        assertTrue(resultado.contiene("C"));
        assertFalse(resultado.contiene("A"));
        assertFalse(resultado.contiene("D"));
    }

    public void testInterseccionConjuntosIdenticos() {
        conjuntoA.agregar("A");
        conjuntoA.agregar("B");
        conjuntoA.agregar("C");
        conjuntoB.agregar("A");
        conjuntoB.agregar("B");
        conjuntoB.agregar("C");

        TDAConjunto<String> resultado = conjuntoA.interseccion(conjuntoB);

        assertEquals(3, resultado.tamaño());
        assertTrue(resultado.contiene("A"));
        assertTrue(resultado.contiene("B"));
        assertTrue(resultado.contiene("C"));
    }

    public void testInterseccionSinElementosEnComun() {
        conjuntoA.agregar("A");
        conjuntoA.agregar("B");
        conjuntoB.agregar("C");
        conjuntoB.agregar("D");

        TDAConjunto<String> resultado = conjuntoA.interseccion(conjuntoB);

        assertEquals(0, resultado.tamaño());
    }

    // Test de listarElementos

    public void testListarElementosRetornaListaConMismosElementos() {
        conjuntoA.agregar("X");
        conjuntoA.agregar("Y");
        conjuntoA.agregar("Z");

        ListaEnlazada<String> lista = conjuntoA.listarElementos();

        assertEquals(3, lista.tamaño());
        assertTrue(lista.contiene("X"));
        assertTrue(lista.contiene("Y"));
        assertTrue(lista.contiene("Z"));
    }
}