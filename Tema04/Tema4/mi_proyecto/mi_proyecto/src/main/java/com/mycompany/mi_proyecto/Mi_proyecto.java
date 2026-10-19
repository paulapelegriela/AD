/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.mi_proyecto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author paula
 */
public class Mi_proyecto {

public static void main(String[] args) {
    
    String url ="jdbc:mysql://localhost:3307/AD";
    String usuario = "paula";
    String password ="paula123";
     
     
    try {
         
        Connection conexion = DriverManager.getConnection(
                url,
                usuario,
                password
        );
                
        System.out.println("CONEXIÓN CORRECTA");
        String sql = "SELECT id, nombre, email FROM usuarios";

        PreparedStatement ps = conexion.prepareStatement(sql);
        //Resultset → objeto que nos permite recorrer todos los tal de una tabla
        ResultSet rs = ps.executeQuery();
        //recorrer la función rs fila a fila
        while (rs.next()){
            int id = rs.getInt("id");
            String nombre = rs.getString("nombre");
            String email = rs.getString("email");            
            System.out.println(id + "-" + nombre + "-" + email);
        }

        conexion.close();
         
    } catch (SQLException e) {
         
        System.out.println("ERROR DE CONEXIÓN");
        e.getMessage();
     }
     
     
    }
}

