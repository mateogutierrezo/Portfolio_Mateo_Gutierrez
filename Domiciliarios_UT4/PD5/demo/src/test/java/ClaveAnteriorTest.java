import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.TArbolBB;
import com.example.TElementoAB;

public class ClaveAnteriorTest {
    
    private TArbolBB<Integer> abb;

    @BeforeEach
    public void setUp() {
        abb = new TArbolBB<>();
        abb.insertar(new TElementoAB<Integer>(10, 10));
        abb.insertar(new TElementoAB<Integer>(5, 5));
        abb.insertar(new TElementoAB<Integer>(15, 15));
        abb.insertar(new TElementoAB<Integer>(3, 3));
        abb.insertar(new TElementoAB<Integer>(4, 4));
    }

    @Test
    public void test1() {
        assertTrue(abb.claveAnterior(3) == null);
    }

    @Test
    public void test2() {
        assertTrue(abb.claveAnterior(6).compareTo(5) == 0);
    }

    @Test
    public void test3() {
        assertTrue(abb.claveAnterior(15).compareTo(10) == 0);
    }

    @Test
    public void test4() {
        assertTrue(abb.claveAnterior(20).compareTo(15) == 0);
    }
}
