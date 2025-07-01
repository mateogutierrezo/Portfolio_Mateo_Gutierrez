import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.example.TArbolBB;
import com.example.TElementoAB;

public class EsAbbTest {
    private TArbolBB<Integer> abb;

    @BeforeEach
    public void setUp() {
        abb = new TArbolBB<>();
    }

    @Test
    public void test1() {
        assertTrue(abb.esAbb());
    }

    @Test
    public void test2() {
        TElementoAB<Integer> root = new TElementoAB<Integer>(5, 5);
        root.setHijoIzq(new TElementoAB<Integer>(4, 4));
        root.setHijoDer(new TElementoAB<Integer>(6, 6));
        abb.insertar(root);
        assertTrue(abb.esAbb());
    }

    @Test
    public void test3() {
        TElementoAB<Integer> root = new TElementoAB<Integer>(5, 5);
        root.setHijoIzq(new TElementoAB<Integer>(6, 6));
        root.setHijoDer(new TElementoAB<Integer>(4, 4));
        abb.insertar(root);
        assertFalse(abb.esAbb());
    }
}
