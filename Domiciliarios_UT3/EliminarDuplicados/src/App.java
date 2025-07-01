public class App {
    public static void main(String[] args) throws Exception {
        Lista lista = new Lista();
        lista.agregar(0);
        lista.imprimirLista();
        lista.agregar(2);
        lista.agregar(-1);
        lista.imprimirLista();
        lista.agregar(45);
        lista.agregar(-100);
        lista.imprimirLista();
        lista.agregar(0);
        lista.imprimirLista();
        lista.eliminarDuplicados();
        lista.imprimirLista();
        lista.agregar(0);
        lista.agregar(45);
        lista.agregar(-100);
        lista.imprimirLista();
        lista.eliminarDuplicados();
        lista.imprimirLista();
    }
}
