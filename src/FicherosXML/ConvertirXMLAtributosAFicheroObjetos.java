package FicherosXML;

import SerializacionDeObjetos.Persona;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ConvertirXMLAtributosAFicheroObjetos {
    private static final String FICHERO_XML = String.format("%s%s%s", "EjemplosFicheros", File.separator, "Fichero_XML.xml");
    private static final String FICHERO_OBJETOS = String.format("%s%s%s", "EjemplosFicheros", File.separator, "Fichero_Objetos.txt");

    public static void main(String[] args) {
        convertirXMLConAtributosAFicheroObjetos(FICHERO_XML, FICHERO_OBJETOS);
    }

    private static void convertirXMLConAtributosAFicheroObjetos(String ficheroXML, String ficheroObjetos) {
        List<Persona> listaPersonas = new ArrayList<>();
        Document documentoXml = UtilidadesXml.leerDocumentoXml(ficheroXML);
        if (documentoXml != null) {
            System.out.println("Documento XML leído con éxito.");
            NodeList personas = documentoXml.getElementsByTagName("persona");
            for (int i = 0; i < personas.getLength(); i++) {
                Node persona = personas.item(i);
                if (persona.getNodeType() == Node.ELEMENT_NODE) {
                    String nombre = ((Element) persona).getAttribute("nombre");
                    int edad = Integer.parseInt(((Element) persona).getAttribute("edad"));
                    listaPersonas.add(new Persona(nombre, edad));
                }
            }
        }
        try (ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream(ficheroObjetos))) {
            if (!listaPersonas.isEmpty()) {
                for (Persona persona : listaPersonas) {
                    salida.writeObject(persona);
                }
                System.out.println("Fichero de Objetos escrito con éxito.");
            }
        } catch (FileNotFoundException e) {
            System.out.println("No se puede leer el fichero.");
        } catch (IOException e) {
            System.out.println("Error inesperado de Entrada/Salida.");
        }
    }
}
