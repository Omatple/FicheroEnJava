package FicherosCSV;

import org.iesalandalus.programacion.utilidades.Entrada;

import java.io.*;

public class EscribirFicheroCSV {
    private static final String FICHERO_CSV = String.format("%s%s%s", "EjemplosFicheros", File.separator, "Fichero_CSV.csv");
    private static final String SEPARADOR = ",";

    public static void main(String[] args) {
        escribirFicheroCSV(FICHERO_CSV);
    }

    private static void escribirFicheroCSV(String fichero) {
        try (BufferedWriter salida = new BufferedWriter(new FileWriter(fichero))) {
            do {
                System.out.print("Escriba el nombre de la persona: ");
                salida.write(String.format("%s%s", Entrada.cadena(), SEPARADOR));
                System.out.print("Escriba la edad de la persona: ");
                salida.write(String.format("%s%n", Entrada.entero()));
                System.out.print("Si desea dejar de escribir en el fichero introduzca 'SI': ");
            } while (!Entrada.cadena().equals("SI"));
        } catch (FileNotFoundException e) {
            System.out.println("No se puede escribir en el fichero.");
        } catch (IOException e) {
            System.out.println("Error inesperado de Entrada/Salida.");
        }
    }
}
