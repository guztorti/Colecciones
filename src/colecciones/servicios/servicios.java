/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package colecciones.servicios;

import colecciones.entidades.Alumno;
import colecciones.entidades.Cantante;
import colecciones.entidades.Libro;
import colecciones.entidades.Pelicula;
import colecciones.entidades.Raza;
import colecciones.utilidades.Comparadores;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeSet;

/**
 *
 * @author gustavotorti
 */
public class servicios {

     private final Scanner scn;
     private final ArrayList<Raza> razas;
     private final ArrayList<Alumno> alumnos;
     private final ArrayList<Pelicula> peliculas;
     private final TreeSet<String> paises;
     private final HashMap<String, Double> productos;
     private final ArrayList<Integer> numeros;
     private final ArrayList<Cantante> cantantes;
     private final HashSet<Libro> libros;
     private final HashMap<Integer, String> codPostales;
     

     public servicios() {
          this.scn = new Scanner(System.in).useDelimiter("\n");
          this.razas = new ArrayList();
          this.alumnos = new ArrayList();
          this.peliculas = new ArrayList();
          this.paises = new TreeSet();
          this.productos = new HashMap();
          this.numeros = new ArrayList();
          this.cantantes = new ArrayList();
          this.libros = new HashSet();
          this.codPostales = new HashMap();
     }
     public void mascotas(){
          ingresarRaza();
          String nombre, especie;
          System.out.println("Ingrese el nombre de la raza a eliminar:");
          nombre = scn.next().toLowerCase();
          System.out.println("a que animal aplica esta raza?");
          especie = scn.next().toLowerCase();
          System.out.println(buscarRaza(new Raza(nombre, especie))?borrarRaza(new Raza(nombre, especie)):"la raza no se encuentra cargada en la lista");
     }

     public Raza definirRaza() {
          System.out.println("Ingrese el nombre de la raza");
          String nombre = scn.next();
          System.out.println("Ingrese a que animal pertenece");
          String aplica = scn.next();
          return new Raza(nombre, aplica);
     }

     public int ingresarRaza() {
          char salir = 'n';
          do {
               System.out.println("desea ingresar una nueva Raza? \'Si\'\\\'No\' ");
               salir = scn.next().toLowerCase().charAt(0);
               if (salir == 's') {
                    razas.add(definirRaza());
               }
          } while (salir != 'n');
          ordenarListaAsc(razas);
          mostrarLista(razas);

          return 1;
     }

     public boolean buscarRaza(Raza buscada) {
          Iterator itr = razas.iterator();
          while (itr.hasNext()) {
               if (itr.next().equals(buscada)) {
                    System.out.println(String.format("La raza fué encontrada, desea eliminarla?", buscada.getNombre()));
                    if (scn.nextBoolean()) {
                         borrarRaza(buscada);
                    }
                    ordenarListaAsc(razas);
                    mostrarLista(razas);
                    return true;
               }
          }
          ordenarListaAsc(razas);
          mostrarLista(razas);
          return false;
     }

     public String borrarRaza(Raza desecho) {
          Iterator itr = razas.iterator();
          String nombre = desecho.getNombre(), aplica = desecho.getAplica();
          while (itr.hasNext()) {
               if (itr.next().equals(desecho)) {
                    itr.remove();

               }
          }
          return String.format("la raza de %s, %s fue eliminada", aplica, nombre);
     }

     public int ordenarListaAsc(ArrayList lista) {
          Collections.sort(lista, Comparadores.ordenarRazaPorNombreAsc);
          return 1;
     }

     public boolean mostrarLista(ArrayList lista) {
          for (Object e : lista) {
               System.out.println(e);
          }
          return true;
     }
     
     public void alumnos() {
                    char otro = 'n';

          Alumno alumno = crearAlumno();
          alumnos.add(alumno);
          alumno.setNotas(cargarNotas(alumno.getNombre()));
          
          do {
               System.out.println("¿Desea ingresar otro alumno? ");
               do {
                    
                    System.out.println("debe ingresar \"Si\"/\"No\"");
                    otro = scn.next().toLowerCase().charAt(0);
               } while (otro != 's' && otro != 'n');

               if (otro == 's') {
                    alumno = crearAlumno();
                    alumnos.add(alumno);
                    alumno.setNotas(cargarNotas(alumno.getNombre()));
               }

          } while (otro != 'n');
          
          System.out.println("Ingrese un alumno para obtener su nota final:");
          String nombre = scn.next();
          System.out.println(-1 != encuentraAlumno(nombre) ? String.format("La nota final del alumno %s es: %s", nombre, alumnos.get(encuentraAlumno(nombre)).notaFinal()) : "no está " + nombre.toUpperCase());
}

