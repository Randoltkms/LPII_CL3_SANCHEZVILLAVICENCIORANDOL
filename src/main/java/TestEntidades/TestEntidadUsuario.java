package TestEntidades;

import java.util.List;

import Dao.ClassUsuario;
import model.TblUsuariocl3;

public class TestEntidadUsuario {

	public static void main(String[] args){
		
		//hacemos la respectiva instancia
		
		TblUsuariocl3 usuario = new TblUsuariocl3();
		ClassUsuario crud = new ClassUsuario();	
		
		
	/*	usuario.setUsuariocl3("RandolSanchez");
		usuario.setPasswordcl3("Pepe");				
		crud.RegistrarUsuario(usuario);*/
			
	
		
				
			List<TblUsuariocl3> listadousu=crud.ListadoUsuario();
			for(TblUsuariocl3 listar:listadousu){			
			System.out.print(
				"-----------------------------------------------" + "\n\n" +
				"-------------------- U N O --------------------" + "\n\n" +
				"Codigo" + "\t\t: "+listar.getIdusuariocl3()+ "\n" +
				"Nombre" + "\t\t: "+listar.getUsuariocl3()+ "\n" +
				"Descripcion" + "\t: "+listar.getPasswordcl3()+ "\n\n" +
				"-------------------- F I N --------------------" + "\n\n");
			}
						
			
						
		
				
	}//fin del metodo main

}//fin de la clase
