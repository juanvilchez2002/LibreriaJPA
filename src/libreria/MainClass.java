
package libreria;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import libreria.entidad.Autor;
import libreria.entidad.Editorial;
import libreria.entidad.Libro;
import libreria.persistencia.AutorDAO;
import libreria.persistencia.EditorialDAO;
import libreria.persistencia.LibroDAO;
import libreria.servicios.AutorServicio;
import libreria.servicios.EditorialServicio;
import libreria.servicios.LibroServicio;


public class MainClass {

    public static void main(String[] args) throws Exception {
        
        //instanciando los servicios        
        LibroServicio ls = new LibroServicio();
        AutorServicio as = new AutorServicio();
        EditorialServicio es = new EditorialServicio();
        
        Scanner consola = new Scanner(System.in);
        
        do{
            System.out.println("------ MENU ------");
            System.out.println("1. Ingresar Libro. ");
            System.out.println("2. Ingresar Autor. ");
            System.out.println("3. Ingresar Editorial. ");
            System.out.println("4. Busqueda de Autor. ");
            System.out.println("5. Busqueda de Editorial. ");
            System.out.println("6. Buscar Libro por Titulo: ");
            System.out.println("7. Buscar Libro por Autor. ");
            System.out.println("8. Buscar Libro por Editorial. ");
            System.out.println("Seleccione una Opcion: ");
            
            int op = consola.nextInt();            
            consola.nextLine();
            
            switch (op) {
                case 1:
                    System.out.println("----- INGRESE LIBRO -----");
                    ls.crearLibro();                    
                    break;
                case 2:
                    System.out.println("----- INGRESE AUTOR -----");
                    System.out.print("Nombre Autor: ");
                    String autor = consola.nextLine();
                    as.crearAutor(autor, true);
                    break;
                case 3:
                    System.out.println("----- INGRESE EDITORIAL -----");
                    System.out.print("Nombre Editorial: ");
                    String editorial = consola.nextLine();
                    es.crearEditorial(editorial, true);
                    break;
                case 4:
                    System.out.println("");
                default:
                    throw new AssertionError();
            }
        
        }while(true);
    } 
}
