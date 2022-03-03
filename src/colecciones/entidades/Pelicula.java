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
public class Pelicula {

     private String titulo;
     private String director;
     private double duracion;

     public Pelicula() {
     }

     public Pelicula(String titulo, String director, double duracion) {
          this.titulo = titulo;
          this.director = director;
          this.duracion = duracion;
     }

     public String getTitulo() {
          return titulo;
     }

     public void setTitulo(String titulo) {
          this.titulo = titulo;
     }

     public String getDirector() {
          return director;
     }

     public void setDirector(String director) {
          this.director = director;
     }

     public double getDuracion() {
          return duracion;
     }

     public void setDuracion(double duracion) {
          this.duracion = duracion;
     }

     @Override
     public String toString() {
          int horas = (int) duracion;
          int minutos = (int)(((duracion - horas)/100*60)*100);
          String salDuracion = "";
          if (horas==0) {
               salDuracion = minutos + " minutos";
          } else {
               salDuracion = horas +" horas , "+minutos + " minutos";
          }
          return "Pelicula{" + "título= " + titulo + ", director= " + director + ", duración= " + salDuracion + '}';
     }

     @Override
     public int hashCode() {
          int hash = 5;
          hash = 19 * hash + Objects.hashCode(this.titulo);
          hash = 19 * hash + Objects.hashCode(this.director);
          hash = 19 * hash + (int) (Double.doubleToLongBits(this.duracion) ^ (Double.doubleToLongBits(this.duracion) >>> 32));
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
          final Pelicula other = (Pelicula) obj;
          if (Double.doubleToLongBits(this.duracion) != Double.doubleToLongBits(other.duracion)) {
               return false;
          }
          if (!Objects.equals(this.titulo, other.titulo)) {
               return false;
          }
          return Objects.equals(this.director, other.director);
     }
     
}
