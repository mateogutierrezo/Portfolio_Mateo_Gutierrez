package com.example;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TNodoTrieTelefonosTest {
    private TArbolTrieTelefonos trie;

    @BeforeEach
    public void setUp() {
        trie = new TArbolTrieTelefonos();
    }

    @Test
    public void insertar_unAbonado_esInsertado() {
        trie.insertar(new TAbonado("JOSE GREGORIO RIBERA ALVES", "05490114217"));
        assertTrue(trie.buscarTelefonos("054", "90").size() == 1);
    }

    @Test
    public void insertar_AbonadoRepetido_NoExplota() {
        trie.insertar(new TAbonado("JOSE GREGORIO RIBERA ALVES", "05490114217"));
        trie.insertar(new TAbonado("JOSE GREGORIO RIBERA ALVES", "05490114217"));
        assertTrue(trie.buscarTelefonos("054", "90").size() == 1);
    }

    @Test
    public void insertar_AbonadoConPrefijoComun_NoDuplicaNodos() {
        trie.insertar(new TAbonado("JOSE GREGORIO RIBERA ALVES", "05490114217"));
        trie.insertar(new TAbonado("MARIA CONSUELO OVIEDO MERCADO", "05490116271"));
        assertTrue(trie.getRaiz().getHijos().size() == 1);
    }

    @Test
    public void buscar_DosAbonadosConPrefijoComun_DevuelveDos() {
        trie.insertar(new TAbonado("JOSE GREGORIO RIBERA ALVES", "05490114217"));
        trie.insertar(new TAbonado("MARIA CONSUELO OVIEDO MERCADO", "05490116271"));
        trie.insertar(new TAbonado("ERICA ALCON SOTELO", "05491416310"));
        assertTrue(trie.buscarTelefonos("054", "90").size() == 2);
    }

    @Test
    public void buscar_AbonadoInexistente_NoExplota() {
        trie.insertar(new TAbonado("JOSE GREGORIO RIBERA ALVES", "05490114217"));
        trie.insertar(new TAbonado("MARIA CONSUELO OVIEDO MERCADO", "05490116271"));
        trie.insertar(new TAbonado("ERICA ALCON SOTELO", "05491416310"));
        assertTrue(trie.buscarTelefonos("598", "91").size() == 0);
    }
}
