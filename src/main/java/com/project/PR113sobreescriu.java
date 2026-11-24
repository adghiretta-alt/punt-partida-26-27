package com.project;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class PR113sobreescriu {

    public static void main(String[] args) {

        // Ruta del fichero
        String camiFitxer =
                System.getProperty("user.dir")
                + "/data/frasesMatrix.txt";

        // Llamar al método que sobrescribe el archivo
        escriureFrases(camiFitxer);
    }

    /**
     * Escribe las frases en el fichero
     * reemplazando el contenido anterior.
     */
    public static void escriureFrases(String camiFitxer) {

        try (BufferedWriter writer =
                     new BufferedWriter(
                             new OutputStreamWriter(
                                     new FileOutputStream(
                                             camiFitxer,
                                             false // modo sobrescribir
                                     ),
                                     StandardCharsets.UTF_8))) {

            // Escribir la primera frase
            writer.write(
                    "I can only show you the door"
            );
            writer.newLine();

            // Escribir la segunda frase
            writer.write(
                    "You're the one that has to walk through it"
            );
            writer.newLine();

        } catch (IOException e) {

            // Mostrar error si ocurre algún problema
            e.printStackTrace();
        }
    }
}
