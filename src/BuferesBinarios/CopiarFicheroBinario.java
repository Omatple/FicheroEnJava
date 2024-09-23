package BuferesBinarios;

import java.io.*;

public class CopiarFicheroBinario {
    private static final String FICHERO_ORIGINAL = String.format("%s%s%s", "EjemplosFicheros", File.separator, "binario.bin");
    private static final String COPIA_FICHERO = String.format("%s%s%s", "EjemplosFicheros", File.separator, "copiaBinario.bin");

    public static void main(String[] args) {
        copiarBufferFicheroBinario();
    }

    private static void copiarBufferFicheroBinario() {
        try (BufferedInputStream entrada = new BufferedInputStream(new FileInputStream(FICHERO_ORIGINAL)); BufferedOutputStream salida = new BufferedOutputStream(new FileOutputStream(COPIA_FICHERO))) {
            int dato;
            while ((dato = entrada.read()) != -1) {
                salida.write(dato);
            }
            System.out.println("Fichero binario copiado con éxIto.");
        } catch (FileNotFoundException e) {
            System.out.println("El fichero no puede ser copiado.");
        } catch (IOException e) {
            System.out.println("Error inesperado de Entrada/Salida.");
        }
    }
}
