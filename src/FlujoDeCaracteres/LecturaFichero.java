package FlujoDeCaracteres;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class LecturaFichero {
    private static  final String FICHERO = String.format("%s%s%s", "EjemplosFicheros", File.separator, "escritura.txt");

    public static void main(String[] args) {
        leerFichero();
    }

    private static void leerFichero() {
        try (FileReader entrada = new FileReader(LecturaFichero.FICHERO)) {
            int dato;
            while (( dato = entrada.read()) != -1) {
                System.out.print((char) dato);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Este fichero no puede ser leído.");
        } catch (IOException e) {
            System.out.println("Error inesperado de Entrada/Salida");
        }
    }
}
