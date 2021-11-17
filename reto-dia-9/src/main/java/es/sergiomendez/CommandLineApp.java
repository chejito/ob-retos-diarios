package es.sergiomendez;

import java.io.File;
import java.util.*;

public class CommandLineApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        System.out.println("Bienvenido a la aplicación de ficheros y directorios.");

        boolean runApp = true;
        System.out.println("""
                ¿Qué desea hacer ahora?
                    - "ls": Muestra todos los ficheros y carpetas del directorio.
                    - "cd nombre_directorio": Cambia a un subdirectorio.
                    - "pwd": imprime el directorio activo.
                    - O pulse "Enter" para salir de la aplicación.""");
        do {
            System.out.println("\nIntroduzca un comando:");
            String comando = scanner.nextLine();

            if (comando.equals("")) {
                runApp = false;
            } else {
                comprobarComando(comando);
            }

        } while (runApp);

        System.out.println("Finalizando la aplicación. ¡Hasta pronto!");
    }

    private static void comprobarComando(String comando) {
        ArrayList<String> comandosValidos = new ArrayList<>(Arrays.asList("ls", "cd", "pwd"));
        String[] terminosComando = comando.split(" ");
        String primerTermino = terminosComando[0];

        if (comandosValidos.contains(primerTermino)) {
            System.out.println("Comando introducido: " + primerTermino);
            switch (primerTermino) {
                case "ls" -> obtenerListadoCarpetasYFicheros();
                case "cd" -> {
                    if (terminosComando.length == 2) {
                        String subdirectorio = terminosComando[1];
                        System.out.println("Subdirectorio: " + subdirectorio);
                        cambiarAlSubdirectorio(subdirectorio);
                        break;
                    }
                    System.out.println("Número de argumentos incorrecto, sólo puede haber un subdirectorio y no puede estar vacío");
                }
                case "pwd" -> imprimirDirectorioActual();
            }
        } else {
            System.out.println("Comando no reconocido. Introduzca un comando válido");
        }
    }

    private static void imprimirDirectorioActual() {
        File carpetaActual = obtenerDirectorioActual();

        System.out.println("Directorio actual: " + carpetaActual);
    }

    private static File obtenerDirectorioActual() {
        String directorioActual = System.getProperty("user.dir");

        return new File(directorioActual);
    }

    private static void cambiarAlSubdirectorio(String subDirectorio) {
        File carpetaActual = obtenerDirectorioActual();
        final String OS = System.getProperty("os.name").toLowerCase();
        boolean esWindowsOS = OS.contains("windows");
        List<File> listadoCarpetas = new ArrayList<>(Arrays.asList(Objects.requireNonNull(carpetaActual.listFiles(File::isDirectory))));
        boolean subdirectorioExiste = false;

        for (File file : listadoCarpetas) {
            if (file.getName().equals(subDirectorio)) {
                subdirectorioExiste = true;
            }
        }

        if (subdirectorioExiste) {
            System.out.println("El subdirectorio existe.");

            if (esWindowsOS) {
                subDirectorio = System.getProperty("user.dir") + "\\" +subDirectorio;
                System.out.println(subDirectorio);

            } else {
                subDirectorio = System.getProperty("user.dir") + "/" +subDirectorio;
            }
            System.setProperty("user.dir", subDirectorio);
            System.out.println("Cambiamos al directorio " + subDirectorio);
            imprimirDirectorioActual();
        } else {
            System.out.println("El subdirectorio NO existe.");
            System.out.println("No se ha ejecutado el comando.");
        }
    }

    private static void obtenerListadoCarpetasYFicheros() {
        File carpetaActual = obtenerDirectorioActual();
        File[] listadoCarpetasYFicheros = carpetaActual.listFiles();

        if (listadoCarpetasYFicheros != null){
            System.out.println("1 - Carpetas: ");
            for (File elemento : listadoCarpetasYFicheros)  {
                if (elemento.isDirectory()) {
                    System.out.println(elemento.getName());
                }
            }
            System.out.println("2 - Ficheros: ");
            for (File elemento : listadoCarpetasYFicheros)  {
                if (elemento.isFile()) {
                    System.out.println(elemento.getName());
                }
            }
        }
    }

}
