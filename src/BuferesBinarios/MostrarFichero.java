package BuferesBinarios;

import java.io.*;

public class MostrarFichero {
    private static final String FICHERO = String.format("%s%s%s", "EjemplosFicheros", File.separator, "binario.bin");

    public static void main(String[] args) {
        mostrarFichero();
    }

    private static void mostrarFichero(){
        try(BufferedInputStream entrada = new BufferedInputStream(new FileInputStream(MostrarFichero.FICHERO))){
            int dato;
            while((dato = entrada.read()) != -1){
                System.out.print(dato);
            }
        }catch(FileNotFoundException e){
            System.out.println("El fichero no se puede mostrar.");
        }catch (IOException e){
            System.out.println("Error inesperado de Entrada/Salida");
        }
    }
}
