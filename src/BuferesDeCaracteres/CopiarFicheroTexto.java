package BuferesDeCaracteres;

import java.io.*;

public class CopiarFicheroTexto {
    private static final String FICHERO_ORIGINAL = String.format("%s%s%s", "EjemplosFicheros", File.separator, "escritura.txt");
    private static final String FICHERO_COPIA = String.format("%s%s%s", "EjemplosFicheros", File.separator, "ficheroCopiado.txt");

    public static void main(String[] args) {
        copiarFichero();
    }

    private static void copiarFichero() {
        try (BufferedReader entrada = new BufferedReader(new FileReader(CopiarFicheroTexto.FICHERO_ORIGINAL)); BufferedWriter salida = new BufferedWriter(new FileWriter(CopiarFicheroTexto.FICHERO_COPIA))) {
            String linea;
            while ((linea = entrada.readLine()) != null) {
                salida.write(String.format("%s%n", linea));
            }
            System.out.println("Fichero copiado con éxito.");
        } catch (FileNotFoundException e) {
            System.out.println("No es posible copiar el fichero.");
        } catch (IOException e) {
            System.out.println("Error inesperado de Entrada/Salida.");
        }
    }
}