     public Alumno crearAlumno() {
          System.out.println("Ingrese el nombre del alumno");
          String nombre = scn.next();
          return new Alumno(nombre);
     }

     public ArrayList<Integer> cargarNotas(String nombre) {
          ArrayList<Integer> eval = new ArrayList();
          Iterator<Alumno> itr = alumnos.iterator();
          boolean encontrado = false;
          while (itr.hasNext()) {
               if (itr.next().getNombre().equalsIgnoreCase(nombre)) {
                    encontrado = true;
                    for (int i = 0; i < 3; i++) {
                         System.out.println(String.format("ingrese la %sº nota", (i + 1)));
                         eval.add(scn.nextInt());
                    }
                    return eval;
               }
          }
          if (!encontrado) {
               System.out.println("El alumno no se encuentra registrado ...");
          }
          return null;
     }

     public int encuentraAlumno(String nombre) {
          Iterator<Alumno> itr = alumnos.iterator();
          int retorno = 0;
          while (itr.hasNext()) {
               if (itr.next().getNombre().equalsIgnoreCase(nombre)) {
                    return retorno;
               }
               retorno++;
          }
          return -1;
     }
     
     public void peliculas(){
          char otro = 'n';
                    do {       
               Pelicula peli1 = crearPelicula();
               peliculas.add(peli1);
               System.out.println("desea ingresar otra película \"Si\"/\"No\"");
               otro = scn.next().toLowerCase().charAt(0);
          } while (otro != 'n');
          //cargar peliculas por código
//          {
//               Pelicula peli1 = new Pelicula("Terminator", "Cameron", 1.48);
//               peliculas.add(peli1);
//               Pelicula peli2 = new Pelicula("Tiburon", "Spielberg", 2.0667);
//               peliculas.add(peli2);
//               Pelicula peli3 = new Pelicula("La misión", "Joffé", 2.1);
//               peliculas.add(peli3);
//               Pelicula peli4 = new Pelicula("Una guerra de película", "Stiller", 0.95);
//               peliculas.add(peli4);
//          }
          System.out.println(mostrarPeliculas());
          System.out.println(mostrarPeliculasMayoresAUnaHora());
          System.out.println("Ordenadas de más larga a más corta");
          Collections.sort(peliculas, Comparadores.ordenarPeliculaPorDuracionDesc);
          System.out.println(mostrarPeliculas());
          System.out.println("Ordenadas de más corta a más larga");
          Collections.sort(peliculas, Comparadores.ordenarPeliculaPorDuracionAsc);
          System.out.println(mostrarPeliculas());
          System.out.println("Ordenadas por título");
          Collections.sort(peliculas, Comparadores.ordenarPeliculaPorTitulo);
          System.out.println(mostrarPeliculas());
          System.out.println("Ordenadas director");
          Collections.sort(peliculas, Comparadores.ordenarPeliculaPorDirector);
          System.out.println(mostrarPeliculas());
     }

     public Pelicula crearPelicula() {
          System.out.println("Ingrese el título de la pelicula:");
          String titulo = scn.next();
          System.out.println("...su director:");
          String director = scn.next();
          System.out.println("y la duración (en horas)");
          double duracion = scn.nextDouble();
          return new Pelicula(titulo, director, duracion);
     }

     public String mostrarPeliculas() {
          Iterator<Pelicula> itr = peliculas.iterator();
          String retorno = "Lista de películas:\n";
          while (itr.hasNext()) {
               retorno += itr.next().toString() + "\n";
          }
          return retorno;
     }

     public String mostrarPeliculasMayoresAUnaHora() {
          String retorno = "Lista de películas más largas que una hora:\n";
          for (Pelicula elemento : peliculas) {
               if (elemento.getDuracion() > 1d) {
                    retorno += elemento + "\n";
               }
          }
          return retorno;
     }
     
     public void paises(){
          cargarPais();
          System.out.println(eliminarPais());
          mostrarPaises();
     }

     public void cargarPais() {
          char otro = 'n';
          do {
               System.out.println("Ingrese el pais a cargar...");
               paises.add(scn.next().toUpperCase());
               System.out.println("Desea ingresar otro pais? \"Si\"/\"No\"");
               otro = scn.next().toLowerCase().charAt(0);
          } while (otro != 'n');
          mostrarPaises();
     }

