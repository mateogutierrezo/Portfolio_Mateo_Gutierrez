package com.example.tads;
import java.util.ArrayList;
import java.util.LinkedList;

public class TNodoTrieTelefonos implements INodoTrieTelefonos {

    private Character digito;
    private ArrayList<TNodoTrieTelefonos> hijos;
    private TNodoFinTelefono finTelefono;

    public TNodoTrieTelefonos() {
        this.digito = null;
        this.hijos = new ArrayList<>();
        this.finTelefono = null;
    }

    public ArrayList<TNodoTrieTelefonos> getHijos() {
        return hijos;
    }

    public boolean esTelefono() {
        return finTelefono != null;
    }

    @Override
    public void buscarTelefonos(String primerosDigitos, LinkedList<TAbonado> abonados) {
        TNodoTrieTelefonos actual = this;
        for (int i = 0; i < primerosDigitos.length(); i++) {
            TNodoTrieTelefonos hijo = actual.buscarHijo(primerosDigitos.charAt(i));
            if (hijo == null) {
                return; 
            }
            actual = hijo;
        }
        actual.buscarTelefonosRecursivo(abonados);
    }

    public void buscarTelefonosRecursivo(LinkedList<TAbonado> abonados) {
        if (esTelefono()) {
            abonados.add(finTelefono.getAbonado());
        } else {
            for (TNodoTrieTelefonos hijo : hijos) {
                hijo.buscarTelefonosRecursivo(abonados);
            }
        }
    }

    @Override
    public void insertar(TAbonado unAbonado) {
        String telefono = unAbonado.getTelefono();
        TNodoTrieTelefonos actual = this;
        for (int i = 0; i < telefono.length(); i++) {
            TNodoTrieTelefonos hijo = actual.buscarHijo(telefono.charAt(i));
            if (hijo == null) {
                TNodoTrieTelefonos nuevoHijo = new TNodoTrieTelefonos();
                nuevoHijo.digito = telefono.charAt(i);
                actual.hijos.add(nuevoHijo);
                actual = nuevoHijo; 
            } else {
                actual = hijo;
            }
        }
        if (!actual.esTelefono()) {
                actual.finTelefono = new TNodoFinTelefono(unAbonado);
        }
    }

    public TNodoTrieTelefonos buscarHijo(Character digito) {
        for (TNodoTrieTelefonos hijo : hijos) {
            if (hijo.digito.compareTo(digito) == 0){
                return hijo;
            }        
        }
        return null;
    }
}
