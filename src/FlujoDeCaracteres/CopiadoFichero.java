package FlujoDeCaracteres;

import java.io.*;

public class CopiadoFichero {
    private static final String FIHERO_ORIGINAL = String.format("%s%s%s", "EjemplosFicheros", File.separator, "escritura.txt");
    private static final String COPIA_FICHERO = String.format("%s%s%s", "EjemplosFicheros", File.separator, "ficheroCopiado.txt");

    public static void main(String[] args) {
        copiarFichero();
    }

    private static void copiarFichero() {
        try (FileReader entradaOriginal = new FileReader(CopiadoFichero.FIHERO_ORIGINAL); FileWriter salidaCopiada = new FileWriter(CopiadoFichero.COPIA_FICHERO)) {
            int dato;
            while ((dato = entradaOriginal.read()) != -1) {
                    salidaCopiada.write((char) dato);
            }
            System.out.println("Fichero copiado con éxito.");
        } catch (FileNotFoundException e) {
            System.out.println("Este fichero no puede ser copiado.");
        } catch (IOException e) {
            System.out.println("Error inesperado de Entrada/Salida");
        }
    }
}
