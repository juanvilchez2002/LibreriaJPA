
package libreria.servicios;

import java.util.ArrayList;
import java.util.Scanner;
import libreria.entidad.Autor;
import libreria.persistencia.AutorDAO;


public class AutorServicio {
    
    private final AutorDAO dao;// = new AutorDAO();
    Scanner consola;
    
    public AutorServicio() {
        this.dao = new AutorDAO();
        this.consola = new Scanner(System.in);
    }
    
    
    //metodo para guardar un Autor
    public void crearAutor(String nombre, Boolean alta){
        Autor autor = new Autor();
        
        try{
            if(nombre.isEmpty()){
                throw new Exception("Debe de ingresar un nombre de autor.");
            }
            
            if(!alta.booleanValue()){
                throw new Exception("Debe de ingresar una altar.");
            }
            
            autor.setNombre(nombre);
            autor.setAlta(alta);
            
            dao.guardar(autor);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public void editarAltaBaja() throws Exception{
        System.out.println("-------- Lista de Autores --------");
        
        ArrayList<Autor> autores = new ArrayList(dao.listarAutores());        
        System.out.println("Id\tAutores\tEstado");
        for(Autor aut: autores){
            System.out.println(aut.getId()+"\t"+aut.getNombre()+"\t"+aut.getAlta());
        }
        
        System.out.println("");
        System.out.print("Seleccione Id del Autor: ");
        Integer id = consola.nextInt();        
               
        Autor autor = dao.buscarAutorPorId(id);
        consola.nextLine();
        
        System.out.print("Seleccione 1: Alta | 0: Baja :");
        Boolean estado = Boolean.parseBoolean(consola.nextLine());
        
        autor.setAlta(estado);
        dao.editar(autor);
    }
    
    public void editarNombreAutor(){
        System.out.println("-------- Lista de Autores --------");
        
        ArrayList<Autor> autores = new ArrayList(dao.listarAutores());        
        System.out.println("Id\tAutores\tEstado");
        for(Autor aut: autores){
            System.out.println(aut.getId()+"\t"+aut.getNombre()+"\t"+aut.getAlta());
        }
        
        System.out.println("");
        System.out.print("Seleccione Id del Autor: ");
        Integer id = consola.nextInt();        
        
        Autor autor = null;
        try{
            autor = dao.buscarAutorPorId(id);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        consola.nextLine();
        
        System.out.print("Ingrese nombre del autor a cambiar: ");
        String nombre = consola.nextLine();
        
        if(nombre.isEmpty()){
            System.out.println("No se actualiza registro");
        }else{
            autor.setNombre(nombre);
            dao.editar(autor);
        }
    }
    
    public void listarAutores(){
        try{
            
            ArrayList<Autor> autores = new ArrayList(dao.listarAutores());
            System.out.println("------ Lista de Autores ------");
            System.out.println("Id\tAutor\tEstado");
            for(Autor aut: autores){
                System.out.println(aut.getId()+"\t"+aut.getNombre()+"\t"+aut.getAlta());
            }
        }catch(Exception e){
            throw e;
        }
    }
    
    public Autor buscarAutorPorId(Integer id){
        return (Autor) dao.buscarAutorPorId(id);
    }
    
    public void buscarAutorPorNombre(){
        System.out.print("Ingrese nombre del Autor: ");
        String nombre = consola.nextLine();
        ArrayList<Autor> autor = new ArrayList(dao.buscarAutoPorNombre(nombre));
        
        if(autor.isEmpty()){
            System.out.println("No existe Autor.");
        }else{
            System.out.println("---- LISTA DE AUTORES ----");
            System.out.println("Id\tAutor");
            for(Autor aut: autor){
                System.out.println(aut.getId()+"\t"+aut.getNombre());
            }
        }
    }
}
