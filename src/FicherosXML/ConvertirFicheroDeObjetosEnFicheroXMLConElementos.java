package FicherosXML;

import SerializacionDeObjetos.Persona;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ConvertirFicheroDeObjetosEnFicheroXMLConElementos {
    private static final String FICHERO_XML_ELEMENTOS = String.format("%s%s%s", "EjemplosFicheros", File.separator, "Fichero_XML_Elementos.xml");
    private static final String FICHERO_OBJETOS = String.format("%s%s%s", "EjemplosFicheros", File.separator, "Fichero_Objetos.txt");

    public static void main(String[] args) {
convertirFicheroDeObjetosEnFicheroXMLConElementos(FICHERO_OBJETOS, FICHERO_XML_ELEMENTOS);
    }

    private static void convertirFicheroDeObjetosEnFicheroXMLConElementos(String ficheroObjetos, String ficheroXML) {
        List<Persona> listaPersonas = new ArrayList<>();
        try (ObjectInputStream entrada = new ObjectInputStream(new FileInputStream(ficheroObjetos))) {
            Persona persona;
            while ((persona = (Persona) entrada.readObject()) != null) {
                listaPersonas.add(persona);
            }
        } catch (FileNotFoundException e) {
            System.out.println("No se puede leer el fichero.");
        } catch (EOFException ignored) {
            DocumentBuilder constructor = UtilidadesXml.crearConstructorDocumentoXml();
            Document documentoXml;
            if (constructor != null) {
                documentoXml = constructor.newDocument();
                documentoXml.appendChild(documentoXml.createElement("personas"));
                for(Persona persona: listaPersonas){
                    Element elementoPersona = elementosParaElNodoPersonas(documentoXml, persona);
                    documentoXml.getDocumentElement().appendChild(elementoPersona);
                }
                UtilidadesXml.escribirDocumentoXml(documentoXml, ficheroXML);
                System.out.println("Fichero convertido con éxito.");
            }
        } catch (IOException e) {
            System.out.println("Error inesperado de Entrada/Salida.");
        } catch (ClassNotFoundException e) {
            System.out.println("No se puede leer la clase del fichero.");
        }
    }

    private static Element elementosParaElNodoPersonas(Document documentoXml, Persona persona) {
        Element elementoPersona = documentoXml.createElement("persona");
        Element elementoNombre = documentoXml.createElement("nombre");
        Element elementoEdad = documentoXml.createElement("edad");
        elementoNombre.setTextContent(persona.getNombre());
        elementoEdad.setTextContent(String.format("%s", persona.getEdad()));
        elementoPersona.appendChild(elementoNombre);
        elementoPersona.appendChild(elementoEdad);
        return elementoPersona;
    }
}
