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
public class Cantante {

     private String nombre, discoConMasVentas;

     public Cantante(String nombre, String discoConMasVentas) {
          this.nombre = nombre;
          this.discoConMasVentas = discoConMasVentas;
     }

     public Cantante() {
     }

     public String getNombre() {
          return nombre;
     }

     public void setNombre(String nombre) {
          this.nombre = nombre;
     }

     public String getDiscoConMasVentas() {
          return discoConMasVentas;
     }

     public void setDiscoConMasVentas(String discoConMasVentas) {
          this.discoConMasVentas = discoConMasVentas;
     }

     @Override
     public int hashCode() {
          int hash = 3;
          hash = 29 * hash + Objects.hashCode(this.nombre);
          hash = 29 * hash + Objects.hashCode(this.discoConMasVentas);
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
          final Cantante other = (Cantante) obj;
          if (!Objects.equals(this.nombre, other.nombre)) {
               return false;
          }
          return Objects.equals(this.discoConMasVentas, other.discoConMasVentas);
     }

     @Override
     public String toString() {
          return "Cantante Famoso{"+ nombre + ", disco más vendido=" + discoConMasVentas + '}';
     }
     
}
