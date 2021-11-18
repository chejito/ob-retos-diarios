package es.sergiomendez;

import java.util.ArrayList;
import java.util.Arrays;

public class Comando {
    public static void comprobarComando(String comando) {
        ArrayList<String> comandosValidos = new ArrayList<>(Arrays.asList("ls", "cd", "pwd"));
        String[] terminosComando = comando.split(" ");
        String primerTermino = terminosComando[0];

        if (comandosValidos.contains(primerTermino)) {
            System.out.println("\nComando introducido: " + primerTermino);
            switch (primerTermino) {
                case "ls" -> {
                    if (terminosComando.length == 1) {
                        Directorio.obtenerListadoContenido("normal");
                        break;
                    } else if (terminosComando.length == 2 && terminosComando[1].equals("-l")) {
                        System.out.println("Subcomando introducido: " + terminosComando[1]);
                        Directorio.obtenerListadoContenido("extendida");
                        break;
                    }

                    System.out.println("SubComandos excesivos y/o no válidos");
                }

                case "cd" -> {
                    if (terminosComando.length == 2) {
                        String directorio = terminosComando[1];
                        System.out.println("Directorio: " + directorio);
                        Directorio.cambiarElDirectorio(directorio);
                        break;
                    }

                    System.out.println("Número de argumentos incorrecto, " +
                            "sólo puede haber un directorio y no puede estar vacío");
                }

                case "pwd" -> Directorio.imprimirDirectorioActual();
            }
        } else {
            System.out.println("Comando no reconocido. Introduzca un comando válido");
        }
    }
}
