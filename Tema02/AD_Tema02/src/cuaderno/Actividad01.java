/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cuaderno;
import java.io.File;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
/**
 *
 * @author paula
 */
public class Actividad01 {
    /**
     * EJERCICIO 1
     * Crea un programa Java que lea el contenido de un fichero de texto y lo muestre por pantalla utilizando dos hilos.


        Un hilo será el encargado de leer el fichero y enviar su contenido al pipe.
        El otro hilo deberá recibir los datos del pipe y mostrarlos por pantalla.
        El programa deberá finalizar correctamente cuando se haya procesado todo el contenido del fichero.
* 
* 
* 
     * EJERCICIO 2
     * Crea un programa que realice una copia de un fichero utilizando dos hilos y un PipedInputStream / PipedOutputStream.

    El programa deberá:

        Leer un fichero de origen.
        Enviar su contenido mediante el pipe.
        Crear un fichero de destino con los datos recibidos.
        * 
        * FALTA ESTA PARTE!!!!!!!---------------------------------------------------
        Contar los caracteres procesados. EN EL CONSUMIDOR
        Contar las líneas procesadas.EN EL CONSUMIDOR
        Mostrar el tamaño del fichero de origen. (length()) EN EL MAIN
        Mostrar el tamaño del fichero de destino. (length()) EN EL MAIN
        Mostrar el número de caracteres y líneas procesados.

    El programa deberá utilizar correctamente los dos hilos y esperar a que ambos hayan terminado antes de mostrar el mensaje final.
     */
    
    public static void main(String[] args) {
        try {
            //INPUT PARTE DERECHA, OUTPUT PARTE IZQUIERDA
            //definicion de los ficheros
            File origen = new File ("C:\\DAM2\\AD\\Tema02\\datos\\origen.txt");
            File destino = new File ("C:\\DAM2\\AD\\Tema02\\datos\\destino.txt");
            
            //definicion de la entrada y aslida de las tuberias
            PipedOutputStream salida = new PipedOutputStream();
            PipedInputStream entrada = new PipedInputStream(salida);
            
            //PARTE DE LA IZQUIERDA (INPUT)
            Thread productor = new Thread(()->{
                try {
                    FileInputStream fichero = new FileInputStream(origen);
                    int dato;
                    while ((dato = fichero.read()) != -1){ //leer el fichero hasta llegar al final (cuando valga -1)
                        salida.write(dato);
                    }
                    fichero.close();
                    salida.close();
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }    
            });
            
            //PARTE DE LA DERECHA (OUTPUT)
             Thread consumidor = new Thread(()->{
                 try {
                    FileOutputStream fichero = new FileOutputStream(destino);
                    int dato;
                    while ((dato = entrada.read()) != -1){ //leer el fichero hasta llegar al final (cuando valga -1)
                        fichero.write(dato); //escribir en el fichero "dato" hasta que se termine
                    }
                   fichero.close();
                   entrada.close();
                 } catch (Exception ex) {
                     ex.printStackTrace();
                 }
                 });
             
               productor.start();
               consumidor.start();
               productor.join();
               consumidor.join();

            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
