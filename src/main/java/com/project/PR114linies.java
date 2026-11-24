package com.project;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;

public class PR114linies {

    public static void main(String[] args) {

        // Ruta del fichero donde se guardarán los números
        String camiFitxer =
                System.getProperty("user.dir")
                + "/data/numeros.txt";

        // Generar y guardar números aleatorios
        generarNumerosAleatoris(camiFitxer);
    }

    /**
     * Genera 10 números aleatorios y los guarda
     * en un fichero, uno por línea.
     */
    public static void generarNumerosAleatoris(
            String camiFitxer) {

        try {

            // Crear la ruta del fichero
            Path path = Paths.get(camiFitxer);

            // Generador de números aleatorios
            Random random = new Random();

            // Almacenará todo el contenido a escribir
            StringBuilder contingut =
                    new StringBuilder();

            // Generar 10 números aleatorios
            for (int i = 0; i < 10; i++) {

                int numero =
                        random.nextInt(100);

                // Añadir el número al texto
                contingut.append(numero);

                // Añadir salto de línea excepto en el último número
                if (i < 9) {
                    contingut.append("\n");
                }
            }

            // Escribir el contenido en el fichero
            Files.writeString(
                    path,
                    contingut.toString(),
                    StandardCharsets.UTF_8
            );

        } catch (IOException e) {

            // Mostrar error si falla la escritura
            e.printStackTrace();
        }
    }
}
