package com.example;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

public class InterseccionTest {
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

        resultado = conjunto1.interseccion(conjunto2);

        assertTrue(resultado.esVacia());
    }

    @Test
    public void testElementosEnComun() {
        conjunto1.insertar(3, "");
        conjunto1.insertar(2, "");
        conjunto1.insertar(1, "");

        conjunto2.insertar(1, "");
        conjunto2.insertar(3, "");
        conjunto2.insertar(4, "");

        resultado = conjunto1.interseccion(conjunto2);

        assertTrue(resultado.buscar(3) != null);
        assertTrue(resultado.buscar(2) == null);
        assertTrue(resultado.buscar(1) != null);
    }

    @Test
    public void testNingunElementoEnComun() {
        conjunto1.insertar(3, "");
        conjunto1.insertar(2, "");
        conjunto1.insertar(1, "");

        conjunto2.insertar(4, "");
        conjunto2.insertar(5, "");
        conjunto2.insertar(6, "");

        resultado = conjunto1.interseccion(conjunto2);

        assertTrue(resultado.esVacia());
    }

    @Test
    public void testDosConjuntosVacios() {
        resultado = conjunto1.interseccion(conjunto2);

        assertTrue(resultado.esVacia());
    }
}
