/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package Test;

import Teoria.AlumnosXML;
import Teoria.ApuntesTest;
import Teoria.TiendaXML;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

/**
 *
 * @author paula
 */
public class Tema3Test {
    
    private TiendaXML tienda;
    private Document document;
    private AlumnosXML alumnos;
    
    public Tema3Test() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach //se ejecuta siempre antes de cada test
    public void setUp() throws Exception{
        alumnos = new AlumnosXML();
        document = alumnos.cargaXML();
        
        
    }
    
    @AfterEach
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
    //los test deben tener un nombre MUY especifico
    
    @Test
    public void sumarTest(){
        ApuntesTest t = new ApuntesTest();
        assertEquals(5, t.sumar(2, 3));
    }
    
    @Test
    public void comprobarNumeroDeProductosTest() throws Exception{
        NodeList nombres = tienda.obtenerNombres(document);
        assertEquals(3, nombres.getLength());
    }
    
    @Test
    public void comprobarPrimerAlumnoPepito() throws Exception{
        NodeList nombres = alumnos.obtenerNombres(document);
        assertEquals("Pepito", nombres.item(0).getTextContent());
    }
}
