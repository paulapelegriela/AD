/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package teoria;
import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
        
/**
 *
 * @author paula
 */
public class StreamPipes {
    public static void main(String[] args) {
    
    try{
        PipedOutputStream salida = new PipedOutputStream();
        PipedInputStream entrada = new PipedInputStream(salida);
        
         //creamos una clase anonima
        Thread productor = new Thread(()->{
            try {
                salida.write("Mensaje 1\n".getBytes()); //escribimos en salida y se pasa de string a bytes con el get
                Thread.sleep(3000);
                salida.write("Mensaje 2\n".getBytes());
                Thread.sleep(3000);
                salida.write("Mensaje 3\n".getBytes());
                Thread.sleep(3000);

                salida.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }); //clase anonima productor
        
        Thread consumidor = new Thread(()->{
            try {
        int dato;
        int caracteres = 0;
        int numMensajes = 0;
        while ((dato = entrada.read()) != -1){ //la funcion read es bloqueante, epera a que termine el thread
        System.out.print((char)dato);
        caracteres++;
        if (dato=='\n'){
            numMensajes++;
        }
    }    
        System.out.println("Num de mensajes: " + numMensajes);
        System.out.println("Num de caracteres: " + caracteres);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }); //clase anonima consumidor
        
        //iniciar las clases anonimas
        productor.start();
        consumidor.start();
        productor.join();
        consumidor.join();
        


        entrada.close();
        
} catch (Exception ex) {
        ex.printStackTrace();
    }
     }//main
}//class

//modificarlo para que la escritura del anonimo sea salida.write("Mensaje 1\n",getBytes()); 2 y 3
//luego mostrar la salida + num de mensajes recibidos (contando los n de \n) + num de caracteres (EN EL MAIN) 

//crear un hilo que se llame lector y al final poner productor.join() consumidor.join()