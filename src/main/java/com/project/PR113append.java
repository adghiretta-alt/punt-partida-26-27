package com.project;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class PR113append {

    public static void main(String[] args) {

        // Ruta del fichero donde se añadirán las frases
        String camiFitxer =
                System.getProperty("user.dir")
                + "/data/frasesMatrix.txt";

        // Llamar al método que añade las frases
        afegirFrases(camiFitxer);
    }

    /**
     * Añade texto al final del fichero sin borrar
     * el contenido existente.
     */
    public static void afegirFrases(String camiFitxer) {

        try (BufferedWriter writer =
                     new BufferedWriter(
                             new OutputStreamWriter(
                                     new FileOutputStream(
                                             camiFitxer,
                                             true // modo append
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

            // Mostrar error si falla la escritura
            e.printStackTrace();
        }
    }
}
