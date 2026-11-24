package com.project;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class PR110ReadFile {

    public static void main(String[] args) {

        // Ruta del fichero que se quiere leer
        String camiFitxer =
                System.getProperty("user.dir")
                + "/data/GestioTasques.java";

        // Llamar al método para leer y mostrar el contenido
        llegirIMostrarFitxer(camiFitxer);
    }

    /**
     * Lee un fichero de texto y muestra su contenido
     * por pantalla junto con el número de línea.
     */
    public static void llegirIMostrarFitxer(String camiFitxer) {

        try (BufferedReader br =
                     new BufferedReader(
                             new FileReader(camiFitxer))) {

            // Leer la primera línea del fichero
            String linia = br.readLine();

            // Contador de líneas
            int numeroLinia = 1;

            // Continuar mientras existan líneas por leer
            while (linia != null) {

                // Mostrar número de línea y contenido
                System.out.println(
                        numeroLinia + ": " + linia
                );

                // Incrementar contador
                numeroLinia++;

                // Leer la siguiente línea
                linia = br.readLine();
            }

        } catch (IOException e) {

            // Mostrar mensaje si ocurre algún error de lectura
            System.out.println(
                    "Error en llegir el fitxer: "
                    + camiFitxer
            );
        }
    }
}
