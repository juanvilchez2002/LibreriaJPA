
package libreria.persistencia;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DAO<T> {
    
    //creando la conexion a la BD 
    protected final EntityManagerFactory emf = Persistence.createEntityManagerFactory("LibreriaJPAPU");
    protected EntityManager em = emf.createEntityManager();
    
    //metodo q nos permite conectar con la BD, verifica si la conexion esta realizada
    protected void conectar(){
        if(!em.isOpen()){
            em = emf.createEntityManager();
        }
    }
    
    //metodo q nos permite desconectar
    protected void desconectar(){
        if(em.isOpen()){
            em.close();
        }
    }
    
    //metodo para guardar un objeto
    protected void guardar(T objeto){
        conectar();
        em.getTransaction().begin();
        em.persist(objeto);
        em.getTransaction().commit();
        desconectar();
    }
    
    //metodo para editar
    protected void editar(T objeto){
        conectar();
        em.getTransaction().begin();
        em.merge(objeto);
        em.getTransaction().commit();
        desconectar();        
    }
    
    //metodo para eliminar
    protected void eliminar(T objeto){
        conectar();
        em.getTransaction().begin();
        em.remove(objeto);
        em.getTransaction().commit();
        desconectar();
    }
}