     public void mostrarPaises() {
          for (String elemento : paises) {
               System.out.println(elemento);
          }
     }

     public String eliminarPais() {
          Iterator<String> itr = paises.iterator();
          String retorno = "", aEliminar;
          boolean encontro = false;
          System.out.println("Ingrese el nombre del pais a eliminar de la lista");
          aEliminar = scn.next().toUpperCase();
          while (itr.hasNext()) {
               if (itr.next().equalsIgnoreCase(aEliminar)) {
                    retorno = " el pais: " + aEliminar + " a sido eliminado de la lista";
                    itr.remove();
                    encontro = true;
               }
          }
          return encontro ? retorno : "el pais no se encuentra en la lista";
     }

     public void almacen() {
          final String menu = "* * * * * * *   ALMACEN   * * * * * * *\n*           Menú                      *\n* 1\tIngresar producto             *\n* 2\tModificar precio              *\n* 3\tMostrar lista de productos    *\n*                                     *\n* 9\tSalir                         *\n* * * * * * * * * * * * * * * * * * * *";
          char opcion = '9';
          do {
               System.out.println(menu);
               opcion = scn.next().charAt(0);
               switch (opcion) {
                    case '1':
                         ingresarProducto();
                         break;
                    case '2':
                         modificarPrecio();
                         break;
                    case '3':
                         mostrarListaProductos();
                         break;
                    case '9':
                         System.out.println("Gracias por utilizar el sistema");
                         break;

                    default:
                         System.out.println("No se reconoce la opción, elija nuevamente");

               }
          } while (opcion != '9');
     }

     private void ingresarProducto() {
          System.out.println("Ingrese el nombre del producto:");
          String nombre = scn.next().toLowerCase();
          System.out.println("e ingrese su precio:");
          double precio = scn.nextDouble();
          productos.put(nombre, precio);
     }

     private void modificarPrecio() {
          System.out.println("Ingrese el nombre del producto a modificar");
          String nombre = scn.next().toLowerCase();
          System.out.println("Antiguo valor: " + productos.get(nombre));

          productos.replace(nombre, productos.get(nombre), scn.nextDouble());

     }

     private void mostrarListaProductos() {
          System.out.println("Lista de productos: ");
          for (Map.Entry<String, Double> entry : productos.entrySet()) {
               Object key = entry.getKey();
               Object val = entry.getValue();
               System.out.println("[nombre: " + key + " ,precio: " + val + " ]");
          }
          System.out.println(" ");
     }
     
     public void ingresarNumeros(){
          int var;
          do {               
               System.out.println("Ingrese un número entero (o -99 para finalizar)");
               var = scn.nextInt();
               
               try {
                    if (var != -99) {
                         numeros.add(var);
                    }
               } catch (Exception e) {
               }
          } while (var != -99);
          System.out.println("Los valores ingresados son:");
          int suma= 0;
          String salida = "[";
          for (Integer numero : numeros) {
               salida += numero +", ";
               suma += numero;
          }
          salida = salida.substring(0, salida.length()-1)+"]";
          System.out.println(salida);
          System.out.println("la suma de los valores es: "+suma);
          System.out.println("y su media es: "+(suma/numeros.size()));
     }
     
     public void cantantes(){
          cantantes.add(new Cantante("Shakira", "Laundry service"));
          cantantes.add(new Cantante("Julio Iglesias", "Hey!"));
          cantantes.add(new Cantante("Santana", "Supernatural"));
          cantantes.add(new Cantante("Gloria Estefan", "Mi tierra"));
          cantantes.add(new Cantante("Enrique Iglesias", "Escape"));
          
          Collections.sort(cantantes, Comparadores.ordenarCantantePorNombreAsc);
          mostrarLista(cantantes);
          char opcion = 's';
          do {               
               System.out.println("\t\tOPERACIONES CON LISTA DE FAMOSOS\n\t\"i\"\tIngresar un nuevo cantante\n"
                       + "\t\"m\"\tMostrar la lista de cantantes\n\t\"e\"\tEliminar un cantante\n\n\n\t\"s\"\tSalir del sistema\n");
               opcion = scn.next().toLowerCase().charAt(0);
               switch (opcion){
                    case 'i':
                         cantantes.add(ingresarCantante());
                         break;
                    case 'm':
                         mostrarLista(cantantes);
                         break;
                    case 'e':
                         System.out.println(eliminarCantante()?"el cantante se ha eliminado":"el artista no se encontraba en la lista");
                         break;
                    case 's':
                         System.out.println("Gracias por utilizar el sistema\nLa lista de cantantes quedó asi:");
                         mostrarLista(cantantes);
                         break;
                    default:
                         System.out.println("No se reconoce la opción");
               }
          } while (opcion != 's');
     }

