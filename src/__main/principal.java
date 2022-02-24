/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package __main;

import colecciones.entidades.Alumno;
import colecciones.entidades.Raza;
import colecciones.servicios.servicios;
import java.util.Scanner;

/**
 *
 * @author gustavotorti
 */
public class principal {

     /**
      * @param args the command line arguments
      */
     public static void main(String[] args) {
          // TODO code application logic here
          
          servicios srv = new servicios();
          Scanner scn = new Scanner(System.in).useDelimiter("\n");
          
          srv.ingresarRaza();
          System.out.println(srv.buscarRaza(new Raza("dogo","perro"))?"encontrada":"perdida");
          
          //proceso de crear un alumno
          char otro = 'n';
          do {
               Alumno alumno = srv.crearAlumno();
               alumno.setNotas(srv.cargarNotas(alumno.getNombre()));
               System.out.println("¿Desea ingresar otro alumno? ");
               do {                    
                    System.out.println("debe ingresar \"Si\"/\"No\"");
                    otro = scn.next().toLowerCase().charAt(0);
               } while (otro != 's' || otro != 'n');
          } while (otro != 'n');
          
     }
     
}
