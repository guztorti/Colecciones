/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package colecciones.entidades;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;

/**
 *
 * @author gustavotorti
 */
public class Alumno {

     private String nombre;
     private ArrayList<Integer> notas = new ArrayList();

     public Alumno(String nombre) {
          this.nombre = nombre;
     }

     public String getNombre() {
          return nombre;
     }

     public void setNombre(String nombre) {
          this.nombre = nombre;
     }

     public ArrayList<Integer> getNotas() {
          return notas;
     }

     public void setNotas(ArrayList<Integer> notas) {
          this.notas = notas;
     }

     @Override
     public int hashCode() {
          int hash = 7;
          hash = 71 * hash + Objects.hashCode(this.nombre);
          hash = 71 * hash + Objects.hashCode(this.notas);
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
          final Alumno other = (Alumno) obj;
          if (!Objects.equals(this.nombre, other.nombre)) {
               return false;
          }
          if (!Objects.equals(this.notas, other.notas)) {
               return false;
          }
          return true;
     }

     @Override
     public String toString() {
          Iterator itr = notas.iterator();
          String evaluaciones = ", Notas: [";
          while (itr.hasNext()){
               if (itr.hasNext()) {
                    evaluaciones += itr.next() +", ";
               }
          }
          evaluaciones = evaluaciones.substring(0, (evaluaciones.length()-2))+"]";
          return "Alumno{" + "nombre=" + nombre + evaluaciones+ '}';
     }
     
     public double notaFinal(){
          Iterator<Integer> itr = notas.iterator();
          double acumulador = 0;
          while (itr.hasNext()){
               acumulador += itr.next();
          }
          return acumulador/notas.size();
     }
     
}
