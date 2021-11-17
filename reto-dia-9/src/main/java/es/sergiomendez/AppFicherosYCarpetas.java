package es.sergiomendez;

import java.util.Scanner;

public class AppFicherosYCarpetas {
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
                Comando.comprobarComando(comando);
            }

        } while (runApp);

        System.out.println("Tecla \"Enter\" pulsada.\nFinalizando la aplicación. ¡Hasta pronto!");
        scanner.close();
    }
}
