import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.example.GeneradorDatosGenericos;
import com.example.TClasificador;

public class TestOrdenarPorShell {
    
    private int[] V;
    private TClasificador clasificador;
    private GeneradorDatosGenericos gdt;

    @org.junit.jupiter.api.BeforeEach
    public void setUp() {
        gdt = new GeneradorDatosGenericos();
        clasificador = new TClasificador();
    }

    @Test
    public void TestOrdenarPorShellAleatorios() {
        V = gdt.generarDatosAleatorios();
        Assertions.assertTrue(clasificador.estaOrdenado(clasificador.clasificar(V, 2)));
    }

    @Test
    public void TestOrdenarPorShellAscendentes() {
        V = gdt.generarDatosAscendentes();
        Assertions.assertTrue(clasificador.estaOrdenado(clasificador.clasificar(V, 2)));
    }

    @Test
    public void TestOrdenarPorShellDescendentes() {
        V = gdt.generarDatosDescendentes();
        Assertions.assertTrue(clasificador.estaOrdenado(clasificador.clasificar(V, 2)));
    }
}
