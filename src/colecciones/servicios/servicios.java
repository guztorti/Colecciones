/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package colecciones.servicios;

import colecciones.entidades.Raza;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author gustavotorti
 */
public class servicios {
     private Scanner scn;
     ArrayList<Raza> razas ;

     public servicios() {
          this.scn = new Scanner(System.in).useDelimiter("\n");
          razas = new ArrayList();
     }
     

     public Raza definirRaza(){
          System.out.println("Ingrese el nombre de la raza");
          String nombre = scn.next();
          System.out.println("Ingrese a que animal pertenece");
          String aplica = scn.next();
          return new Raza(nombre, aplica);
     }
     
     public int ingresarRaza(){
          char salir = 'n';
          do {               
               System.out.println("desea ingresar una nueva Raza? \'Si\'\\\'No\' ");
               salir = scn.next().toLowerCase().charAt(0);
               if (salir == 's') {
                    razas.add(definirRaza());
               }
          } while (salir!='n');
          
          for (Raza raza : razas) {
               System.out.println(raza);
          }
          return 1;
     }
}
