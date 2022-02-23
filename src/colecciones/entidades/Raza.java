/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package colecciones.entidades;

import java.util.Objects;

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

     @Override
     public int hashCode() {
          int hash = 3;
          hash = 41 * hash + Objects.hashCode(this.nombre);
          hash = 41 * hash + Objects.hashCode(this.aplica);
          return hash;
     }

     @Override
     public boolean equals(Object obj) {
          if (this == obj) {
               return true;
          }
          if (obj == null) {
               return false;
          }
          if (getClass() != obj.getClass()) {
               return false;
          }
          final Raza other = (Raza) obj;
          if (!Objects.equals(this.nombre, other.nombre)) {
               return false;
          }
          if (!Objects.equals(this.aplica, other.aplica)) {
               return false;
          }
          return true;
     }


     
     
     
}
