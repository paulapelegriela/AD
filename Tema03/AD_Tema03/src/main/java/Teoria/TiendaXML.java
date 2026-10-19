/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Teoria;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

/**
 *
 * @author paula
 */
public class TiendaXML {
    //cargar el archivo con DOM
    public Document cargaXML() throws Exception {
        //esto coge el XML, crea un artefacto q lee el XML y procede a leerlo para luego devolverlo en un objeto document.
        
        //crear el puntero al archivo XML
        File archivo = new File("tienda.xml");
        
        //Creamos la factoría del lector de DOM (Jesus dice q no hay que saberselo de memoria)
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        
        //Creamos el objeto que va a leer el DOM
        DocumentBuilder builder = factory.newDocumentBuilder();
        
        //Java lee el XML y cre el arbol de DOM
        Document document = builder.parse(archivo);
        
        //Devolvemos
        return document;
    }
    
    //El tipo de valor que devolvera, es un nodelist
    public NodeList obtenerNombres(Document document) throws Exception{
        //Creamos la factoría para usar xpath
        //lo siguiente nos da todas las finciones q nos ofrfece xpath
        XPath xpath=XPathFactory.newInstance().newXPath();
        //¡¡¡¡CUANDO SE UTILICE SOLO HAY QUE CAMBIAR LA EXPRESION Y EL ARCHIVO XML DESEADP!!!!
        String expresion = "/tienda/producto/nombre";
        NodeList nombres = (NodeList) xpath.evaluate(expresion,document,XPathConstants.NODESET); //ultimo parametro: espera q el resultado sea un conjunto de nodos
        /* nombres:
        nombres
        |--- [0] <nombre>Teclado</nombre> item 0
        |--- [1] <nombre>Ratón</nombre> item 1
        |--- [2] <nombre>Monitor</nombre> item 2
        */
        return nombres;
    }
}
