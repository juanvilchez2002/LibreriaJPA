
package libreria.servicios;

import java.util.ArrayList;
import java.util.Scanner;
import libreria.entidad.Editorial;
import libreria.persistencia.EditorialDAO;


public class EditorialServicio {
    
    private final EditorialDAO dao;
    Scanner consola;

    public EditorialServicio(){
        this.dao = new EditorialDAO();
        this.consola = new Scanner(System.in);
    }
    
    //metodo para guardar un Autor
    public void crearEditorial(String nombre, Boolean alta){
        Editorial editorial = new Editorial();
        
        try{
            if(nombre.isEmpty()){
                throw new Exception("Debe de ingresar un nombre de autor.");
            }
            
            if(!alta.booleanValue()){
                throw new Exception("Debe de ingresar una altar.");
            }
            
            editorial.setNombre(nombre);
            editorial.setAlta(alta);
            
            dao.guardar(editorial);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public void editarAltaBaja() throws Exception{
        System.out.println("-------- Lista de Autores --------");
        
        ArrayList<Editorial> editoriales = new ArrayList(dao.listarEditorial());        
        System.out.println("Id\tEditorial\tEstado");
        for(Editorial editorial: editoriales){
            System.out.println(editorial.getId()+"\t"+editorial.getNombre()+"\t"+editorial.getAlta());
        }
        
        System.out.println("");
        System.out.print("Seleccione Id del Autor: ");
        Integer id = consola.nextInt();        
               
        Editorial editorial = dao.buscarEditorialPorId(id);
        consola.nextLine();
        
        System.out.print("Seleccione 1: Alta | 0: Baja :");
        Boolean estado = Boolean.parseBoolean(consola.nextLine());
        
        editorial.setAlta(estado);
        dao.editar(editorial);
    }
    
    public void editarNombreAutor(){
        System.out.println("-------- Lista de Autores --------");
        
        ArrayList<Editorial> editoriales = new ArrayList(dao.listarEditorial());        
        System.out.println("Id\tEditorial\tEstado");
        for(Editorial editorial: editoriales){
            System.out.println(editorial.getId()+"\t"+editorial.getNombre()+"\t"+editorial.getAlta());
        }
        
        System.out.println("");
        System.out.print("Seleccione Id del Autor: ");
        Integer id = consola.nextInt();        
        
        Editorial editorial = null;
        try{
            editorial = dao.buscarEditorialPorId(id);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        consola.nextLine();
        
        System.out.print("Ingrese nombre del Editor a cambiar: ");
        String nombre = consola.nextLine();
        
        if(nombre.isEmpty()){
            System.out.println("No se actualiza registro");
        }else{
            editorial.setNombre(nombre);
            dao.editar(editorial);
        }
    }
    
    public void listarEditoriales(){
        try{
            
            ArrayList<Editorial> editoriales = new ArrayList(dao.listarEditorial());
            System.out.println("------ Lista de Editoriales ------");
            System.out.println("Id\tEditorial\tEstado");
            for(Editorial edit: editoriales){
                System.out.println(edit.getId()+"\t"+edit.getNombre()+"\t"+edit.getAlta());
            }
        }catch(Exception e){
            throw e;
        }
    }
    
    public Editorial buscarEditorialPorId(Integer id){
        return (Editorial) dao.buscarEditorialPorId(id);
    }
    
}
