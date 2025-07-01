package com.example;

public class TAlumno {
    private int cedula;
    private String nombreCompleto;

    public TAlumno(int cedula, String nombreCompleto) {
        this.cedula = cedula;
        this.nombreCompleto = nombreCompleto;
    }

    public int getCedula() {
        return cedula;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }
}
