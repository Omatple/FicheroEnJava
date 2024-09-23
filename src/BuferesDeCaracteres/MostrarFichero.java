package BuferesDeCaracteres;

import java.io.*;

public class MostrarFichero {
    private static final String FICHERO = String.format("%s%s%s", "EjemplosFicheros", File.separator, "escritura.txt");

    public static void main(String[] args) {
        mostrarFicheroLinea();
        mostrarFicheroCaracter();
    }

    private static void mostrarFicheroLinea() {
        try (BufferedReader entrada = new BufferedReader(new FileReader(MostrarFichero.FICHERO))) {
            String linea;
            while ((linea = entrada.readLine()) != null) {
                System.out.printf("%s%n",linea);
            }
        } catch (FileNotFoundException e) {
            System.out.println("No es posible mostrar el fichero.");
        } catch (IOException e) {
            System.out.println("Error inesperado de Entrada/Salida.");
        }

    }

    private static void mostrarFicheroCaracter() {
        try (BufferedReader entrada = new BufferedReader(new FileReader(MostrarFichero.FICHERO))) {
            int dato;
            while ((dato = entrada.read()) != -1) {
                System.out.print((char)dato);
            }
        } catch (FileNotFoundException e) {
            System.out.println("No es posible mostrar el fichero.");
        } catch (IOException e) {
            System.out.println("Error inesperado de Entrada/Salida.");
        }
    }
}
