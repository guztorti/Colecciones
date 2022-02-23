/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package colecciones.servicios;

import colecciones.entidades.Raza;
import colecciones.utilidades.Comparadores;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
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
          
          mostrarLista(razas);
          
          return 1;
     }
     public boolean buscarRaza(Raza buscada){
          Iterator itr = razas.iterator();
          while (itr.hasNext()){
               if (itr.next().equals(buscada)) {
                    System.out.println(String.format("La raza fué encontrada, desea eliminarla?", buscada.getNombre()));
                    if (scn.nextBoolean()) {
                         borrarRaza(buscada);
                    }
                    ordenarLista(razas);
                    mostrarLista(razas);
                    return true;
               }
          }
          ordenarLista(razas);
          mostrarLista(razas);
          return false;
     }
     public String borrarRaza(Raza desecho){
          Iterator itr = razas.iterator();
          String nombre = desecho.getNombre(), aplica = desecho.getAplica();
          while (itr.hasNext()){
               if (itr.next().equals(desecho)) {
                    itr.remove();
               }
          }
          return String.format("la raza de %s, %s fue eliminada", aplica ,nombre);
     }
     public int ordenarLista(ArrayList lista){
          Collections.sort(lista, Comparadores.ordenarPorNombreDesc);
          return 1;
     }
     public boolean mostrarLista(ArrayList lista){
          for (Object raza : lista) {
               System.out.println(raza);
          }
          return true;
     }
}
//Continuando el ejercicio anterior, despu s de mostrar los perros, al usuario se le
//pedir  un perro y se recorrer  la lista con un Iterator, se buscar  el perro en la lista.
//Si el perro est  en la lista, se eliminar  el perro que ingres  el usuario y se mostrar 
//la lista ordenada. Si el perro no se encuentra en la lista, se le informar  al usuario y
//se mostrar  la lista ordenada.