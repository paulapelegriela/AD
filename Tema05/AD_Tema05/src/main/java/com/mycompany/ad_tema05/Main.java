/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ad_tema05;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author paula
 */
public class Main {
    
    public static void main(String[] args) {  
    
    Scanner sc = new Scanner(System.in);
    int opcion;
    boolean salir = false;
        
    while (!salir){
        System.out.println("================================="); 
        System.out.println("\tGESTOR DE RESERVAS");
        System.out.println("================================="); 
        System.out.println("");
        System.out.println("1. Registrar una reserva"); 
        System.out.println("2. Mostrar todas las reservas");
        System.out.println("3. Buscar reservas por aula");
        System.out.println("4. Eliminar una reserva");
        System.out.println("0. Salir");
        System.out.println("");
        System.out.print("Selecciona una opción: ");
        //validar que el dato introducido sea uno numerico
        try {
            opcion = Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Debes introducir un número.");
            continue;
        }
        
        switch (opcion){
            case 1:
                System.out.println("================================="); 
                System.out.println("\tREGISTRAR UNA RESERVA");
                System.out.println("================================="); 
                System.out.println("");
                //nombre
                System.out.print("Nombre del alumno --> ");
                String alumno = sc.nextLine();
                //aula
                System.out.print("Aula --> ");
                String aula = sc.nextLine();
                //fecha
                System.out.print("Fecha (en formato AAAA-MM-DD) --> ");
                String fechaTexto = sc.nextLine();
                //validar que no haya ningun campo vacio
                if (alumno.isBlank() || aula.isBlank() || fechaTexto.isBlank()) {
                    System.out.println("Todos los campos son obligatorios.");
                    break;
                }
                
                try {
                    java.sql.Date fecha = java.sql.Date.valueOf(fechaTexto);
                    boolean reservaRegistrada = ReservaDAO.registrarReserva(alumno, aula, fecha);
                    if (reservaRegistrada){
                        System.out.println("La reserva ha sido registrada con éxito!");
                    }
                } catch (IllegalArgumentException e) {
                    System.out.println("El formato de fecha es incorrecto. Utilice AAAA-MM-DD");
                }
                break;
            
            case 2:
                ReservaDAO.mostrarReservas();
                break;
                
            case 3:
                System.out.print("Introduce el aula que deseas buscar: ");
                
                String aulaBuscar = sc.nextLine();
                ReservaDAO.buscarPorAula(aulaBuscar);
                break;
                
            case 4:
                System.out.print("Introduce el ID de la reserva que deseas eliminar: ");
                long id;
                //validar que se añade un id y no una letra
                    try {
                        id = Long.parseLong(sc.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Debes introducir un identificador numérico.");
                        break;
                    }
                boolean reservaEliminada = ReservaDAO.eliminarReserva(id);
                if(reservaEliminada){
                    System.out.println("La reserva se ha eliminado correctamente.");
                    System.out.println("");
                } else{
                    System.out.println("No se ha encontrado ninguna reserva registrada con ese ID.");
                    System.out.println("");
                }
                break;
        
            case 0:
                salir = true;
                System.out.println("Saliendo del gestor de reservas...");
                break;
                
            default:
                System.out.println("Opción no válida, por favor inténtelo de nuevo.");
                break;
        }//switch
    }//while
    sc.close();
    
    }
}
