/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tema01;

/**
 *
 * @author paula
 */
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.FileWriter;

public class Teoria {

    public static void main(String[] args) throws IOException {
        /**
        //PRIMER EJEMPLO EN CLASE
        //Instanciar el archivo
        File f = new File("/DAM2/AD/Tema01/archivo.txt");
        
        //Crearlo si no existe
        if (!f.exists()){
            f.createNewFile();
        }
        
        //Ejemplos sueltos en clase
        System.out.println("El archivo se llama: " + f.getName());
        System.out.println("El archivo esta alojado en: " + f.getPath());
        System.out.println("El archivo existe: " + f.exists());
        System.out.println("El archivo puede ser escrito: " + f.canWrite());
        
        
        //ACCESO A UN ARCHIVO MEDIANTE BYTES --> USO DE INPUT
        FileInputStream e = new FileInputStream("/DAM2/AD/Tema01/archivo.txt");
        int dato = e.read();
        System.out.println("El primer dato es: " + (char)dato); //se hace un cast porq esta en ASCII
        e.close(); //SIEMPRE se cierra un input o un output.
        
        
        //ACCESO A UN ARCHIVO MEDIANTE CARACTERES 
        FileWriter escritor = new FileWriter("/DAM2/AD/Tema01/archivo.txt", true); //crear un append para la sobreescritura
        escritor.write("Adios Mundo");
        escritor.close();
        */
        
        //LEER VARIOS BYTES CON UN PUNTERO
        FileInputStream f = new FileInputStream("/DAM2/AD/Tema01/archivo.txt");
        byte[] buffer = new byte [5];
        int cantidad = f.read(buffer);
        for (int i=0; i<cantidad; i++){
            System.out.println((char)buffer[i]);
        }
        
    }
    
}
