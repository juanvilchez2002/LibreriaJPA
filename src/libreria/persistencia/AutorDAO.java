
package libreria.persistencia;

import java.util.ArrayList;
import java.util.List;
import libreria.entidad.Autor;

public class AutorDAO extends DAO<Autor>{

    @Override
    public void guardar(Autor autor) {
        super.guardar(autor); 
    }

    @Override
    public void editar(Autor autor) {
        super.editar(autor); 
    }
        
    public List<Autor> buscarAutoPorNombre(String nombre){
        conectar();
        List<Autor> autores = em.createQuery("SELECT a FROM Autor a"+
                " WHERE a.nombre LIKE :nombre").setParameter("nombre", "%"+nombre+"%")
                .getResultList();
        desconectar();       
              
        return autores;
    }
    
    public Autor buscarAutorPorId(Integer id){
        conectar();
        Autor autor = (Autor) em.createQuery("SELECT a FROM Autor a"+
                " WHERE a.id =:id").setParameter("id", id)
                .getSingleResult();
        desconectar();       
              
        return autor;
    }
    
}
