
package com.mycompany.mi_proyecto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Tema4pt3 {

    //TODO ESTO HAY Q APRENDERSELO DE MEMORIA
    private static final String url = "jdbc:mysql://localhost:3307/AD";
    private static final String usuario = "paula";
    private static final String password = "paula123";

    public static Connection conectar() throws SQLException {
        return DriverManager.getConnection(url, usuario, password);
    }
    //HASTA AQUI
    
    public static void buscarPorID(int id) {
        String sql = "SELECT * FROM empleados WHERE id = ?";

        try (Connection con = conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                System.out.println("id | nombre | departamento | salario | edad");

                while (rs.next()) {
                    int idEmpleado = rs.getInt("id");
                    String nombre = rs.getString("nombre");
                    String departamento = rs.getString("departamento");
                    double salario = rs.getDouble("salario");
                    int edad = rs.getInt("edad");

                    System.out.println(idEmpleado + " | " + nombre + " | "
                            + departamento + " | " + salario + " | " + edad);
                }//while
            }//2ndo try

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void actualizarSalario(int id, double salario) {
        String sql = "UPDATE empleados SET salario = ? WHERE id = ?";

        try (Connection con = conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setDouble(1, salario);
            ps.setInt(2, id);

            int filasActualizadas = ps.executeUpdate();

            if (filasActualizadas > 0) {
                System.out.println("Salario actualizado correctamente.");
            } else {
                System.out.println("No existe un empleado con ese ID.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        System.out.println("Listar el empleado cuyo id es 2");
        buscarPorID(2);
    }
}
