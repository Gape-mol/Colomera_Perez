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
    public static void opciones (int opcion, String[][] registro ) {
        switch (opcion) {
            case 1:
                System.out.println("a");
            case 2:
                opcion2();
            case 3:
                opcion3();
            case 4:
                System.out.println("a");
            case 5:
                System.out.println("a");
            case 6:
                System.out.println("Programa finalizado");

                break;
            default:

        }
    }
        //}while (a == 6);// como se va a cumplir que a sea = 6 si se supone que el a es para la opciones

    public static void opcion2 (){
            int mayoresDeEdad = 0;
            for (String persona : registro) {
                if (Integer.parseInt(persona[2]) >= 18) {
                    mayoresDeEdad++;
                    System.out.println("Persona mayor de edad: " + persona[0] + " " + persona[1]);
                }
            }
            System.out.println("Hay " + mayoresDeEdad + " mayores de edad.");
        }

    public static void opcion3(){
            int menoresDeEdad = 0;
            for (String persona : registro) {
                if (Integer.parseInt(persona[2]) < 18){
                    menoresDeEdad++;
                    System.out.println("Persona mayor de edad: " + persona[0] + " " + persona[1]);
                }
            }
            System.out.println("Hay " + menoresDeEdad + " menores de edad.");

        }
    public static int obtenerUltimoEspacio(double [] registro) {
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