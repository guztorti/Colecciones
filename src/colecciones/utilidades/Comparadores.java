/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package colecciones.utilidades;

import colecciones.entidades.Cantante;
import colecciones.entidades.Pelicula;
import colecciones.entidades.Raza;
import java.util.Comparator;

/**
 *
 * @author gustavotorti
 */
public class Comparadores {

               public static Comparator<Raza> ordenarRazaPorNombreDesc = new Comparator<Raza>() {
                    @Override
                    public int compare(Raza o1, Raza o2) {
                         return o2.getNombre().compareTo(o1.getNombre());
                    }

               };
               public static Comparator<Raza> ordenarRazaPorNombreAsc = new Comparator<Raza>() {
                    @Override
                    public int compare(Raza o1, Raza o2) {
                         return o1.getNombre().compareTo(o2.getNombre());
                    }

               };
               public static Comparator<Pelicula> ordenarPeliculaPorDuracionAsc = new Comparator<Pelicula>() {
                    @Override
                    public int compare(Pelicula o1, Pelicula o2) {
                         if (o1.getDuracion() > o2.getDuracion()) {
                              return 1;
                         } else if (o1.getDuracion() == o2.getDuracion()) {
                              return 0;
                         } else {
                              return -1;
                         }
                    }
               ;

               };
               public static Comparator<Pelicula> ordenarPeliculaPorDuracionDesc = new Comparator<Pelicula>() {
                    @Override
                    public int compare(Pelicula o1, Pelicula o2) {
                         if (o2.getDuracion() > o1.getDuracion()) {
                              return 1;
                         } else if (o2.getDuracion() == o1.getDuracion()) {
                              return 0;
                         } else {
                              return -1;
                         }
                    }
               ;

               };
               public static Comparator<Pelicula> ordenarPeliculaPorTitulo = new Comparator<Pelicula>() {
                    @Override
                    public int compare(Pelicula o1, Pelicula o2) {
                         return o1.getTitulo().compareTo(o2.getTitulo());
                    }
               ;

               };
               public static Comparator<Pelicula> ordenarPeliculaPorDirector = new Comparator<Pelicula>() {
                    @Override
                    public int compare(Pelicula o1, Pelicula o2) {
                         return o1.getDirector().compareTo(o2.getDirector());

                    }
               ;
          };
               public static Comparator<Cantante> ordenarCantantePorNombreAsc = new Comparator<Cantante>() {
                    @Override
                    public int compare(Cantante o1, Cantante o2) {
                         return o1.getNombre().compareTo(o2.getNombre());
                    }
                    
               };
}
