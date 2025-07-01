public class Lista {
    Nodo primero;

    public Lista() {
        this.primero = null;
    }
    
    public void agregar(int valor) {
        Nodo nuevNodo = new Nodo(valor);
        if (primero == null) {
            primero = nuevNodo;
            return;
        }
        Nodo iterador = primero;
        while (iterador.siguiente != null) {
            iterador = iterador.siguiente;
        }
        iterador.siguiente = nuevNodo;
    } 

    public void eliminar(Nodo nodo) {
        if (primero == null){
            return;
        }
        if (primero == nodo) { 
            primero = primero.siguiente;
            return;
        }
        Nodo iterador = primero;
        while (iterador.siguiente != null && iterador.siguiente != nodo) {
            iterador = iterador.siguiente;
        }
        if (iterador.siguiente == nodo) {
            iterador.siguiente = iterador.siguiente.siguiente;
        }
        
    }

    public void eliminarDuplicados() {
        Nodo iterador1 = primero;
        while (iterador1 != null) {
            Nodo iterador2 = iterador1.siguiente;
            while (iterador2 != null) {
                if (iterador1.valor == iterador2.valor) {
                    this.eliminar(iterador2);
                    iterador2 = iterador2.siguiente; 
                } else {
                    iterador2 = iterador2.siguiente; 
                }
            }
            iterador1 = iterador1.siguiente;
        }
    }

    public void imprimirLista() {;
        System.out.print("(");
        Nodo iterador = primero;
        while (iterador != null) {
            iterador.imprimirNodo();
            if (iterador.siguiente != null) { 
                System.out.print(", ");
            }
            iterador = iterador.siguiente;
        }
        System.out.println(")");
    }
}
