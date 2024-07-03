package Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Interfaces.Iproducto;
import model.TblProductocl3;

public class ClassProductoImp  implements Iproducto{

	@Override
	public void RegistrarProducto(TblProductocl3 producto) {
		// TODO Auto-generated method stub		
		//establecer la cadena de conexion con la unidad de persistencia
				 EntityManagerFactory fabr=Persistence.createEntityManagerFactory("LP2_CL3_RandolSanchezVillavicencio");
			      //gestionar las entidades
				 EntityManager em=fabr.createEntityManager();
				//iniciamos la transaccion
				em.getTransaction().begin();
				//registramos
				em.persist(producto);
				//emitimos mensaje por consola
				System.out.print("Producto registrado en la BD");
				//configuramos
				em.getTransaction().commit();
				//cerramos
				em.close();
		
	}

	@Override
	public void ActualizarProducto(TblProductocl3 producto) {
		// TODO Auto-generated method stub
		//establecer la cadena de conexion con la unidad de persistencia
		 EntityManagerFactory fabr=Persistence.createEntityManagerFactory("LP2_CL3_RandolSanchezVillavicencio");
		//gestionar las entidades
		 EntityManager em=fabr.createEntityManager();
		//iniciamos la transaccion
			em.getTransaction().begin();
			//actualizar
			em.merge(producto);
			//configuramos
			em.getTransaction().commit();
			//cerramos
			em.close();	
			
		 
		
		
	}
	
	

	@Override
	public List<TblProductocl3> ListadoProducto() {
		// TODO Auto-generated method stub			
				//establecemos conexion con la unidad de persistencia
					EntityManagerFactory fabr=Persistence.createEntityManagerFactory("LP2_CL3_RandolSanchezVillavicencio");
					//gestionar las entidades
					EntityManager em=fabr.createEntityManager();
					//iniciamos la transaccion
					em.getTransaction().begin();
					//recuperamos el listado de cliente de la BD
					//aplicamos consultas JPQL, el metodo createquery(), sirve para hacer consultas dinamicas
					List<TblProductocl3> listado=em.createQuery("select c from TblProductocl3 c",TblProductocl3.class).getResultList();
					//confirmamos
					em.getTransaction().commit();
					//cerramos
					em.close();
					//recuperamos el cliente buscado de la BD
				return listado;
	}
	
	

	@Override
	public TblProductocl3 BuscarProducto(TblProductocl3 producto) {
		
		//establecer la conexion con la unidad de persistencia
		EntityManagerFactory farb= Persistence.createEntityManagerFactory("LP2_CL3_RandolSanchezVillavicencio");
		//gestionar las entidades
        EntityManager em= farb.createEntityManager();
        //inicar la transaccion
        em.getTransaction().begin();
        //recuperamos en codigo a buscar
        TblProductocl3 buscarPro=em.find(TblProductocl3.class, producto.getIdproductoscl3());
      //confirmamos
        em.getTransaction().commit();
        //cerramos
        em.close();
        //retornamos el cliente buscado a la BD
        return buscarPro;
		
	}

	@Override
	public void eliminarProducto(TblProductocl3 producto) {
		//establecer la conexion con la unidad de persistencia
				EntityManagerFactory farb= Persistence.createEntityManagerFactory("LP2_CL3_RandolSanchezVillavicencio");
				//gestionar las entidades
		        EntityManager em= farb.createEntityManager();
		        //inicar la transaccion
		        em.getTransaction().begin();
		        //recuperamos el codigo eliminar
		        TblProductocl3 elim = em.merge(producto);
		        //preocedemos a eliminar el registro
		        em.remove(elim);
		        //emitimos un mesnaje  en la consola 
		        System.out.println("CLIENTE ELIIMINADO DE LA BASE DE DATOS ");
		      //confirmamos
		        em.getTransaction().commit();
		        //cerramos
		        em.close();
		        //retornamos el cliente buscado a la BD
		       
		        
		
	}


}
