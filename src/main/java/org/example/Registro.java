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
        int opcion;
        printMenu();
        opcion = leerOpcion();
        opciones(opcion, registro);
    }
    public static void opciones (int opcion, String[] registro ) {
        switch (opcion) {
            case 1:
                if(hayCupo(registro)) {
                    int indiceDisponible = obtenerUltimoEspacio(registro);
                    String nombre;
                    String Estadocivil;
                    String edad;
                    nombre = new Scanner(System.in).nextLine();
                    Estadocivil = new Scanner(System.in).nextLine();
                    edad = new Scanner(System.in).nextLine();// cambio del tipo de variable que es la edad ahora es una string
                    registro[indiceDisponible][0] = nombre;
                    registro[indiceDisponible][1] = Estadocivil;
                    registro[indiceDisponible][2] = edad;
                    System.out.println("Persona agregada.");
                } else {
                    System.out.println("No hay cupo.");
                }
                break;
            case 2:
                int mayoresDeEdad = 0;
                for (String [] persona : registro) {
                    if (persona[2] >= 18){//no habia nada dentro del if
                        System.out.println("Personas mayores de edad" + persona[2]);

                    }
                }
                System.out.println("Hay " + mayoresDeEdad + " mayores de edad.");
                break;
            case 3:
                int menoresDeEdad = 0;
                int queSera = obtenerUltimoEspacio(registro);
                for (int i = 0; i < queSera; i++) {
                    if (registro[i][2] < 18) menoresDeEdad++;
                }
                System.out.println("Hay " + menoresDeEdad + " menores de edad.");
                break;
            case 4:
                int mmmm = 0;//mmm no es una variable que describa lo que es
                for (double [] persona : registro) {
                    if (persona[2] >= 60 && persona[1].equals("casado/a")) {
                        mmmm++;
                    } else if(persona[2] >= 65 && persona[1].equals("soltero/a")) {
                        mmmm++;
                    }
                }
                System.out.println("Hay " + mmmm + " personas de tercera edad");
                break;
            case 5:
                int c = 0;
                int d = 0;
                for(double[] persona : registro) {
                    if(persona[1].equals("casado/a")) {
                        c++;
                    } else if(persona[1].equals("soltero/a")) {
                        d++;
                    }
                }
                System.out.println("Hay " + d + " casados/as.");
                System.out.println("Hay " + c + " solteros/as.");
                break;
            case 6:
                System.out.println("Programa finalizado");

                break;
            default:


        }
        //}while (a == 6);// como se va a cumplir que a sea = 6 si se supone que el a es para la opciones
    public static int obtenerUltimoEspacio(double [][] registro) {
        return registro.length - opa(registro);
    }

    public static boolean hayCupo(double [][] registro) {
        return opa(registro) != 0;
    }

    public static int opa(double [][] registro) {
        for(int i = 0; i < registro.length; i++) {
            if(registro[i][0].equals("")){
                return registro.length - i;
            }
        }
        return 0;
    }
}}