package DatosPrimitivos;

import org.iesalandalus.programacion.utilidades.Entrada;

import java.io.*;

public class LeerFichero {
    private static final String FICHERO = String.format("%s%s%s", "EjemplosFicheros", File.separator, "FicheroPrimitivo.txt");

    public static void main(String[] args) {
        try (FileOutputStream salida = new FileOutputStream(FICHERO)) {
            escribirFicheroPrimario(salida);
            FileInputStream entrada = new FileInputStream(FICHERO);
            leerFicheroPrimario(entrada);
        } catch (FileNotFoundException e) {
            System.out.println("No es posible escribir en el fichero.");
        } catch (IOException e) {
            System.out.println("Error inesperado dde Entrada/Salida.");
        }
    }

    private static void escribirFicheroPrimario(FileOutputStream fichero) {
        try (DataOutputStream salida = new DataOutputStream(fichero)) {
            do {
                System.out.print("Escriba una cadena: ");
                salida.writeUTF(Entrada.cadena());
                System.out.print("Escriba un número entero: ");
                salida.writeInt(Entrada.entero());
                System.out.print("Escriba un número real: ");
                salida.writeDouble(Entrada.realDoble());
                System.out.print("Escriba 'SI' si desea terminar de escribir y proceder a leerlo: ");
            } while (!(Entrada.cadena()).equals("SI"));
        } catch (FileNotFoundException e) {
            System.out.println("No es posible escribir en el fichero.");
        } catch (IOException e) {
            System.out.println("Error inesperado de Entrada/Salida.");
        }
    }

    private static void leerFicheroPrimario(FileInputStream fichero) {
        try (DataInputStream entrada = new DataInputStream(fichero)) {
            boolean fin = false;
            int contador = 0;
            while (!fin) {
                try {
                    System.out.printf("Linea %s >> Cadena: %s, Entero: %s, Real: %s%n", ++contador, entrada.readUTF(), entrada.readInt(), entrada.readDouble());
                } catch (EOFException e) {
                    System.out.println("Fin del fichero.");
                    fin = true;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("No se puede copiar el fichero.");
        } catch (IOException e) {
            System.out.println("Error inesperado de entrada salida.");
        }
    }
}