     private Cantante ingresarCantante(){
          String nombre, disco;
          System.out.println("Ingrese el nombre del cantante famoso");
          nombre = scn.next();
          System.out.println("Ingrese el nombre del disco más vendido");
          disco = scn.next();
          return new Cantante(nombre, disco);
     }
     
     private boolean eliminarCantante(){
          System.out.println("Ingrese el nombre del cantante a eliminar:");
          String nombre = scn.next().toLowerCase();
          //ha mejorar: hacer una función que coloque todas las palabras inicial com mayúscula
          nombre = nombre.substring(0, 1).toUpperCase()+nombre.substring(1);
          Iterator<Cantante> itr = cantantes.iterator();
          while (itr.hasNext()){
               if (itr.next().getNombre().equalsIgnoreCase(nombre)) {
                    itr.remove();
                    return true;
               }
          }
          return false;
     }
     
     public void biblioteca(){
          char opcion = '9';
          String menu = ("\t\tOPERACIONES DE LA BIBLIOTECA\n\t\"1\"\tIngresar una partida de libros\n"
                       + "\t\"2\"\tPrestar un ejemplar\n\t\"3\"\tAsentar una devolución\n"
                       + "\t\"4\"\tMostrar lista de libros\n\n\n\t\"9\"\tSalir del sistema\n");
          do {               
               System.out.println(menu);
               opcion = scn.next().charAt(0);
               switch (opcion){
                    case '1':
                         libros.add(crearLibro());
                         break;
                    case '2':
                         System.out.println(prestarLibro());
                         break;
                    case '3':
                         devolucion();
                         break;
                    case '4':
                         System.out.println("hay "+mostrarLibros()+" libros distintos");
                         break;
                    case 9:
                         System.out.println("gracias por utilizar el sistema");
                    default:
                         System.out.println("no se reconoce la opción");
               }
          } while (opcion != '9');
     }
     
     private Libro crearLibro(){
          System.out.println("Ingrese el Título del libro:");
          String titulo = scn.next().toUpperCase();
          System.out.println("Ingrese el autor:");
          String autor = scn.next().toUpperCase();
          System.out.println("Cantidad de ejemplares comprados");
          int ejemplares = scn.nextInt();
          
          return new Libro(titulo, autor, ejemplares);
     }
     
