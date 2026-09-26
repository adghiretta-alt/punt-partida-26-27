package com.project;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PR112cat {

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("No s'ha proporcionat cap ruta d'arxiu.");
            return;
        }

        String rutaArxiu = args[0];
        mostrarContingutArxiu(rutaArxiu);
    }

    public static void mostrarContingutArxiu(String rutaArxiu) {

        Path path = Paths.get(rutaArxiu);

        try {
            if (!Files.exists(path)) {
                System.out.println("El fitxer no existeix o no és accessible.");
                return;
            }

            if (Files.isDirectory(path)) {
                System.out.println("El path no correspon a un arxiu, sinó a una carpeta.");
                return;
            }

            String contingut = Files.readString(path, StandardCharsets.UTF_8);
            System.out.print(contingut);

        } catch (IOException e) {
            System.out.println("El fitxer no existeix o no és accessible.");
        }
    }
}
