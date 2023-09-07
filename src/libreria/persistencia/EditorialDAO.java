
package libreria.persistencia;

import java.util.List;
import libreria.entidad.Editorial;

public class EditorialDAO extends DAO<Editorial>{

    @Override
    public void guardar(Editorial editorial) {
        super.guardar(editorial); 
    }
    
    @Override
    public void editar(Editorial editorial) {
        super.editar(editorial); 
    }
    
    public List<Editorial> buscarEditorialPorNombre(String nombre){
        conectar();
        List<Editorial> editorial = em.createQuery("SELECT e FROM Editorial e"+
                " WHERE e.nombre LIKE :nombre").setParameter("nombre", "%"+nombre+"%")
                .getResultList();
        desconectar();       
              
        return editorial;
    }
    
    public Editorial buscarEditorialPorId(Integer id){
        conectar();
        Editorial editorial = (Editorial) em.createQuery("SELECT e FROM Editorial e"+
                " WHERE e.id =:id").setParameter("id", id)
                .getSingleResult();
        desconectar();       
              
        return editorial;
    }
    
    public List<Editorial> listarEditorial(){
        conectar();
        List<Editorial> editoriales = em.createQuery("SELECT e FROM Editorial e").getResultList();
        desconectar();
        return editoriales;
    }
}
