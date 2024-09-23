package SerializacionDeObjetos;

import java.io.*;

public class LeerFicherosObjetos {
    private static final String FICHERO = String.format("%s%s%s", "EjemplosFicheros", File.separator, "FicheroObjetos_ConversionElementos.txt");

    public static void main(String[] args) {
        leerFicheroObjetos(FICHERO);
    }

    private static void leerFicheroObjetos(String fichero) {
        try (ObjectInputStream entrada = new ObjectInputStream(new FileInputStream(fichero))) {
            Persona persona;
            int contador = 0;
            while ((persona = (Persona) entrada.readObject()) != null) {
                System.out.printf("Persona %s >> Nombre: %s, Edad: %s%n", ++contador, persona.getNombre(), persona.getEdad());
            }
        } catch (FileNotFoundException e) {
            System.out.println("No es posible leer el fichero.");
        } catch (EOFException e) {
            System.out.println("Fichero leído con éxito.");
        } catch (IOException e) {
            System.out.println("Error inesperado de Entrada/Salida.");
        } catch (ClassNotFoundException e) {
            System.out.println("El fichero no ha sido encontrado.");
        }
    }
}
