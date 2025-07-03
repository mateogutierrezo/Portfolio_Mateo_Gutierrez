import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.example.GeneradorDatosGenericos;
import com.example.TClasificador;

public class TestOrdenarPorInsercion {
    
    private int[] V;
    private TClasificador clasificador;
    private GeneradorDatosGenericos gdt;

    @org.junit.jupiter.api.BeforeEach
    public void setUp() {
        gdt = new GeneradorDatosGenericos();
        clasificador = new TClasificador();
    }

    @Test
    public void TestOrdenarPorInsercionAleatorios() {
        V = gdt.generarDatosAleatorios();
        Assertions.assertTrue(clasificador.estaOrdenado(clasificador.clasificar(V, 1)));
    }

    @Test
    public void TestOrdenarPorInsercionAscendentes() {
        V = gdt.generarDatosAscendentes();
        Assertions.assertTrue(clasificador.estaOrdenado(clasificador.clasificar(V, 1)));
    }

    @Test
    public void TestOrdenarPorInsercionDescendentes() {
        V = gdt.generarDatosDescendentes();
        Assertions.assertTrue(clasificador.estaOrdenado(clasificador.clasificar(V, 1)));
    }
}
