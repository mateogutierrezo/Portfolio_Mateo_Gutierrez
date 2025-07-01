import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.TArbolBB;
import com.example.TElementoAB;

public class MenorClaveTest {
    private TArbolBB<Integer> abb;


    @BeforeEach
    public void setUp() {
        abb = new TArbolBB<>();
    }

    @Test
    public void test1() {
        assertTrue(abb.menorClave() == null);
    }

    @Test
    public void test2() {
        abb.insertar(new TElementoAB<Integer>(1, 1));
        assertTrue(abb.menorClave().compareTo(1) == 0);
    }

    @Test
    public void test3() {
        abb.insertar(new TElementoAB<Integer>(1, 1));
        abb.insertar(new TElementoAB<Integer>(2, 2));
        abb.insertar(new TElementoAB<Integer>(3, 3));
        assertTrue(abb.menorClave().compareTo(1)== 0);
    }

    @Test
    public void test4() {
        abb.insertar(new TElementoAB<Integer>(10, 10));
        abb.insertar(new TElementoAB<Integer>(5, 5));
        abb.insertar(new TElementoAB<Integer>(2, 2));
        abb.insertar(new TElementoAB<Integer>(3, 3));
        assertTrue(abb.menorClave().compareTo(2) == 0);
    }
}