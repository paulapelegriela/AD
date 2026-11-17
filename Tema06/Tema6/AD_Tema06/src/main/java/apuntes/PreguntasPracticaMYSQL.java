/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package apuntes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author paula
 */

//ESTA CLASE ES PARA INTENTAR RESPONDER A LA MAYORIA DE PREGUNTAS QUE SE HARAN EN EL EXAMEN PERO USANDO JAVA
//mi objetivo es que me sirva para estudiar

public class PreguntasPracticaMYSQL {
    //TODO ESTO HAY Q APRENDERSELO DE MEMORIA
    private static final String url ="jdbc:mysql://localhost:3307/instituto";
    private static final String usuario = "paula";
    private static final  String password ="paula123";
    
    public static Connection conectar() throws SQLException{
        return DriverManager.getConnection(url, usuario, password);
    }
    
    /*Preguntas que pueden salir en el examen:
     * ¿Cuántas filas de datos hay?
     * ¿Cuántas columnas?
     * ¿Qué columna identifica de forma única a _? --- el que tenga PK
     * ¿Qué tipo de datos usarías para _? 
     * Escribe una consulta para mostrar todos los clientes --- select * from customers;
     * Mostrar sólo FIRST_NAME ---- select first_name from customers;
     * Mostrar sólo las edades sin repetir
     * Personas mayores de _ edad
     * Personas entre _ edad y _ edad
     * Personas que empiezan por la letra _
     * Clientes cuya edad no sean _
     * Clientes que tengan al menos _ años y se llamen _
     * Ordena las personas por edad
     * Ordena las personas por nombre
     * Añade una persona que se llame _ con edad _
     * Cambia la edad de _ a edad _
     * Borra la persona que tiene ID=1
     * Tmb hay preguntas de detectar errores
     * Escribe una secuencia que inicie una transacción que haga el cambio de edad del ID=1 a 40 y confirma el cambio
     */
    
    //¿Cuántas filas de datos hay?
    public static void numFilasDatos(){
        
        String sql = "SELECT COUNT(*) FROM customer";
    
        try (Connection con = conectar();
            PreparedStatement ps = con.prepareStatement(sql)){
        
            try(ResultSet rs = ps.executeQuery()){ //Ejecuta la consulta SQL y guarda los resultados en la variable rs para poder leerlos después
        
                while (rs.next()){
                    System.out.println("El número de filas de datos es: " + rs.getInt(1));
                }
            }       
        } catch (Exception e) {
             e.printStackTrace();
        }
    
        
    }
    //Mostrar sólo FIRST_NAME
    public static void mostrarFN(){
        
        //hacemos la consulta de sql y la guardamos en una variable de tipo string
        String sql = "SELECT first_name FROM customer";
        
        //abrimos la conexión y preparamos la consulta, como es un try al finalizar se cerraran los recursos automaticamente.
        try (Connection con = conectar();
            PreparedStatement ps = con.prepareStatement(sql)){
        
            try(ResultSet rs = ps.executeQuery()){ //Ejecuta la consulta SQL y guarda los resultados en la variable rs para poder leerlos después
               
                while (rs.next()) {  //el rs.next recorre todas las filas
                   
                    String nombre = rs.getString("first_name");  //obtenemos el valor de la columna first_name de la fila ACTUAL.
                    System.out.println(nombre);
                }
            }
            
        } catch (Exception e) {
             e.printStackTrace();
        }
    }
    
    
    
    public static void main(String[] args) {
        mostrarFN();
    }
}
