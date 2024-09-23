package FlujoBinarios;

import org.iesalandalus.programacion.utilidades.Entrada;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class MostrarFichero {
    private static final String FICHERO = String.format("%s%s%s", "EjemplosFicheros", File.separator, "binario.bin");

    public static void main(String[] args) {
        mostrarFicheroBinario();
    }

    // FALTA TRANSFOMARLO A TEXTO
    private static void mostrarFicheroBinario() {
        File ficheroEntrada = new File(MostrarFichero.FICHERO);
        try (FileInputStream entrada = new FileInputStream(ficheroEntrada)) {
            int dato;
            while ((dato = entrada.read()) != -1) {
                System.out.print((char) dato);
            }
        } catch (FileNotFoundException e) {
            System.out.println("No se puede mostrar el fichero.");
        } catch (IOException e) {
            System.out.println("Error inesperado de Entrada/Salida.");
        }
    }
}
