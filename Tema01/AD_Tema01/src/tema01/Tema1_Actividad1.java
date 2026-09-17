

package tema01;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;
import java.io.IOException;

/**
 *
 * @author Jesús Guillén Encinas
 */
public class Tema1_Actividad1 {

   public static void main(String[] args) throws IOException {

        /*
         * ============================================================
         * TEMA 1 - INTRODUCCIÓN AL MANEJO DE FICHEROS
         * ACCESO A DATOS - EJERCICIOS
         * ============================================================
         *
         * INSTRUCCIONES:
         * - Completa cada apartado donde aparece TODO.
         * - No borres los enunciados.
         * - Puedes crear variables y código auxiliar dentro de cada apartado.
         *
         * CONTENIDOS:
         * 1. Clase File
         * 2. Información de un fichero
         * 3. Crear directorios y mover ficheros
         * 4. FileWriter
         * 5. FileReader
         * 6. Acceso secuencial o aleatorio
         * 7. FileInputStream / FileOutputStream
         * 8. RandomAccessFile
         * 9. Ejercicio Final
         */

        // ============================================================
        // EJERCICIO 1 - CREAR UN FICHERO
        // ============================================================

        /*
         * Crea un programa que:
         *
         * 1. Cree un objeto File asociado al fichero "datos.txt".
         * 2. Compruebe si el fichero existe.
         * 3. Si no existe, créalo.
         * 4. Muestra por pantalla el nombre del fichero.
         */

        // TODO: EJERCICIO 1
        // Escribe aquí tu solución.

        //Instanciar el archivo
        File f = new File("/DAM2/AD/Tema01/datos.txt");
        
        //Crearlo si no existe
        if (!f.exists()){
            f.createNewFile();}
        
        //nombre del fichero
        System.out.println("El archivo se llama: " + f.getName());

        // ============================================================
        // EJERCICIO 2 - INFORMACIÓN DEL FICHERO
        // ============================================================

        /*
         * Utilizando un objeto File asociado a "datos.txt",
         * muestra por pantalla:
         *
         * - Nombre del fichero.
         * - Ruta.
         * - Ruta absoluta.
         * - Directorio padre.
         * - Si existe.
         * - Si se puede leer.
         * - Si se puede escribir.
         */

        // TODO: EJERCICIO 2
        // Escribe aquí tu solución.

        System.out.println("El archivo se llama: " + f.getName());
        System.out.println("La ruta del archivo es: " + f.getPath());
        System.out.println("La ruta absoluta del archivo es: " + f.getAbsolutePath());
        System.out.println("El directorio padre es: " + f.getParent());
        System.out.println("El archivo existe? " + f.exists());
        System.out.println("Se puede leer? " + f.canRead());
        System.out.println("Se puede escribir? " + f.canWrite());

        // ============================================================
        // EJERCICIO 3 - CREAR DIRECTORIO Y MOVER UN FICHERO
        // ============================================================

        /*
         * Tenemos un fichero llamado "datos.txt".
         *
         * El programa debe:
         *
         * 1. Crear un directorio llamado "backup".
         * 2. Comprobar que el directorio existe.
         * 3. Mover "datos.txt" dentro de "backup".
         *
         * Resultado final:
         *
         * backup/
         *     datos.txt
         */

        // TODO: EJERCICIO 3
        // Escribe aquí tu solución.
            
        File dir = new File("/DAM2/AD/Tema01/backup");
        File destino = new File("/DAM2/AD/Tema01/backup/datos.txt");
        if (!dir.exists()){
            dir.mkdirs();
        }
        System.out.println("El directorio existe? " + dir.exists());
        f.renameTo(destino);

        // ============================================================
        // EJERCICIO 4 - ESCRIBIR TEXTO CON FileWriter
        // ============================================================

        /*
         * Crea un fichero llamado "alumnos.txt" y escribe dentro:
         *
         * Juan
         * María
         * Pedro
         * Ana
         *
         * Debes utilizar FileWriter.
         *
         * Recuerda:
         * - Instanciar FileWriter.
         * - Utilizar write().
         * - Cerrar el flujo.
         */

        // TODO: EJERCICIO 4
        // Escribe aquí tu solución.
        
        FileWriter escritor = new FileWriter("/DAM2/AD/Tema01/alumnos.txt", true);
                escritor.write("Juan\nMaría\nPedro\nAna\n");
                escritor.close();
        // ============================================================
        // EJERCICIO 5 - LEER UN CARÁCTER CON FileReader
        // ============================================================

        /*
         * Crea previamente un fichero llamado "mensaje.txt" que contenga:
         *
         * Hola
         *
         * Utiliza FileReader para:
         *
         * 1. Abrir el fichero.
         * 2. Leer el primer carácter mediante read().
         * 3. Mostrarlo por pantalla.
         * 4. Cerrar el lector.
         *
         * Resultado esperado:
         * H
         */

        // TODO: EJERCICIO 5
        // Escribe aquí tu solución.

        FileWriter ej5 = new FileWriter("/DAM2/AD/Tema01/mensaje.txt", true);
                ej5.write("Hola");
                ej5.close();
        
        FileReader lector = new FileReader("/DAM2/AD/Tema01/mensaje.txt");
	int dato = lector.read();
	      System.out.println((char)dato);
	lector.close();
 
        
                
        // ============================================================
        // EJERCICIO 6 - ¿ACCESO SECUENCIAL O ALEATORIO?
        // ============================================================

        /*
         * Para cada situación indica si utilizarías:
         *
         *     ACCESO SECUENCIAL
         *     o
         *     ACCESO ALEATORIO / DIRECTO
         *
         * y explica brevemente por qué.
         *
         * A) Tenemos un fichero con 500 nombres y queremos mostrar
         *    todos los nombres desde el primero hasta el último.
         *
         * B) Tenemos un fichero enorme y queremos acceder directamente
         *    a una posición concreta.
         *
         * C) Queremos recorrer un fichero de texto completo y copiar
         *    su contenido a otro fichero.
         *
         * D) Queremos modificar información situada en una posición
         *    concreta del fichero.
         *
         * E) Queremos leer un fichero de texto completo.
         *
         * Recuerda:
         *
         * - Secuencial: recorremos la información en orden.
         * - Aleatorio/directo: podemos posicionarnos directamente
         *   en una posición concreta.
         */

        // TODO: EJERCICIO 6
        // Escribe tus respuestas aquí mediante comentarios.
        //
        // A)Secuencial ya que es recorrer todo el archivo y es mucho más comodo.
        // B)Aleatorio/directo ya que al querer ir a una posición en concreto, con un RandomAccessFile y un seek elegimos la posicion en concreto.
        // C)Al no querer solo una parte del fichero, con un acceso secuencial nos iria mejor.
        // D)Con aleatorio/directo, ya que podemos elegir especificamente cual posicion del archivo queremos modificar.
        // E)Si queremos leer el fichero completo se usará el acceso secuencial.


        // ============================================================
        // EJERCICIO 7 - LECTURA DE BYTES
        // ============================================================

        /*
         * Crea un fichero llamado "bytes.txt" que contenga algún texto.
         *
         * Utiliza FileInputStream para:
         *
         * 1. Abrir el fichero.
         * 2. Leer un byte utilizando read().
         * 3. Mostrar por pantalla el valor obtenido.
         * 4. Cerrar el flujo.
         *
         */

        // TODO: EJERCICIO 7
        // Escribe aquí tu solución.

        

        // ============================================================
        // EJERCICIO 8 - ESCRITURA DE BYTES
        // ============================================================

        /*
         * Utiliza FileOutputStream para crear/escribir el fichero:
         *
         * "salidaBytes.txt"
         *
         * Escribe mediante write() el valor 68.
         *
         * Recuerda que 68 es la letra 'D' en ASCII.
         *
         * Después cierra el flujo.
         */

        // TODO: EJERCICIO 8
        // Escribe aquí tu solución.


        // ============================================================
        // EJERCICIO 9 - RandomAccessFile
        // ============================================================

        /*
         * Crea un fichero llamado "letras.txt" que contenga:
         *
         * ABCDEFGHIJ
         *
         * Utiliza RandomAccessFile para:
         *
         * 1. Abrir el fichero en modo "rw".
         * 2. Situarte en la posición 5 mediante seek().
         * 3. Leer el carácter que hay en esa posición.
         * 4. Mostrarlo por pantalla.
         * 5. Mostrar también la posición actual del puntero.
         *
         * Resultado esperado:
         *
         * F 6
         *
         */

        // TODO: EJERCICIO 9
        // Escribe aquí tu solución.


        // ============================================================
        // EJERCICIO 10 - ESCRIBIR CON RandomAccessFile
        // ============================================================

        /*
         * Utiliza el fichero "letras.txt" del ejercicio anterior.
         *
         * 1. Abre el fichero con RandomAccessFile en modo "rw".
         * 2. Coloca el puntero en la posición 5.
         * 3. Escribe el byte correspondiente a la letra 'D'
         *    utilizando write().
         * 4. Cierra el fichero.
         *
         * Comprueba después cómo ha quedado el contenido del fichero.
         *
         */

        // TODO: EJERCICIO 10
        // Escribe aquí tu solución.

        // ============================================================
        // EJERCICIO 11 - LEER VARIOS BYTES
        // ============================================================

        /*
         * Utiliza RandomAccessFile con un fichero que contenga texto.
         *
         * Crea un array de bytes de tamaño 10.
         *
         * Utiliza read(byte[], inicio, cantidad) para leer varios
         * bytes del fichero y almacenarlos en el array.
         *
         * Finalmente muestra cuántos bytes se han leído.
         *
         */

        // TODO: EJERCICIO 11
        // Escribe aquí tu solución.

        // ============================================================
        // EJERCICIO 12 - Ejercicio FINAL: GESTOR DE FICHEROS
        // ============================================================

        /*
         * Crea un pequeño gestor de ficheros.
         *
         * El programa debe gestionar un fichero llamado:
         *
         * alumnos.txt
         *
         * Debe realizar las siguientes operaciones:
         *
         * 1. Crear el fichero si no existe.
         *
         * 2. Mostrar:
         *    - Nombre.
         *    - Ruta.
         *    - Ruta absoluta.
         *    - Si existe.
         *    - Si se puede leer.
         *    - Si se puede escribir.
         *
         * 3. Escribir en el fichero:
         *
         *    Juan
         *    Ana
         *    Pedro
         *    Laura
         *
         *    Utiliza FileWriter.
         *
         * 4. Utilizar FileReader para leer el primer carácter
         *    y mostrarlo por pantalla.
         *
         * 5. Crear un directorio llamado "backup".
         *
         * 6. Mover el fichero a:
         *
         *    backup/alumnos.txt
         *
         * 7. Mostrar la fecha de última modificación utilizando
         *    lastModified().
         *
         * IMPORTANTE:
         * Recuerda cerrar los flujos de lectura y escritura
         * utilizando close().
         *
         */

        // TODO: Ejercicio FINAL
        // Escribe aquí tu solución completa.


    }
}
