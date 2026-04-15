package ucu.edu.aed.ejercicio24;

import junit.framework.TestCase;
import ucu.edu.aed.tda.interfaces.TDAConjunto;
import ucu.edu.aed.tda.implementaciones.ListaEnlazada;

public class ConjuntoTest extends TestCase {

    private Conjunto<String> conjuntoA;
    private Conjunto<String> conjuntoB;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        conjuntoA = new Conjunto<>();
        conjuntoB = new Conjunto<>();
    }

    public void testUnionConElementosDistintos() {
        conjuntoA.agregar("A");
        conjuntoA.agregar("B");
        conjuntoB.agregar("B");
        conjuntoB.agregar("C");

        TDAConjunto<String> resultado = conjuntoA.union(conjuntoB);

        assertEquals(3, resultado.tamaño());
        assertTrue(resultado.contiene("A"));
        assertTrue(resultado.contiene("B"));
        assertTrue(resultado.contiene("C"));
    }

    public void testInterseccionDevuelveSoloElementosComunes() {
        conjuntoA.agregar("A");
        conjuntoA.agregar("B");
        conjuntoB.agregar("B");
        conjuntoB.agregar("C");

        TDAConjunto<String> resultado = conjuntoA.interseccion(conjuntoB);

        assertEquals(1, resultado.tamaño());
        assertTrue(resultado.contiene("B"));
        assertFalse(resultado.contiene("A"));
        assertFalse(resultado.contiene("C"));
    }

    public void testListarElementosRetornaListaConmismosElementos() {
        conjuntoA.agregar("X");
        conjuntoA.agregar("Y");
        conjuntoA.agregar("Z");

        ListaEnlazada<String> lista = conjuntoA.listarElementos(conjuntoA);

        assertEquals(3, lista.tamaño());
        assertEquals("X", lista.obtener(0));
        assertEquals("Y", lista.obtener(1));
        assertEquals("Z", lista.obtener(2));
    }

    public void testUnionConjuntoVacio() {
        conjuntoA.agregar("A");
        conjuntoA.agregar("B");

        TDAConjunto<String> resultado = conjuntoA.union(conjuntoB);

        assertEquals(2, resultado.tamaño());
        assertTrue(resultado.contiene("A"));
        assertTrue(resultado.contiene("B"));
    }

    public void testInterseccionConConjuntoVacioDevuelveVacio() {
        conjuntoA.agregar("A");
        conjuntoA.agregar("B");

        TDAConjunto<String> resultado = conjuntoA.interseccion(conjuntoB);

        assertEquals(0, resultado.tamaño());
    }
}
