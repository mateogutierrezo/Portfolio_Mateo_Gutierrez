package uy.edu.ucu.aed;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Unit test for implemented methods.
 */
public class Parcial2Test_Junit4 
{
    private TDato dato1;
    private TDato dato2;
    private TDato dato3;
    private TMedidor medidor;
    private TGrafoRedDatos red;

    @Before
    public void setUp() {
        // Initialize any resources or objects needed for the tests
        dato1 = new TDato(3.00, 472025);
        dato2 = new TDato(4.13, 372025);
        dato3 = new TDato(5.34, 272025);
        medidor = new TMedidor();

        red = UtilGrafos.cargarGrafo("src\\main\\dispositivos.txt", "src\\main\\conexiones.txt", false, TGrafoRedDatos.class)

        ;
    }

    @After
    public void tearDown() {
        // Release any resources or clean up after the tests
        //instanceVariable = null;
    }

    /**
     * Sample test in JUnit 4
     */
    @Test
    public void TestObtenerMayorMedicion()
    {
        TDato[] datos = {dato1, dato2, dato3};
        assertTrue(medidor.obtenerMayorMedicion(datos) == dato3);
    }

    @Test 
    public void TestConectados() {
        assertTrue(red.conectados("CS30", "CS70"));
        assertTrue(!red.conectados("CS60", "CS90"));
        assertTrue(red.conectados("CS40", "CS60"));
    }
}