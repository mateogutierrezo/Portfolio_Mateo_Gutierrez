package com.example;

public class Main {
    public static void main(String[] args) {
        Conjunto<TAlumno> cursoAED1 = new Conjunto<>();
        Conjunto<TAlumno> cursoPF = new Conjunto<>();

        cursoAED1.insertar(1234, new TAlumno(1234, "Mateo Gutiérrez"));
        cursoAED1.insertar(2345, new TAlumno(2345, "Juan Pérez"));
        cursoAED1.insertar(3456, new TAlumno(3456, "María López"));

        cursoPF.insertar(1234, new TAlumno(1234, "Mateo Gutiérrez"));
        cursoPF.insertar(2345, new TAlumno(2345, "Juan Pérez"));
        cursoPF.insertar(4567, new TAlumno(4567, "Pablo González"));

        System.out.println(cursoAED1.union(cursoPF).imprimir(","));        
        System.out.println(cursoAED1.interseccion(cursoPF).imprimir(","));
    }
}