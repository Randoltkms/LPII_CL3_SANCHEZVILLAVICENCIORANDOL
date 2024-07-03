package TestEntidades;

import java.util.List;

import Dao.ClassProductoImp;
import model.TblProductocl3;

public class TestEntidadProducto {
	
	public static void main(String[] args){
		//hacemos la respectiva instancia
		TblProductocl3 producto = new TblProductocl3();
		ClassProductoImp crud = new ClassProductoImp();
		
		//asignamos valores						
		/*producto.setNombrecl3("Reloj");
		producto.setPrecioventacl3(2700);
		producto.setPreciocompcl3(2600);
		producto.setEstadocl3("Operativo");
		producto.setDescripcl3("Un buen producto a la muñeca");
						
		crud.RegistrarProducto(producto);*/
			

						
		List<TblProductocl3> listadoprod=crud.ListadoProducto();		
		for(TblProductocl3 listar:listadoprod){							
		System.out.print(
			"-----------------------------------------------" + "\n\n" +
			"-------------------- U N O --------------------" + "\n\n" +
			"Codigo" + "\t\t: "+listar.getIdproductoscl3()+ "\n" +
			"Nombre" + "\t\t: "+listar.getNombrecl3()+ "\n" +
			"P. de venta" + "\t: "+listar.getPrecioventacl3()+ "\n" +
			"P. de compra" + "\t: "+listar.getPreciocompcl3()+ "\n" +
			"Estado" + "\t\t: "+listar.getEstadocl3()+ "\n" +
			"Descripcion" + "\t: "+listar.getDescripcl3()+ "\n\n" +
			"-------------------- F I N --------------------" + "\n\n");
		}
						
				
						
		
				
	}//fin del metodo main

}//fin de la clase