package com.project;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class PR113append {

    public static void main(String[] args) {
        String camiFitxer = System.getProperty("user.dir") + "/data/frasesMatrix.txt";

        afegirFrases(camiFitxer);
    }

    public static void afegirFrases(String camiFitxer) {
        try (BufferedWriter writer = new BufferedWriter(
                new OutputStreamWriter(
                        new FileOutputStream(camiFitxer, true),
                        StandardCharsets.UTF_8))) {

            writer.write("I can only show you the door");
            writer.newLine();

            writer.write("You're the one that has to walk through it");
            writer.newLine();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
