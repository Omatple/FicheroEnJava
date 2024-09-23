package FicherosCSV;

import java.io.*;

public class LeerFicheroCSV {
    private static final String FICHERO_CSV = String.format("%s%s%s", "EjemplosFicheros", File.separator, "Fichero_CSV.csv");
    private static final String SEPARADOR = ",";

    public static void main(String[] args) {
        leerFicheroCSV(FICHERO_CSV);
    }

    private static void leerFicheroCSV(String fichero) {
        try (BufferedReader entrada = new BufferedReader(new FileReader(fichero))) {
            String linea;
            int contador = 0;
            while ((linea = entrada.readLine()) != null) {
                String[] campos = linea.split(SEPARADOR);
                System.out.printf("Persona %s >> Nombre: %s, Edad: %s%n", ++contador, campos[0], campos[1]);
            }
            System.out.println("Fichero leído con éxito.");
        } catch (FileNotFoundException e) {
            System.out.println("No se puede leer el fichero.");
        } catch (IOException e) {
            System.out.println("Error inesperado de Entrada/Salida.");
        }
    }
}
