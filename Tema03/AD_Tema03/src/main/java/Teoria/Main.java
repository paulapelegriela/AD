/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Teoria;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

/**
 *
 * @author paula
 */
public class Main {
    public static void main(String[] args) {
        try {
            //Inicializamos un objeto nuevo de tipo TiendaXML
            //TiendaXML tienda = new TiendaXML();
            //Document document = tienda.cargaXML();
            //NodeList nombres = tienda.obtenerNombres(document);
            AlumnosXML alumno = new AlumnosXML();
            Document document = alumno.cargaXML();
            NodeList nombres = alumno.obtenerNombres(document);
                    //APUNTES
                    //Para sacar cada uno de los elementos/items de un nodelist usamos .item(n) , .getTextContent() 
                    //Para sacar la longitud usamos .getLenght()
            
            //Imprimir cada uno de los nombres:
            //for (int i = 0; i < nombres.getLength(); i++)
            
            System.out.println(nombres.item(0).getTextContent());
        } catch (Exception e) {
        }
    }
}
