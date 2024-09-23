package SerializacionDeObjetos;

import org.iesalandalus.programacion.utilidades.Entrada;

import java.io.*;

public class EscribirFicherosObjetos {
    private static final String FICHERO = String.format("%s%s%s", "EjemplosFicheros", File.separator, "FicheroDeObjetos.txt");

    public static void main(String[] args) {
        escribirFicheroObjetos(FICHERO);
    }

    private static void escribirFicheroObjetos(String fichero) {
        try (ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream(fichero))) {
            do {
                System.out.print("Escriba el nombre de la persona: ");
                String nombre = Entrada.cadena();
                System.out.print("Escriba la edad de la persona: ");
                int edad = Entrada.entero();
                salida.writeObject(new Persona(nombre, edad));
                System.out.print("Si desea terminar de escribir objetos en el fichero. Escriba 'SI': ");
            }while (!Entrada.cadena().equals("SI"));
        } catch (FileNotFoundException e) {
            System.out.println("No se puede escribir en el fichero.");
        } catch (IOException e) {
            System.out.println("Error inesperado de Entrada/Salida.");
        }
    }
}
