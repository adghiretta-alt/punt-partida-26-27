package com.project;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;

public class PR114linies {

    public static void main(String[] args) {
        String camiFitxer = System.getProperty("user.dir") + "/data/numeros.txt";

        generarNumerosAleatoris(camiFitxer);
    }

    public static void generarNumerosAleatoris(String camiFitxer) {
        try {
            Path path = Paths.get(camiFitxer);

            Random random = new Random();
            StringBuilder contingut = new StringBuilder();

            for (int i = 0; i < 10; i++) {
                int numero = random.nextInt(100);
                contingut.append(numero);

                if (i < 9) {
                    contingut.append("\n");
                }
            }

            Files.writeString(
                    path,
                    contingut.toString(),
                    StandardCharsets.UTF_8
            );

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
