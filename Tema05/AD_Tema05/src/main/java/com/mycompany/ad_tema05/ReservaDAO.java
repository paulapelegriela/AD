/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ad_tema05;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author paula
 */
public class ReservaDAO {
    
    private static final String url = "jdbc:postgresql://localhost:5432/reservas";
    private static final String user = "alumno";
    private static final String password =System.getenv("POSTGRES_PASSWORD");
    
    public static Connection conectar() throws SQLException{
        return DriverManager.getConnection(url, user, password);
    }
    
    //método para registrar las reservas
    public static boolean registrarReserva(String alumno, String aula, java.sql.Date fecha){
        String sql = "INSERT INTO reserva (alumno, aula, fecha) VALUES (?, ?, ?)";
        try (Connection con = conectar();
            PreparedStatement ps = con.prepareStatement(sql)){
                
            //ahora rellenamos los ??? de la consulta
            ps.setString(1, alumno);
            ps.setString(2, aula);
            ps.setDate(3, fecha);
            //y ejecutamos la consulta
            ps.executeUpdate();
                
            return true;
        } catch (SQLException e) {
            System.out.println("Error al registrar la reserva: " + e.getMessage());
            return false;
        }
    }

    //método para mostrar las reservas
    public static void mostrarReservas(){
        String sql = "SELECT * FROM reserva";
        try (Connection con = conectar();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()){
                
            boolean hayReservas = false;
            System.out.println("\n================================="); 
            System.out.println("\tTODAS LAS RESERVAS");
            System.out.println("================================="); 
            System.out.println("");
            
            while(rs.next()){
                hayReservas = true;
                System.out.println("ID: " + rs.getLong("id"));
                System.out.println("Alumno: " + rs.getString("alumno"));
                System.out.println("Aula: " + rs.getString("aula"));
                System.out.println("Fecha: " + rs.getDate("fecha"));                
                System.out.println("");
            }
            
            //mostramos un mensaje en caso de que no exista ninguna reserva
            if (!hayReservas) {
                System.out.println("No hay reservas registradas.");
            }
        } catch (SQLException e) {
            System.out.println("Error al mostrar las reservas: " + e.getMessage());
        }        
    }
    
    public static void buscarPorAula(String aula){
        String sql = "SELECT * FROM reserva WHERE aula = ?";
        try (Connection con = conectar();
            PreparedStatement ps = con.prepareStatement(sql)) {
            //sustituimos el interrogante
            ps.setString(1, aula);

            try (ResultSet rs = ps.executeQuery()) {
                boolean aulaEncontrada = false;
                System.out.println("\n================================="); 
                System.out.println("\tRESERVAS DEL AULA " + aula);
                System.out.println("================================="); 
                System.out.println("");
                                
                while (rs.next()) {
                    
                    aulaEncontrada = true;
                    System.out.println("ID: " + rs.getLong("id"));
                    System.out.println("Alumno: " + rs.getString("alumno"));
                    System.out.println("Aula: " + rs.getString("aula"));
                    System.out.println("Fecha: " + rs.getDate("fecha"));                
                    System.out.println("");    
                }//while
                
                if (!aulaEncontrada){
                    System.out.println("No se han encontrado reservas para esa aula.");
                    System.out.println("");
                }
            }//2ndo try
        
        } catch (SQLException e) {
            System.out.println("Error al buscar reservas: " + e.getMessage());
        }             
    }
    
    public static boolean eliminarReserva(long id){
        String sql = "DELETE FROM reserva WHERE id = ?";
        try (Connection conexion = conectar();
            PreparedStatement ps = conexion.prepareStatement(sql)) {
            //sustituimos el interrogante
            ps.setLong(1, id);
            
            int filas = ps.executeUpdate();            
            if (filas > 0){
                return true;
            } else{
                return false;
            }
            
        } catch (SQLException e) {
            System.out.println("Error al eliminar la reserva: " + e.getMessage());
            return false;
        }    
    }
}

