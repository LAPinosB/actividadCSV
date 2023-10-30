package javaapplication52;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author luis
 */
public class JavaApplication52 {

    public static void main(String[] args) {
        File file = new File("alumnosNotas.txt");
        FileReader lector = null;
        BufferedReader buffer = null;
        try {
            if (file.exists()) {
                buffer = new BufferedReader(new FileReader(file));
                String linea = null;
                String nombre = "";
                float media = 0.0F;
                float suma = 0.0F;
                int veces = 0;
                while ((linea = buffer.readLine()) != null){
                    //System.out.println(linea);
                    String[] partes = linea.split(":");
                    if(partes.length >= 4){
                       nombre = partes[0];
                       //System.out.println(partes[0]);
                    }
                    for(int i = 1; i < partes.length; i++){
                        int numero = Integer.parseInt(partes[i]);
                        //System.out.println(partes[i]);
                        suma += numero;
                        veces++;
                    }
                    media = suma/veces;
                    System.out.println("El alumn@ "+nombre+" tiene una media de: "+media+" Y esta: "+ (media >= 5 ? "Aprobado" : "Suspenso"));
                    //System.out.println(suma);
                    //System.out.println(veces);
                    //System.console()
                    
                    //Reustaramos el valor a 0. para que la media no se acumule a la total.
                    suma = 0;
                    veces = 0;
                }
                
                
            }else{
                System.out.println("El archivo no existe");
            }
        } catch (FileNotFoundException fnfe) {
            fnfe.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } finally {
            if (buffer != null)
            try {
                buffer.close();
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
            }

        }

    }
