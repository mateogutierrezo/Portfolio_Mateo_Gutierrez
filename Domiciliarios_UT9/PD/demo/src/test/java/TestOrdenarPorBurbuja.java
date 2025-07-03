import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.example.GeneradorDatosGenericos;
import com.example.TClasificador;

public class TestOrdenarPorBurbuja {
    
    private int[] V;
    private TClasificador clasificador;
    private GeneradorDatosGenericos gdt;

    @org.junit.jupiter.api.BeforeEach
    public void setUp() {
        gdt = new GeneradorDatosGenericos();
        clasificador = new TClasificador();
    }

    @Test
    public void TestOrdenarPorBurbujaAleatorios() {
        V = gdt.generarDatosAleatorios();
        Assertions.assertTrue(clasificador.estaOrdenado(clasificador.clasificar(V, 3)));
    }

    @Test
    public void TestOrdenarPorBurbujaAscendentes() {
        V = gdt.generarDatosAscendentes();
        Assertions.assertTrue(clasificador.estaOrdenado(clasificador.clasificar(V, 3)));
    }

    @Test
    public void TestOrdenarPorBurbujaDescendentes() {
        V = gdt.generarDatosDescendentes();
        Assertions.assertTrue(clasificador.estaOrdenado(clasificador.clasificar(V, 3)));
    }
}