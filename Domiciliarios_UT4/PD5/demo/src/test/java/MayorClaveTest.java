import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.TArbolBB;
import com.example.TElementoAB;

public class MayorClaveTest {
   
    private TArbolBB<Integer> abb;

    @BeforeEach
    public void setUp() {
        abb = new TArbolBB<>();
    }

    @Test
    public void test1() {
        assertTrue(abb.mayorClave() == null);
    }

    @Test
    public void test2() {
        abb.insertar(new TElementoAB<Integer>(1, 1));
        assertTrue(abb.mayorClave().compareTo(1) == 0);
    }

    @Test
    public void test3() {
        abb.insertar(new TElementoAB<Integer>(1, 1));
        abb.insertar(new TElementoAB<Integer>(2, 2));
        abb.insertar(new TElementoAB<Integer>(3, 3));
        assertTrue(abb.mayorClave().compareTo(3) == 0);
    }

    @Test
    public void test4() {
        abb.insertar(new TElementoAB<Integer>(10, 10));
        abb.insertar(new TElementoAB<Integer>(5, 5));
        abb.insertar(new TElementoAB<Integer>(11, 11));
        abb.insertar(new TElementoAB<Integer>(14, 14));
        abb.insertar(new TElementoAB<Integer>(13, 13));
        assertTrue(abb.mayorClave().compareTo(14) == 0);
    }
}
