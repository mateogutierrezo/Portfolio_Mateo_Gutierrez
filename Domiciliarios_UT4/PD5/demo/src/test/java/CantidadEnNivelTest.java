import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.TArbolBB;
import com.example.TElementoAB;

public class CantidadEnNivelTest {
    
    private TArbolBB<Integer> abb;

    @BeforeEach
    public void setUp() {
        abb = new TArbolBB<>();
        abb.insertar(new TElementoAB<Integer>(10, 10));
        abb.insertar(new TElementoAB<Integer>(5, 5));
        abb.insertar(new TElementoAB<Integer>(2, 2));
        abb.insertar(new TElementoAB<Integer>(1, 1));
        abb.insertar(new TElementoAB<Integer>(3, 3));
        abb.insertar(new TElementoAB<Integer>(6, 6));
        abb.insertar(new TElementoAB<Integer>(7, 7));
        abb.insertar(new TElementoAB<Integer>(8, 8));
    }

    @Test 
    public void test1() {
        assertTrue(abb.cantidadEnNivel(1) == 1);
    }

    @Test 
    public void test2() {
        assertTrue(abb.cantidadEnNivel(3) == 2);
    }

    @Test 
    public void test3() {
        assertTrue(abb.cantidadEnNivel(4) == 3);
    }

    @Test 
    public void test4() {
        assertTrue(abb.cantidadEnNivel(6) == 0);
    }
}
