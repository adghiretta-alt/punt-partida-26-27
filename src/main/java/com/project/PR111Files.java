package com.project;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class PR111Files {

    public static void main(String[] args) {

        // Ruta del directorio donde se trabajará
        String camiDirectori =
                System.getProperty("user.dir")
                + "/data/pr111";

        // Llamar al método que gestiona los archivos
        gestionarArxius(camiDirectori);
    }

    /**
     * Crea, renombra, elimina y muestra archivos
     * dentro de la carpeta myFiles.
     */
    public static void gestionarArxius(String camiDirectori) {

        // Ruta de la carpeta myFiles
        Path carpetaMyFiles =
                Paths.get(camiDirectori, "myFiles");

        try {

            // 1. Crear la carpeta myFiles si no existe
            Files.createDirectories(carpetaMyFiles);

            // 2. Crear los archivos file1.txt y file2.txt
            Path file1 =
                    carpetaMyFiles.resolve("file1.txt");

            Path file2 =
                    carpetaMyFiles.resolve("file2.txt");

            Files.createFile(file1);
            Files.createFile(file2);

            // 3. Mostrar los archivos existentes
            System.out.println(
                    "Els arxius de la carpeta són:"
            );

            try (DirectoryStream<Path> stream =
                         Files.newDirectoryStream(carpetaMyFiles)) {

                // Recorrer y mostrar cada archivo
                for (Path p : stream) {
                    System.out.println(
                            " - " + p.getFileName()
                    );
                }
            }

            // 4. Renombrar file2.txt a renamedFile.txt
            Path renamed =
                    carpetaMyFiles.resolve(
                            "renamedFile.txt"
                    );

            Files.move(
                    file2,
                    renamed,
                    StandardCopyOption.REPLACE_EXISTING
            );

            // 5. Eliminar file1.txt
            Files.deleteIfExists(file1);

            // 6. Mostrar los archivos finales
            System.out.println(
                    "Els arxius de la carpeta són:"
            );

            try (DirectoryStream<Path> stream =
                         Files.newDirectoryStream(carpetaMyFiles)) {

                // Recorrer y mostrar cada archivo
                for (Path p : stream) {
                    System.out.println(
                            " - " + p.getFileName()
                    );
                }
            }

        } catch (IOException e) {

            // Mostrar mensaje si ocurre algún error
            System.err.println(
                    "Error gestionant els arxius: "
                    + e.getMessage()
            );
        }
    }
}
