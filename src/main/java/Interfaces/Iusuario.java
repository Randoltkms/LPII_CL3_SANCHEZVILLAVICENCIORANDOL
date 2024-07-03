package Interfaces;

import java.util.List;

import model.TblUsuariocl3;;

public interface Iusuario {
	public void RegistrarUsuario(TblUsuariocl3 Usuario);	
	public List<TblUsuariocl3>ListadoUsuario();
	public TblUsuariocl3 ValidarUsuario(String usuario, String contraseña);

}
