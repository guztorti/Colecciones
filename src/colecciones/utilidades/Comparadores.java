/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package colecciones.utilidades;

import colecciones.entidades.Raza;
import java.util.Comparator;

/**
 *
 * @author gustavotorti
 */
public class Comparadores {

     public static Comparator<Raza> ordenarPorNombreDesc = new Comparator<Raza>(){
          @Override
          public int compare(Raza o1, Raza o2) {
               return o2.getNombre().compareTo(o1.getNombre());
          }
          
     };
}
