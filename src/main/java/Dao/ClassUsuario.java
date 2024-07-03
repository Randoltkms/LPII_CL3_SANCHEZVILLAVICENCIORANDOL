package Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Interfaces.Iusuario;
import model.TblUsuariocl3;

public class ClassUsuario implements Iusuario {

	@Override
	public void RegistrarUsuario(TblUsuariocl3 Usuario) {
		
		//establecer la cadena de conexion con la unidad de persistencia
		EntityManagerFactory fabr=Persistence.createEntityManagerFactory("LP2_CL3_RandolSanchezVillavicencio");
		//gestionar las entidades
		EntityManager em=fabr.createEntityManager();
		//iniciamos la transaccion
		em.getTransaction().begin();
		//registramos
		em.persist(Usuario);
		//emitimos mensaje por consola
		System.out.print("Usuario registrado en la BD");
		//configuramos
		em.getTransaction().commit();
		//cerramos
		em.close();
		
	}

	@Override
	public List<TblUsuariocl3> ListadoUsuario() {
		// TODO Auto-generated method stub
				//establecemos conexion con la unidad de persistencia
						EntityManagerFactory fabr=Persistence.createEntityManagerFactory("LP2_CL3_RandolSanchezVillavicencio");
						//gestionar las entidades
						EntityManager em=fabr.createEntityManager();
						//iniciamos la transaccion
						em.getTransaction().begin();
						//recuperamos el listado de cliente de la BD
						//aplicamos consultas JPQL, el metodo createquery(), sirve para hacer consultas dinamicas
						List<TblUsuariocl3> listado=em.createQuery("select c from TblUsuariocl3 c",TblUsuariocl3.class).getResultList();
						//confirmamos
						em.getTransaction().commit();
						//cerramos
						em.close();
						//recuperamos el cliente buscado de la BD
						return listado;
	}

	@Override
	public TblUsuariocl3 ValidarUsuario(String usuario, String contraseña) {
		 EntityManagerFactory fabr=Persistence.createEntityManagerFactory("LP2_CL3_RandolSanchezVillavicencio");  
	        EntityManager em=fabr.createEntityManager();  
	        TblUsuariocl3 usu = null;
	        try {
	            em.getTransaction().begin();
	            usu = em.createQuery("SELECT u FROM TblUsuariocl3 u WHERE u.usuariocl3 = :usuario AND u.passwordcl3 = :contraseña", TblUsuariocl3.class)
	                    .setParameter("usuario", usuario)
	                    .setParameter("contraseña", contraseña)
	                    .getSingleResult();
	            em.getTransaction().commit();
	        } catch (Exception e) {
	            em.getTransaction().rollback();
	        } finally {
	            em.close();
	        }
	        return usu;
	}

}
