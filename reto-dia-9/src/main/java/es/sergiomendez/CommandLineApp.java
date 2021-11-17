package es.sergiomendez;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;

public class CommandLineApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean runApp = true;

        System.out.println("Bienvenido a la aplicación de ficheros y directorios.");
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

        System.out.println("Tecla \"Enter\" pulsada.\nFinalizando la aplicación. ¡Hasta pronto!");
        scanner.close();
    }

    private static void comprobarComando(String comando) {
        ArrayList<String> comandosValidos = new ArrayList<>(Arrays.asList("ls", "cd", "pwd"));
        String[] terminosComando = comando.split(" ");
        String primerTermino = terminosComando[0];

        if (comandosValidos.contains(primerTermino)) {
            System.out.println("\nComando introducido: " + primerTermino);
            switch (primerTermino) {
                case "ls" -> {
                    if (terminosComando.length == 1) {
                        obtenerListadoContenido("normal");
                        break;
                    } else if (terminosComando.length == 2 && terminosComando[1].equals("-l")) {
                        obtenerListadoContenido("extendida");
                        break;
                    }
                    System.out.println("SubComandos excesivos y/o no válidos");

                }
                case "cd" -> {
                    if (terminosComando.length == 2) {
                        String subdirectorio = terminosComando[1];
                        System.out.println("Subdirectorio: " + subdirectorio);
                        cambiarAlSubdirectorio(subdirectorio);
                        break;
                    }
                    System.out.println("Número de argumentos incorrecto, " +
                            "sólo puede haber un subdirectorio y no puede estar vacío");
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

    private static void cambiarAlSubdirectorio(String nuevoDirectorio) {
        File carpetaActual = obtenerDirectorioActual();
        final String OS = System.getProperty("os.name").toLowerCase();
        boolean esWindowsOS = OS.contains("windows");
        List<File> listadoCarpetas = new ArrayList<>(Arrays.asList(Objects
                .requireNonNull(carpetaActual.listFiles(File::isDirectory))));
        boolean directorioExiste = false;

        if (Objects.equals(nuevoDirectorio, "..")) {
            if (esWindowsOS) {
                ejecutarCambioDirectorio("\\");
            } else {
                ejecutarCambioDirectorio("/");
            }
        } else {
            for (File file : listadoCarpetas) {
                if (file.getName().equals(nuevoDirectorio)) {
                    directorioExiste = true;
                }
            }

            if (directorioExiste) {
                System.out.println("El subdirectorio existe.");

                if (esWindowsOS) {
                    nuevoDirectorio = System.getProperty("user.dir") + "\\" + nuevoDirectorio;
                    System.out.println(nuevoDirectorio);

                } else {
                    nuevoDirectorio = System.getProperty("user.dir") + "/" + nuevoDirectorio;
                }
                ejecutarCambioDirectorio(nuevoDirectorio);
            } else {
                System.out.println("El subdirectorio NO existe.");
                System.out.println("No se ha ejecutado el comando.");
            }
        }
    }

    private static void ejecutarCambioDirectorio(String directorio) {
        System.setProperty("user.dir", directorio);
        if (directorio.equals("/") || directorio.equals("\\") ) {
            System.out.println("Cambiamos al directorio raíz");
        } else {
            System.out.println("Cambiamos al directorio " + directorio);
        }
        imprimirDirectorioActual();
    }

    private static void obtenerListadoContenido(String tipo) {
        File carpetaActual = obtenerDirectorioActual();
        File[] listadoContenido = carpetaActual.listFiles();

        if (listadoContenido != null){
            System.out.println("\nContenido: ");
            if (tipo.equals("extendida")) {
                for (File elemento : listadoContenido)  {
                    if (elemento.isDirectory()) {
                        System.out.println("Nombre: " + elemento.getName()
                                + " \t\t\tTamaño en bytes: " + elemento.length()
                                + " \t\tFecha de creación: " + obtenerFechaCreacion(elemento));
                    } else {
                        System.out.println("Nombre: " + elemento.getName()
                                + " \t\tTamaño en bytes: " + elemento.length()
                                + " \t\tFecha de creación: " + obtenerFechaCreacion(elemento));
                    }
                }
            } else {
                for (File elemento : listadoContenido) {
                    System.out.print(elemento.getName() + " ");
                }
            }

            System.out.println();
        }
    }

    private static String obtenerFechaCreacion(File elemento) {
        Path archivo = Paths.get(elemento.getAbsolutePath());
        try {
            BasicFileAttributes atributos = Files.readAttributes(archivo, BasicFileAttributes.class);
            return atributos.creationTime().toString();
        } catch (IOException e) {
            return "No se ha encontrado el archivo";
        }
    }
}
