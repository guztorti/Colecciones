/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package __main;

import colecciones.entidades.Raza;
import colecciones.servicios.servicios;

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
          
          srv.ingresarRaza();
          System.out.println(srv.buscarRaza(new Raza("dogo","perro"))?"encontrada":"perdida");
     }
     
}
