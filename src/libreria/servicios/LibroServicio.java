
package libreria.servicios;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import libreria.entidad.Autor;
import libreria.entidad.Editorial;
import libreria.entidad.Libro;
import libreria.persistencia.LibroDAO;

public class LibroServicio {
    
    LibroDAO dao;
    AutorServicio as;
    EditorialServicio es;
    Scanner consola;

    public LibroServicio() {
        this.dao = new LibroDAO();
        this.as = new AutorServicio();
        this.es = new EditorialServicio();
        this.consola = new Scanner(System.in);
    }
    
    
    public void crearLibro(){        
        Libro libro = new Libro();
        
        do{
            System.out.println("Ingrese el Titulo del Libro:");
            String titulo = consola.nextLine();
            
            if(buscarLibroTitulo(titulo).isEmpty()){
                libro.setTitulo(titulo);
                break;
            }else{                
                System.out.println("El Titulo ya esta ingresado");                
            }
        }while(true);
        
        do{
            System.out.println("Ingrese el año del Libro");
            try{
                int anio = consola.nextInt();
                libro.setAnio(anio);
                break;
            }catch(Exception e){
                System.out.println("Error en el año");
            }
        }while(true);
        
        System.out.println("Ingrese la cantidad de Ejemplares");
        try{
            int cantidadEjemmplar = consola.nextInt();
            libro.setEjemplares(cantidadEjemmplar);
            libro.setEjemplaresRestantes(cantidadEjemmplar);
            libro.setEjemplaresPrestados(0);            
        }catch(Exception e){
            System.out.println("Error al ingresar Nro de ejemplares");            
        }
        
        libro.setAlta(true);
        
        //mostrando los autores para ingresarlos
        as.listarAutores();
        System.out.print("Seleccione el Id del Autor: ");
        try{
            int id = consola.nextInt();
            Autor autor = null;
            try{
                autor = as.buscarAutorPorId(id);
            }catch(Exception e){
                System.out.println("Error al buscar Id del Autor");
            }
            
            if(Objects.isNull(autor)){
                System.out.println("No Existe el registro");
            }else{
                libro.setAutor(autor);
            }
        }catch(Exception e){
            System.out.println("Error al seleccionar el Id del Autor");
            throw e;
        }
        
        //seleccionando a la editorial
        es.listarEditoriales();
        System.out.print("Seleccione el Id de la Editorial: ");
        try{
            int id = consola.nextInt();
            Editorial editorial = null;
            try{
                editorial = es.buscarEditorialPorId(id);
            }catch(Exception e){
                System.out.println("Error al buscar Id de la Editorial");
            }
            
            if(Objects.isNull(editorial)){
                System.out.println("No Existe el registro");
            }else{
                libro.setEditorial(editorial);
            }
        }catch(Exception e){
            System.out.println("Error al seleccionar el Id de la Editorial");
            throw e;
        }
        
        try{
            dao.guardar(libro);
            System.out.println("Libro registrado");
        }catch(Exception e){
            System.out.println("Error al registrar Libro");
            throw e;
        }
        
    }
    
    public List<Libro> buscarLibroTitulo(String titulo){
        List<Libro> libros = dao.buscarLibroPorTitulo(titulo);
        return libros;
    }
    
    public void buscarLibroTitulo(){
        System.out.print("Ingrese el Titulo a buscar: ");
        String titulo = consola.nextLine();
        
        ArrayList<Libro> libros = new ArrayList(buscarLibroTitulo(titulo));
        
        if(libros.isEmpty()){
            System.out.println("No hay libros con el titulo ingresado");
        }else{
            System.out.println("ISBN\tTITULO\tAUTOR\tEDITORIAL\tEJEMPLARES\tPRESTADOS\tDISPONIBLES");
            for(Libro lib: libros){
                System.out.print(lib.getIsbn()+"\t"+lib.getTitulo()+"\t"+lib.getAutor().getNombre()+"\t");
                System.out.print(lib.getEditorial().getNombre()+"\t"+lib.getEjemplares()+"\t"+lib.getEjemplaresPrestados());
                System.out.println("\t"+lib.getEjemplaresRestantes());
            }            
        }
    }
    
    public void buscarLibroPorAutor(){
        System.out.print("Ingrese Autor del Libro a buscar: ");
        String autor = consola.nextLine();
        
        ArrayList<Libro> libros = new ArrayList(dao.buscarLibroPorAutor(autor));
        
        if(libros.isEmpty()){
            System.out.println("No hay libros con el titulo ingresado");
        }else{
            System.out.println("ISBN\tTITULO\tAUTOR\tEDITORIAL\tEJEMPLARES\tPRESTADOS\tDISPONIBLES");
            for(Libro lib: libros){
                System.out.print(lib.getIsbn()+"\t"+lib.getTitulo()+"\t"+lib.getAutor().getNombre()+"\t");
                System.out.print(lib.getEditorial().getNombre()+"\t"+lib.getEjemplares()+"\t"+lib.getEjemplaresPrestados());
                System.out.println("\t"+lib.getEjemplaresRestantes());
            }            
        }
    }
    
    public void buscarLibroPorEditorial(){
        System.out.print("Ingrese Editorial del Libro a buscar: ");
        String editorial = consola.nextLine();
        
        ArrayList<Libro> libros = new ArrayList(dao.buscarLibroPorEditorial(editorial));
        
        if(libros.isEmpty()){
            System.out.println("No hay libros con el titulo ingresado");
        }else{
            System.out.println("ISBN\tTITULO\tAUTOR\tEDITORIAL\tEJEMPLARES\tPRESTADOS\tDISPONIBLES");
            for(Libro lib: libros){
                System.out.print(lib.getIsbn()+"\t"+lib.getTitulo()+"\t"+lib.getAutor().getNombre()+"\t");
                System.out.print(lib.getEditorial().getNombre()+"\t"+lib.getEjemplares()+"\t"+lib.getEjemplaresPrestados());
                System.out.println("\t"+lib.getEjemplaresRestantes());
            }            
        }
    }
}
