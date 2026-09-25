package com.project;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class PR110ReadFile {

    public static void main(String[] args) {
        String camiFitxer = System.getProperty("user.dir") + "/data/GestioTasques.java";
        llegirIMostrarFitxer(camiFitxer);  
    }

    public static void llegirIMostrarFitxer(String camiFitxer) {

    try (BufferedReader br = new BufferedReader(new FileReader(camiFitxer))) {

        String linia = br.readLine();
        int numeroLinia = 1;

        while (linia != null) {
            System.out.println(numeroLinia + ": " + linia);
            numeroLinia++;

            linia = br.readLine();
        }

    } catch (IOException e) {
        System.out.println("Error en llegir el fitxer: " + camiFitxer);
    }
 }
}
