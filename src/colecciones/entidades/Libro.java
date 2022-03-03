/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package colecciones.entidades;

/**
 *
 * @author gustavotorti
 */
public class Libro {

     private String titulo, autor;
     private int numEjemplares, numEjempPrestados;

     public Libro() {
     }

     public Libro(String titulo, String autor, int numEjemplares, int numEjempPrestados) {
          this.titulo = titulo;
          this.autor = autor;
          this.numEjemplares = numEjemplares;
          this.numEjempPrestados = numEjempPrestados;
     }
     
     public Libro(String titulo, String autor, int numEjemplares) {
          this.titulo = titulo;
          this.autor = autor;
          this.numEjemplares = numEjemplares;
     }

     public String getTitulo() {
          return titulo;
     }

     public void setTitulo(String titulo) {
          this.titulo = titulo;
     }

     public String getAutor() {
          return autor;
     }

     public void setAutor(String autor) {
          this.autor = autor;
     }

     public int getNumEjemplares() {
          return numEjemplares;
     }

     public void setNumEjemplares(int numEjemplares) {
          this.numEjemplares = numEjemplares;
     }

     public int getNumEjempPrestados() {
          return numEjempPrestados;
     }

     public void setNumEjempPrestados(int numEjempPrestados) {
          this.numEjempPrestados = numEjempPrestados;
     }

     @Override
     public String toString() {
          return "Libro{" + "titulo= " + titulo + ", autor= " + autor + ", existencia= " + numEjemplares + ", Prestados=" + numEjempPrestados + '}';
     }
     
     
}
