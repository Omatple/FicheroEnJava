package FicherosXML;

import SerializacionDeObjetos.Persona;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ConvertirFicheroObjetosEnXMLConAtributos {
    private static final String FICHERO_XML = String.format("%s%s%s", "EjemplosFicheros", File.separator, "Fichero_XML.xml");
    private static final String FICHERO_DE_OBJETOS = String.format("%s%s%s", "EjemplosFicheros", File.separator, "FicheroDeObjetos.txt");

    public static void main(String[] args) {
        convertirFicheroObjetosEnXMLConAtributos(FICHERO_DE_OBJETOS, FICHERO_XML);
    }

    private static void convertirFicheroObjetosEnXMLConAtributos(String ficheroObjetos, String ficheroXML) {
        List<Persona> listaPersonas = new ArrayList<>();
        try (ObjectInputStream entrada = new ObjectInputStream(new FileInputStream(ficheroObjetos))) {
            Persona persona;
            while ((persona = (Persona) entrada.readObject()) != null) {
                listaPersonas.add(persona);
            }
        } catch (FileNotFoundException e) {
            System.out.println("No se puede convertir el fichero.");
        } catch (EOFException ignored) {
            //MIRAR, PREGUNTAR SI ESTE CODIGO DENTRO DE LA CAPTURA DE LA EXCEPCION ES CORRECTO O SE DEBE HACER EN OTRO LUGAR
            DocumentBuilder constructor = UtilidadesXml.crearConstructorDocumentoXml();
            //DUDA, QUE HACE EL METODO CREARCONTR.. DE LA CLASE UTILI.. QUE VALOR SE LE ASIGNA.
            Document documentoXml;
            if (constructor != null) {
                documentoXml = constructor.newDocument();
                documentoXml.appendChild(documentoXml.createElement("personas"));
                for (Persona personaLista : listaPersonas) {
                    Element elementoPersona = crearElementoPersonaConAtributos(documentoXml, personaLista);
                    documentoXml.getDocumentElement().appendChild(elementoPersona);
                }
                UtilidadesXml.escribirDocumentoXml(documentoXml, ficheroXML);
            }
        } catch (ClassNotFoundException e) {
            System.out.println("No se puede trabajar con la clase.");
        } catch (IOException e) {
            System.out.println("Error inesperado de Entrada/Salida.");
        }
    }

    private static Element crearElementoPersonaConAtributos(Document documentoXml, Persona persona) {
        Element elementoPersona = documentoXml.createElement("persona");
        elementoPersona.setAttribute("nombre", persona.getNombre());
        elementoPersona.setAttribute("edad", String.format("%s", persona.getEdad()));
        return elementoPersona;
    }
}
