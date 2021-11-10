package es.sergiomendez;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String nombreIntrodcido;
        NombrePorCampos nombrePorCampos;

        do {

            System.out.println("Introduce tu nombre completo:");
            nombreIntrodcido = scanner.nextLine();

        } while (Objects.equals(nombreIntrodcido, ""));

        System.out.println("Nombre completo introducido: " + nombreIntrodcido);

        nombrePorCampos = devolverNombrePorCampos(nombreIntrodcido);
        String nombrePila = nombrePorCampos.getNombre();
        String apellido1 = nombrePorCampos.getApellido1();
        String apellido2 = nombrePorCampos.getApellido2();

        System.out.println("""
                
                Nombre por campos:
                ------------------""");
        
        System.out.println("Nombre: " + nombrePila);

        if (!Objects.equals(apellido1, null)) {

            System.out.println("Apellido 1: " + apellido1);

        }

        if (!Objects.equals(apellido2, null)) {

            System.out.println("Apellido 2: " + apellido2);
        }

    }

    private static NombrePorCampos devolverNombrePorCampos(String nombreCompleto) {

        String[] nombreLista = nombreCompleto.split(" ");
        StringBuilder nombrePila = new StringBuilder();
        ArrayList<String> apellidos = new ArrayList<>();

        for (int i = 0; i < nombreLista.length; i++) {

            if (i == 0) {

                nombrePila.append(nombreLista[i]);

            } else {

                if (Nombres.NOMBRES.contains(nombreLista[i])) {

                    nombrePila.append(" ").append(nombreLista[i]);

                } else {

                    apellidos.add(nombreLista[i]);

                }

            }

        }

        if (apellidos.size() == 0) {

            return new NombrePorCampos(nombrePila.toString());

        } else if (apellidos.size() == 1) {

            return new NombrePorCampos(nombrePila.toString(), apellidos.get(0));

        }

        return new NombrePorCampos(nombrePila.toString(), apellidos.get(0), apellidos.get(1));
    }

}
