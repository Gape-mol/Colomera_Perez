package org.example;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RegistroTest {
    @org.junit.jupiter.api.Test
    String opcion2() {
        String[] registro = {"Juan Perez 17", "Maria Gomez 19", "Pedro Sanchez 15", "Ana Rodriguez 20"};
        int expectedMenoresDeEdad = 2;
        int menoresDeEdad = 0;
        for (String persona : registro) {
            if (Integer.parseInt(persona.split(" ")[2]) < 18) {
                menoresDeEdad++;
            }
        }
        assertEquals(expectedMenoresDeEdad, menoresDeEdad);

        return null;
    }





}