     private String prestarLibro(){
          
          System.out.println("¿Cuál es título del libro que desea llevar?:");
          String titulo = scn.next().toUpperCase();
          Iterator<Libro> itr = libros.iterator();
          while (itr.hasNext()){
               if(itr.next().getTitulo().equalsIgnoreCase(titulo)){
                    return sePuedePrestar(itr.next())?"se ha prestado un ejemplar del libro \""+titulo+"\"":"No quedan ejemplares del libro \""+titulo+"\"";
               }
          }
          
          return "el libro no sse encuentra en nuestra biblioteca...";
     }
     /***
      * Evalúa si hay ejemplares de ese libro en la biblioteca
      * de ser posible, agrega un ejemplar a los prestados
      * @param libro a evaluar
      * @return true/false
      */
     private boolean sePuedePrestar(Libro libro){
          boolean accede = false;
          if (libro.getNumEjemplares() > libro.getNumEjempPrestados()) {
               libro.setNumEjempPrestados(libro.getNumEjempPrestados()+1);
               accede = true;
          }
          return accede;
     }
     /***
      * proceso de devolución de Libro
      * @return devuelve -1 si el proceso finalizó correctamente 0 si hay alguna exepción
      */
     private int devolucion(){
          System.out.println("Ingrese el título del libro a devolver:");
          String titulo = scn.next().toUpperCase();
          Iterator<Libro> itr = libros.iterator();
          try {
               while (itr.hasNext()){
               if(itr.next().getTitulo().equalsIgnoreCase(titulo)){
                    System.out.println(devolver(itr.next())?"hay un nuevo ejemplar de \""+titulo+"\" disponible para prestar":"");
                    break;
               }
          }
          } catch (Exception e) {
               return 0;
          }
          
          return -1;
     }
     /***
      * 
      * @param libro recibe un objeto de tipo libro para evaluar si corresponde 
      * a los pertenecientes a la biblioteca
      * @return true/false
      */
     private boolean devolver(Libro libro){
          if (libro.getNumEjempPrestados()==0) {
               System.out.println("El ejemplar a devolver no pertenece a la biblioteca");
               return false;
          } else {
               libro.setNumEjempPrestados(libro.getNumEjempPrestados()-1);
               return true;
          }

     }
     private int mostrarLibros(){
          System.out.println("Listado de libros de la bilioteca:");
          for (Libro libro : libros) {
               System.out.println(libro);
          }
          return libros.size();
     }
     public void codigosPostales(){
//          codPostales.put(5500, "Mendoza, Mendoza, Argentina");
//          codPostales.put(5634, "Bowen, Mendoza, Argentina");
//          codPostales.put(5833, "Achiras, Cordoba, Argentina");
//          codPostales.put(3350, "Apóstoles, Misiones, Argentina");
//          codPostales.put(4208, "Albardon, Santiago del Estero, Argentina");
//          codPostales.put(6218, "Bagual, San Luis, Argentina");
//          codPostales.put(8000, "Bahía Blanca, Buenos Aires, Argentina");
//          codPostales.put(9041, "Los Antiguos, Santa Cruz, Argentina");
//          codPostales.put(4630, "Chorrilos, Jujuy, Argentina");
//          codPostales.put(9410, "Ushuaia, Tierra del Fuego, Argentina");
          
          int codigo =0;
          String ciudad ="";
          System.out.println("debe ingresar los códigos postales de 10 ciudades");
          for (int i = 0; i < 10; i++) {
               System.out.println("Ingrese el CP de la "+(i+1)+"º ciudad");
               codigo = scn.nextInt();
               System.out.println("Ingrese el nombre de la cuidad, la provincia y el pais a que pertenece");
               ciudad = scn.next().toUpperCase();
               codPostales.put(codigo, ciudad);
          }
          System.out.println(mostrarCP());
          System.out.println("ingrese un CP a buscar:");
          codigo = scn.nextInt();
          System.out.println(buscarCP(codigo));
          System.out.println(mostrarCP());
          System.out.println("Ingrese el CP de otra ciudad");
          codigo = scn.nextInt();
          System.out.println("Ingrese el nombre de la cuidad, la provincia y el pais a que pertenece");
          ciudad = scn.next().toUpperCase();
          codPostales.put(codigo, ciudad);
          System.out.println("Ahora va a eliminar tres ciudades de la lista");
          System.out.println(mostrarCP());
          for (int i = 0; i < 3; i++) {
               System.out.println("ingrese el CP de la ciudad a elliminar");
               
               if (eliminarCP(scn.nextInt())) {
                    System.out.println("la ciudad se ha sacado de la lista");
               } else {
                    System.out.println("la ciudad no se encuentra en la lista\ningrese el CP nuevamente");
                    i--;
               }
          }
          System.out.println("");
          System.out.println(mostrarCP());
          
          
     }
     private String mostrarCP(){
          String salida = "";
          for (Map.Entry<Integer, String> entry : codPostales.entrySet()) {
               Object cod = entry.getKey();
               Object ciud = entry.getValue();
               salida += "[código postal: "+ cod + " , nombre: "+ciud+"]\n";
          }
          
          return salida;
     }
     
     private String buscarCP(int cod){
          if (codPostales.containsKey(cod)) {
               return codPostales.get(cod);
          }
          return "el codigo "+cod+" no se encuentra cargado aún";
     }
     
     private boolean eliminarCP(int cod){
          if (codPostales.containsKey(cod)) {
               codPostales.remove(cod);
               return true;
          }
          return false;
     }
}

/*Almacena en un HashMap los c digos postales de 10 ciudades a elecci n de esta
p gina: https://mapanet.eu/index.htm. Nota: Poner el c digo postal sin la letra, solo el
numero.
• Pedirle al usuario que ingrese 10 c digos postales y sus ciudades.
• Muestra por pantalla los datos introducidos
• Pide un c digo postal y muestra la ciudad asociada si existe sino avisa al usuario.
• Muestra por pantalla los datos
• Agregar una ciudad con su c digo postal correspondiente m s al HashMap.
• Elimina 3 ciudades existentes dentro del HashMap, que pida el usuario.
• Muestra por pantalla los datos
*/