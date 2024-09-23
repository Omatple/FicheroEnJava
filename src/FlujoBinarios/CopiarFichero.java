package FlujoBinarios;

import java.io.*;

public class CopiarFichero {
    private static final String FICHERO_ORIGINAL = String.format("%s%s%s", "EjemplosFicheros", File.separator, "binario.bin");
    private static final String COPIA_FICHERO = String.format("%s%s%s", "EjemplosFicheros", File.separator, "copiaBinario.bin");

    public static void main(String[] args) {
        copiarFicheroBinario();
    }

    private static void copiarFicheroBinario() {
        try (FileInputStream entrada = new FileInputStream(CopiarFichero.FICHERO_ORIGINAL); FileOutputStream salida = new FileOutputStream(CopiarFichero.COPIA_FICHERO)) {
            int dato;
            while ((dato = entrada.read()) != -1) {
                salida.write(dato);
            }
            System.out.println("Fichero binario copiado con éxito.");
        } catch (FileNotFoundException e) {
            System.out.println("El fichero no puede ser copiado.");
        } catch (IOException e) {
            System.out.println("Error inesperado de Entrada/Salida.");
        }
    }
}