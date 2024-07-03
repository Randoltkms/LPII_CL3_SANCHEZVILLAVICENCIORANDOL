package TestEntidades;

import java.util.List;

import Dao.ClassProductoImp;
import model.TblProductocl3;

public class TestEntidadProducto {
    
    public static void main(String[] args){
        // Creamos una instancia del DAO
        ClassProductoImp crud = new ClassProductoImp();
        
        // Ejemplo de registro de un producto (comentado para evitar registros duplicados)
        /*TblProductocl3 producto = new TblProductocl3();
        producto.setNombrecl3("Reloj");
        producto.setPrecioventacl3(2700);
        producto.setPreciocompcl3(2600);
        producto.setEstadocl3("Operativo");
        producto.setDescripcl3("Un buen producto a la muñeca");
        
        crud.RegistrarProducto(producto);*/
        
        // Obtener y listar productos
        List<TblProductocl3> listadoprod = crud.ListadoProducto();
        
        // Mostrar listado antes de la actualización
        System.out.println("---- Listado de Productos Antes de Actualizar ----");
        mostrarProductos(listadoprod);
        
        // Supongamos que queremos actualizar el primer producto de la lista
        if (!listadoprod.isEmpty()) {
            TblProductocl3 productoAActualizar = listadoprod.get(0);
            
            // Modificamos algunas propiedades
            productoAActualizar.setNombrecl3("Reloj Actualizado");
            productoAActualizar.setPrecioventacl3(2800);
            productoAActualizar.setPreciocompcl3(2700);
            productoAActualizar.setEstadocl3("Operativo");
            productoAActualizar.setDescripcl3("Descripción actualizada");
            
            // Llamamos al método para actualizar
            crud.ActualizarProducto(productoAActualizar);
        }
        
        // Obtener y listar productos nuevamente para verificar la actualización
        listadoprod = crud.ListadoProducto();
        
        // Mostrar listado después de la actualización
        System.out.println("---- Listado de Productos Después de Actualizar ----");
        mostrarProductos(listadoprod);
    }
    
    // Método para mostrar la lista de productos
    private static void mostrarProductos(List<TblProductocl3> listadoprod) {
        for (TblProductocl3 listar : listadoprod) {                           
            System.out.println("-----------------------------------------------");
            System.out.println("-------------------- U N O --------------------");
            System.out.println("Codigo\t\t: " + listar.getIdproductoscl3());
            System.out.println("Nombre\t\t: " + listar.getNombrecl3());
            System.out.println("P. de venta\t: " + listar.getPrecioventacl3());
            System.out.println("P. de compra\t: " + listar.getPreciocompcl3());
            System.out.println("Estado\t\t: " + listar.getEstadocl3());
            System.out.println("Descripcion\t: " + listar.getDescripcl3());
            System.out.println("-------------------- F I N --------------------\n");
        }
    }

}// fin de la clase
