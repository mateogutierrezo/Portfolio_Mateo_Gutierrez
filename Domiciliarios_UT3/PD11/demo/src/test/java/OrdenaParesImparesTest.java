import com.example.Lista;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class OrdenaParesImparesTest {
    @Test
    public void testOrdenaParesImpares() {
        Lista<String> lista = new Lista<>();
        lista.insertar(null, 5);
        lista.insertar(null, 2);
        lista.insertar(null, 10);
        lista.insertar(null, 3);
        lista.insertar(null, 9);
        lista.insertar(null, 17);
        lista.insertar(null, 8);
        Lista<String> listaOrdenada = lista.ordenaParesImpares();

        assertTrue(listaOrdenada.imprimir(",").compareTo("3,5,9,17,2,8,10") == 0);
    }

}
