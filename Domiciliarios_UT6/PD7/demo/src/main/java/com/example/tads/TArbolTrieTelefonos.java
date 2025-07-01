package com.example.tads;
import java.util.LinkedList;


public class TArbolTrieTelefonos implements IArbolTrieTelefonos {

    private TNodoTrieTelefonos raiz;

    public TArbolTrieTelefonos() {
        this.raiz = new TNodoTrieTelefonos();
    }

    public TNodoTrieTelefonos getRaiz() {
        return raiz;
    }

    @Override
    public LinkedList<TAbonado> buscarTelefonos(String pais, String area) {
        if (raiz.getHijos().isEmpty()) {
            return null;
        }
        LinkedList<TAbonado> abonados = new LinkedList<>();
        raiz.buscarTelefonos(pais + area, abonados);
        return abonados;
    }

    @Override
    public void insertar(TAbonado unAbonado) {
        raiz.insertar(unAbonado);
    }
}
