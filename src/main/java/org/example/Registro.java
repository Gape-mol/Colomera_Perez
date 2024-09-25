package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Registro {
    public static void main(String[] args) {
        String[][] registro = new String[50][3];
        menu(registro);
    }

    public static void printMenu() {
        System.out.println("""
                Menú
                1) Agregar persona.
                2) Mostrar la cantidad de personas mayores de edad.
                3) Mostrar la cantidad de personas menores de edad.
                4) Mostrar la cantidad de personas de tercera edad.
                5) Mostrar la cantidad de personas según estado civil (Soltero/a - Casado/a).
                6)Salir.
                """);
    }

    public static int leerOpcion() {
        int a = -1;
        do {
            try {
                System.out.print("Ingrese una opción: ");
                a = new Scanner(System.in).nextInt();
                if (a < 0 || a > 6) {
                    System.err.println("Opción inválida");
                }
            } catch (InputMismatchException e) {
                System.err.println("Opción inválida");
            }
        } while (a < 0 || a > 6);
        return a;
    }

    public static void menu(String[][] registro) {
        int a;
        printMenu();
        a = leerOpcion();
        seleccionarOpcion(a, registro);
    }

    public static void seleccionarOpcion(int a, String[][] registro) {
        {
            if (a == 1) {
               agregarPersona(registro);
                }
            } else if (a == 2) {
                int mayoresDeEdad = 0;
                for (double[] persona : registro) {
                    if (persona[2] >= 18) mayoresDeEdad++;
                }
                System.out.println("Hay " + mayoresDeEdad + " mayores de edad.");
            } else if (a == 3) {
                int menoresDeEdad = 0;
                int queSera = obtenerUltimoEspacio(registro);
                for (int i = 0; i < queSera; i++) {
                    if (registro[i][2] < 18) menoresDeEdad++;
                }
                System.out.println("Hay " + menoresDeEdad + " menores de edad.");
            } else if (a == 4) {
                contarPersonasDeTerceraEdad(registro);
            } else if (a == 5) {
                mostrarCantidadPersonasSegunEstadoCivil(registro);
            } else if (a == 6) {
                System.out.println("Programa finalizado");
            }
        }

    public static void agregarPersona(String[][] registro) {
        if (hayCupo(registro)) {
            int indiceDisponible = obtenerUltimoEspacio(registro);
            String nombre = leerNombre();
            String Estadocivil = leerEstadoCivil();
            String edad = String.valueOf(leerEdad());
            registro[indiceDisponible][0] = nombre;
            registro[indiceDisponible][1] = Estadocivil;
            registro[indiceDisponible][2] = edad;
            System.out.println("Persona agregada.");
        } else {
            System.out.println("No hay cupo.");
        }
    }

    public static String leerNombre(){
        String nombre;
        while (true) {
            try {
                System.out.print("Ingrese el nombre: ");
                nombre = new Scanner(System.in).nextLine();
                break;
            } catch (InputMismatchException e) {
                System.err.println("Opción inválida");
            }
        }
        return nombre;
    }

    public static int leerEdad(){
        int edad = 0;
        while (true) {
            try {
                System.out.print("Ingrese la edad: ");
                edad = new Scanner(System.in).nextInt();
                break;
            } catch (InputMismatchException e) {
                System.err.println("Opción inválida");
            }
        }
        return edad;
    }

    public static String leerEstadoCivil() {
        String estadoCivil;
        while (true) {
            try {
                System.out.print("Ingrese el estado civil: ");
                System.out.println("'s' para soltero o 'c' para casado");
                estadoCivil = new Scanner(System.in).nextLine();
                break;
            } catch (InputMismatchException e) {
                System.err.println("Opción inválida");
            }
        }
        estadoCivil = estadoCivil.toLowerCase();
        return definirEstadoCivil(estadoCivil);
    }

    public static String definirEstadoCivil(String estadoCivil){
        if (estadoCivil.equals("s")) {
            return "soltero/a";
        } else if (estadoCivil.equals("c")) {
            return "casado/a";
        } else {
            System.err.println("Opción inválida");
            return leerEstadoCivil();
        }
    }

    public static void contarPersonasDeTerceraEdad (String[][]registro){
        int cantidadPersonasTerceraEdad = 0;
        for (String[] persona : registro) {
            int edad = Integer.parseInt(persona[2]);
            if (edad >= 60) {
                cantidadPersonasTerceraEdad++;
            }
            System.out.println("Hay " + cantidadPersonasTerceraEdad + " personas de tercera edad");
        }
    }

    public static void mostrarCantidadPersonasSegunEstadoCivil (String[][]registro){
        int solteros = 0;
        int casados = 0;
        for (String[] persona : registro) {
            if (persona[1].equals("casado/a")) {
                casados++;
            } else if (persona[1].equals("soltero/a")) {
                solteros++;
            }
        }
        System.out.println("Hay " + casados + " casados/as.");
        System.out.println("Hay " + solteros + " solteros/as.");
    }

    public static int obtenerUltimoEspacio(String [][] registro) {
        return registro.length - espaciosDisponibles(registro);
    }

    public static boolean hayCupo(String [][] registro) {
        return espaciosDisponibles(registro) != 0;
    }

    public static int espaciosDisponibles(String [][] registro) {
        for(int i = 0; i < registro.length; i++) {
            if(registro[i][0].isEmpty()){
                return registro.length - i;
            }
        }
        return 0;
    }
}