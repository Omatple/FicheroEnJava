package FicherosXML;

import SerializacionDeObjetos.Persona;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ConvertirFicheroXMLConElementosEnFicheroDeObjetos {
    private static final String FICHERO_XML_ELEMENTOS = String.format("%s%s%s", "EjemplosFicheros", File.separator, "Fichero_XML_Elementos.xml");
    private static final String FICHERO_OBJETOS = String.format("%s%s%s", "EjemplosFicheros", File.separator, "FicheroObjetos_ConversionElementos.txt");

    public static void main(String[] args) {
        convertirFicheroXMLConElementosEnFicheroDeObjetos(FICHERO_XML_ELEMENTOS, FICHERO_OBJETOS);
    }

    private static void convertirFicheroXMLConElementosEnFicheroDeObjetos(String ficheroXML, String ficheroObjetos) {
        List<Persona> listaPersonas = new ArrayList<>();
        Document documentoXml = UtilidadesXml.leerDocumentoXml(ficheroXML);
        NodeList personas = documentoXml.getElementsByTagName("persona");
        for (int i = 0; i < personas.getLength(); i++) {
            Node persona = personas.item(i);
            if (persona.getNodeType() == Node.ELEMENT_NODE) {
                String nombre = ((Element) persona).getElementsByTagName("nombre").item(0).getTextContent();
                int edad = Integer.parseInt(((Element) persona).getElementsByTagName("edad").item(0).getTextContent());
                listaPersonas.add(new Persona(nombre, edad));
            }
        }
        try (ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream(ficheroObjetos))) {
            for (Persona persona : listaPersonas) {
                salida.writeObject(persona);
            }
            System.out.println("Fichero escrito satisfactoriamente");
        } catch (FileNotFoundException e) {
            System.out.println("No es posible escribir le fichero.");
        } catch (IOException e) {
            System.out.println("Error inesperado de Entrada/Salida.");
        }
    }
}
