package com.project;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PR112cat {

    public static void main(String[] args) {

        // Comprobar que se ha proporcionado una ruta
        if (args.length == 0) {

            System.out.println(
                    "No s'ha proporcionat cap ruta d'arxiu."
            );

            return;
        }

        // Obtener la ruta del archivo desde la línea de comandos
        String rutaArxiu = args[0];

        // Mostrar el contenido del archivo
        mostrarContingutArxiu(rutaArxiu);
    }

    /**
     * Muestra el contenido de un archivo de texto.
     */
    public static void mostrarContingutArxiu(String rutaArxiu) {

        // Convertir la ruta a un objeto Path
        Path path = Paths.get(rutaArxiu);

        try {

            // Comprobar si el archivo existe
            if (!Files.exists(path)) {

                System.out.println(
                        "El fitxer no existeix o no és accessible."
                );

                return;
            }

            // Comprobar que no sea una carpeta
            if (Files.isDirectory(path)) {

                System.out.println(
                        "El path no correspon a un arxiu, sinó a una carpeta."
                );

                return;
            }

            // Leer todo el contenido del archivo en UTF-8
            String contingut =
                    Files.readString(
                            path,
                            StandardCharsets.UTF_8
                    );

            // Mostrar el contenido por pantalla
            System.out.print(contingut);

        } catch (IOException e) {

            // Mostrar mensaje si ocurre algún error de lectura
            System.out.println(
                    "El fitxer no existeix o no és accessible."
            );
        }
    }
}
