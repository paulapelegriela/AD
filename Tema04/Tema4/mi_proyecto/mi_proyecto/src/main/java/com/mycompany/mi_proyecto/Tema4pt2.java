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
public class Tema4pt2 {
    
    //TODO ESTO HAY Q APRENDERSELO DE MEMORIA
    private static final String url ="jdbc:mysql://localhost:3307/AD";
    private static final String usuario = "paula";
    private static final  String password ="paula123";
    
    public static Connection conectar() throws SQLException{
        return DriverManager.getConnection(url, usuario, password);
    }
    //HASTA AQUÍ

    public static void listarEmpleados(){
        String sql = "SELECT * FROM empleados";
        try{
            Connection con = conectar();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            System.out.println("id | nombre | departamento | salario | edad");

        while (rs.next()){
            int id = rs.getInt("id");
            String nombre = rs.getString("nombre");
            String departamento = rs.getString("departamento");  
            double salario = rs.getDouble("salario");
            int edad = rs.getInt("edad");
            System.out.println(id + " | " + nombre + " | " + departamento + " | " + salario + " | " + edad);   
        }//while
        con.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
        
    }//metodo
public static void main(String[] args) {
    System.out.println("Listar todos los empleados");
    listarEmpleados();
    }//mains
}

