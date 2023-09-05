
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
    
    public List<Editorial> buscarAutoPorNombre(String nombre){
        conectar();
        List<Editorial> editorial = em.createQuery("SELECT e FROM Editorial e"+
                " WHERE e.nombre LIKE :nombre").setParameter("nombre", "%"+nombre+"%")
                .getResultList();
        desconectar();       
              
        return editorial;
    }
    
    public Editorial buscarAutorPorId(Integer id){
        conectar();
        Editorial editorial = (Editorial) em.createQuery("SELECT e FROM Editorial e"+
                " WHERE e.id =:id").setParameter("id", id)
                .getSingleResult();
        desconectar();       
              
        return editorial;
    }
}
