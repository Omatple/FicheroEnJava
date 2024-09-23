package FlujoDeCaracteres;

import org.iesalandalus.programacion.utilidades.Entrada;

import java.io.*;

public class EscrituraFichero {
    private static  final String FICHERO = String.format("%s%s%s", "EjemplosFicheros", File.separator, "escritura.txt");

    public static void main(String[] args) {
        escribirFichero();
    }

    private static void escribirFichero() {
        try (FileWriter salida = new FileWriter(EscrituraFichero.FICHERO)) {
            String dato;
            while (!(dato = Entrada.cadena()).equals("|")) {
                salida.write(String.format("%s%n", dato));
            }
        } catch (FileNotFoundException e) {
            System.out.println("No se puede escribir el fichero de salida.");
        } catch (IOException e) {
            System.out.println("Error inesperado de Entrada/Salida.");
        }
    }
}