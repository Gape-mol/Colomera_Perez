package org.example;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class RegistroTest {

    @Test
    void agregarPersonaTest() {
        String[][] registro = new String[50][3];
        Registro.agregarPersona(registro, "Juan", "soltero/a", 20);
        assertEquals("Juan", registro[0][0]);
        assertEquals("soltero/a", registro[0][1]);
        assertEquals("20", registro[0][2]);
    }

    @Test
    void contarPersonasDeTerceraEdadTest() {
        String[][] registro = new String[50][3];
        Registro.agregarPersona(registro, "Juan", "soltero/a", 20);
        Registro.agregarPersona(registro, "Ana", "casado/a", 65);
        Registro.agregarPersona(registro, "Pedro", "soltero/a", 70);
        assertEquals(2, Registro.contarPersonasDeTerceraEdad(registro));
    }

    @Test
    void mostrarCantidadPersonasSegunEstadoCivilTest() {
        String[][] registro = new String[50][3];
        Registro.agregarPersona(registro, "Juan", "soltero/a", 20);
        Registro.agregarPersona(registro, "Ana", "casado/a", 65);
        Registro.agregarPersona(registro, "Pedro", "soltero/a", 70);
        Registro.mostrarCantidadPersonasSegunEstadoCivil(registro); //Esta funcion no retorna nada, asi que simplemente la probare
    }
    @Test
    void definirEstadoCivilTest() {
        assertEquals("soltero/a", Registro.definirEstadoCivil("s"));
        assertEquals("casado/a", Registro.definirEstadoCivil("c"));
    }

    @Test
    void espaciosDisponiblesTest(){
        String[][] registro = new String[50][3];
        assertEquals(50, Registro.espaciosDisponibles(registro));
        Registro.agregarPersona(registro, "Juan", "soltero/a", 20);
        assertEquals(49, Registro.espaciosDisponibles(registro));
    }

    @Test
    void obtenerUltimoEspacioTest(){
        String[][] registro = new String[50][3];
        assertEquals(0, Registro.obtenerUltimoEspacio(registro));
        Registro.agregarPersona(registro, "Juan", "soltero/a", 20);
        assertEquals(1, Registro.obtenerUltimoEspacio(registro));
    }

}