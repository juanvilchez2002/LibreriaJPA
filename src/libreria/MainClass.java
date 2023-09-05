
package libreria;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import libreria.entidad.Autor;
import libreria.entidad.Editorial;
import libreria.persistencia.AutorDAO;
import libreria.persistencia.EditorialDAO;


public class MainClass {


    public static void main(String[] args) {
        //pruebo si todo esta bien
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("LibreriaJPAPU");
//        EntityManager em = emf.createEntityManager();
//        
//        //creare un autor
//        Autor a = new Autor();
//        a.setNombre("Juan");
//        a.setAlta(true);
//        
//        em.getTransaction().begin();
//        em.persist(a);
//        em.getTransaction().commit();
        
          AutorDAO adao = new AutorDAO();
          
//          Autor a1 = new Autor();
//          a1.setNombre("Luciano");
//          a1.setAlta(true);
//          
//          Autor a2 = new Autor();
//          a2.setNombre("Luis");
//          a2.setAlta(true);
//          
//          Autor a3 = new Autor();
//          a3.setNombre("Luciano Ferreo");
//          a3.setAlta(true);
//          
//          adao.guardar(a1);
//          adao.guardar(a2);
//          adao.guardar(a3);
          
          List<Autor> autores = adao.buscarAutoPorNombre("luciano");
                    
          ArrayList<Autor> autoresAL = new ArrayList(autores);
        
          for(Autor aut:autoresAL){
              System.out.println(aut.toString());
          }
          
          Autor au = adao.buscarAutorPorId(3);
          System.out.println(au.toString());
          
          
          Editorial e1 = new Editorial("El Bananero", true);
          Editorial e2 = new Editorial("Castellana", true);
          Editorial e3 = new Editorial("Planeta", true);
          Editorial e4 = new Editorial("Libertad", true);
          
          EditorialDAO edao = new EditorialDAO();
          edao.guardar(e1);
          edao.guardar(e2);
          edao.guardar(e3);
          edao.guardar(e4);
    }
    
}
