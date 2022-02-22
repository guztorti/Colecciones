/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package colecciones.entidades;

/**
 *
 * @author gustavotorti
 */
public class Raza {

     private String nombre;
     private String aplica;

     public Raza() {
     }

     public Raza(String nombre, String aplica) {
          this.nombre = nombre;
          this.aplica = aplica;
     }
     
     
     public String getNombre() {
          return nombre;
     }

     public void setNombre(String nombre) {
          this.nombre = nombre;
     }

     public String getAplica() {
          return aplica;
     }

     public void setAplica(String aplica) {
          this.aplica = aplica;
     }

     @Override
     public String toString() {
          return "Raza{" + nombre + ", " + aplica + '}';
     }
     
     
     
}
