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

}
