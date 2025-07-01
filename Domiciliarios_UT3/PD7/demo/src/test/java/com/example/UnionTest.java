package com.example;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;


public class UnionTest {

    private IConjunto<String> conjunto1;
    private IConjunto<String> conjunto2;
    private IConjunto<String> resultado;

    @BeforeEach
    void setUp() {
        conjunto1 = new Conjunto<>();
        conjunto2 = new Conjunto<>();
    }

    @Test 
    public void testUnConjuntoVacio() {
        conjunto1.insertar(3, "");
        conjunto1.insertar(2, "");
        conjunto1.insertar(1, "");

        resultado = conjunto1.union(conjunto2);

        assertTrue(resultado.buscar(3) != null);
        assertTrue(resultado.buscar(2) != null);
        assertTrue(resultado.buscar(1) != null);
    }

    @Test
    public void testElementosRepetidos() {
        conjunto1.insertar(3, "");
        conjunto1.insertar(2, "");
        conjunto1.insertar(1, "");

        conjunto2.insertar(3, "");
        conjunto2.insertar(2, "");
        conjunto2.insertar(1, "");

        resultado = conjunto1.union(conjunto2);

        assertTrue(resultado.buscar(1) != null);
        assertTrue(resultado.buscar(2) != null);
        assertTrue(resultado.buscar(3) != null);
        assertTrue(resultado.cantElementos() == 3);

    }

    @Test
    public void testElementosDistintos() {
        conjunto1.insertar(1, "");
        conjunto1.insertar(3, "");
        conjunto1.insertar(5, "");

        conjunto1.insertar(2, "");
        conjunto1.insertar(4, "");
        conjunto1.insertar(6, "");
        
        resultado = conjunto1.union(conjunto2);

        assertTrue(resultado.buscar(1) != null);
        assertTrue(resultado.buscar(2) != null);
        assertTrue(resultado.buscar(3) != null);
        assertTrue(resultado.buscar(4) != null);
        assertTrue(resultado.buscar(5) != null);
        assertTrue(resultado.buscar(6) != null);
    }

    @Test
    public void testDosConjuntosVacios() {
        resultado = conjunto1.union(conjunto2);

        assertTrue(resultado.esVacia());
    }
}
