import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.TArbolBB;
import com.example.TElementoAB;

public class ListarHojasTest {

    private TArbolBB<Integer> abb;

    @BeforeEach
    public void setUp() {
        abb = new TArbolBB<>();
    }

    @Test 
    public void test1() {
        abb.insertar(new TElementoAB<Integer>(5, 5));
        abb.insertar(new TElementoAB<Integer>(3, 3));
        abb.insertar(new TElementoAB<Integer>(7, 7));
        abb.insertar(new TElementoAB<Integer>(8, 8));
        assertTrue(abb.listarHojas().compareTo("(3,2)(8,3)") == 0);
    }

    @Test 
    public void test2() {
        abb.insertar(new TElementoAB<Integer>(2, 2));
        abb.insertar(new TElementoAB<Integer>(4, 4));
        abb.insertar(new TElementoAB<Integer>(3, 3));
        abb.insertar(new TElementoAB<Integer>(5, 5));
        abb.insertar(new TElementoAB<Integer>(1, 1));
        assertTrue(abb.listarHojas().compareTo("(1,2)(3,3)(5,3)") == 0);
    }
}