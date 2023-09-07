
package libreria.persistencia;

import java.util.List;
import libreria.entidad.Libro;


public class LibroDAO extends DAO<Libro>{

    @Override
    public void guardar(Libro objeto) {
        super.guardar(objeto); 
    }

    @Override
    public void editar(Libro objeto) {
        super.editar(objeto); 
    }
    
    public Libro buscarLibroPorIsbn(Integer id){
        conectar();
        Libro libro = em.find(Libro.class, id);
        desconectar();
        return libro;
    }
    
    public List<Libro> buscarLibroPorTitulo(String titulo){
        conectar();
        List<Libro> libros = em.createQuery("SELECT l FROM Libro l JOIN l.editorial e "+
                "WHERE l.titulo LIKE :titulo").setParameter("titulo", "%"+titulo+"%")
                .getResultList();
        desconectar();
        return libros;
    }
    
    public List<Libro> buscarLibroPorAutor(String nombre){
        conectar();
        
        List<Libro> libros = em.createQuery("SELECT l FROM Libro l JOIN l.autor a "+
                " WHERE a.nombre LIKE :nombre").setParameter("nombre", "%"+nombre+"%")
                .getResultList();
        desconectar();       
              
        return libros;
    }
    
    public List<Libro> buscarLibroPorEditorial(String editorial){
        conectar();
        List<Libro> libros = em.createQuery("SELECT l FROM Libro l JOIN l.editorial e "+
                "WHERE e.nombre LIKE :editorial").setParameter("editorial", "%"+editorial+"%")
                .getResultList();
        desconectar();
        return libros;
    }
    
    
}
