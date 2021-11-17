package es.sergiomendez;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Directorio {
    static void obtenerListadoContenido(String tipo) {
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

    static File obtenerDirectorioActual() {
        String directorioActual = System.getProperty("user.dir");

        return new File(directorioActual);
    }

    static void cambiarElDirectorio(String nuevoDirectorio) {
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

    static String obtenerFechaCreacion(File elemento) {
        Path archivo = Paths.get(elemento.getAbsolutePath());
        try {
            BasicFileAttributes atributos = Files.readAttributes(archivo, BasicFileAttributes.class);
            return atributos.creationTime().toString();
        } catch (IOException e) {
            return "No se ha encontrado el archivo";
        }
    }

    static void imprimirDirectorioActual() {
        File carpetaActual = obtenerDirectorioActual();

        System.out.println("Directorio actual: " + carpetaActual);
    }
}
