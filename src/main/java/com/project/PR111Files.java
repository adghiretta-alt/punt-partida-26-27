package com.project;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class PR111Files {

    public static void main(String[] args) {
        String camiDirectori = System.getProperty("user.dir") + "/data/pr111";
        gestionarArxius(camiDirectori);
    }

    public static void gestionarArxius(String camiDirectori) {

        Path carpetaMyFiles = Paths.get(camiDirectori, "myFiles");

        try {
            // 1. Crear carpeta myFiles 
            Files.createDirectories(carpetaMyFiles);

            // 2. Crear file1.txt i file2.txt
            Path file1 = carpetaMyFiles.resolve("file1.txt");
            Path file2 = carpetaMyFiles.resolve("file2.txt");

            Files.createFile(file1);
            Files.createFile(file2);

            // 3. Mostrar llistat inicial
            System.out.println("Els arxius de la carpeta són:");
            try (DirectoryStream<Path> stream = Files.newDirectoryStream(carpetaMyFiles)) {
                for (Path p : stream) {
                    System.out.println(" - " + p.getFileName());
                }
            }

            // 4. Renombrar file2.txt a renamedFile.txt
            Path renamed = carpetaMyFiles.resolve("renamedFile.txt");
            Files.move(file2, renamed, StandardCopyOption.REPLACE_EXISTING);

            // 5. Eliminar file1.txt
            Files.deleteIfExists(file1);

            // 6. Mostrar llistat final
            System.out.println("Els arxius de la carpeta són:");
            try (DirectoryStream<Path> stream = Files.newDirectoryStream(carpetaMyFiles)) {
                for (Path p : stream) {
                    System.out.println(" - " + p.getFileName());
                }
            }

        } catch (IOException e) {
            System.err.println("Error gestionant els arxius: " + e.getMessage());
        }
    }
}
