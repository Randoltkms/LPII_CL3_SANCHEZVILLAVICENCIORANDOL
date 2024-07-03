package Controlador;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import Dao.ClassProductoImp;
import model.TblProductocl3;

/**
 * Servlet implementation class ControladorProducto
 */
public class ControladorProducto extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControladorProducto() {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("usuario") == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        TblProductocl3 producto = new TblProductocl3();
        ClassProductoImp crud = new ClassProductoImp();

        String accion = request.getParameter("accion");
        if (accion != null) {
            switch (accion) {
                case "Modificar":
                    String codParam = request.getParameter("cod");
                    if (codParam != null && !codParam.isEmpty()) {
                        try {
                            int codigo = Integer.parseInt(codParam);
                            producto.setIdproductoscl3(codigo);         
                            TblProductocl3 BuscarProducto = crud.BuscarProducto(producto);
                            // enviar los valores buscados por codigo de la BD al formulario Actualizar
                            request.setAttribute("codigo", BuscarProducto.getIdproductoscl3());
                            request.setAttribute("nombre", BuscarProducto.getNombrecl3());
                            request.setAttribute("descripcion", BuscarProducto.getDescripcl3());
                            request.setAttribute("estado", BuscarProducto.getEstadocl3());
                            request.setAttribute("venta", BuscarProducto.getPrecioventacl3());
                            request.setAttribute("compra", BuscarProducto.getPreciocompcl3());
                            request.getRequestDispatcher("/ActualizarProducto.jsp").forward(request, response);
                        } catch (NumberFormatException e) {
                            e.printStackTrace(); // Manejo de la excepción si ocurre un error al convertir a entero
                            // Aquí puedes redirigir o mostrar algún mensaje de error si es necesario
                        }
                    } else {
                        // Manejo si el parámetro "cod" no está presente en la solicitud
                        // Puedes lanzar un error, redirigir, o tomar otra acción según tu caso
                    }
                    break;

                case "Eliminar":
                    String codEliminar = request.getParameter("cod");
                    if (codEliminar != null && !codEliminar.isEmpty()) {
                        int codigoEliminar = Integer.parseInt(codEliminar);
                        producto.setIdproductoscl3(codigoEliminar); 
                        // invocamos al metodo eliminar
                        crud.eliminarProducto(producto);
                        // refrescar el listado 
                        List<TblProductocl3> listadoProductos = crud.ListadoProducto();
                        request.setAttribute("listadoproductos", listadoProductos);
                        // redireccionar
                        request.getRequestDispatcher("/listadoProductos.jsp").forward(request, response);
                    } else {
                        // Manejo si el parámetro "cod" no está presente en la solicitud
                        // Puedes lanzar un error, redirigir, o tomar otra acción según tu caso
                    }
                    break;

                case "Listar":    
                    List<TblProductocl3> listadoProductosListar = crud.ListadoProducto();
                    request.setAttribute("listadoproductos", listadoProductosListar);
                    request.getRequestDispatcher("/listadoProductos.jsp").forward(request, response);
                    break;
            }
        }
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Recuperamos los valores del formulario
        String codigo = request.getParameter("codigo");
        String nombre = request.getParameter("nombre");
        String pventa = request.getParameter("venta");
        String pcompra = request.getParameter("compra");
        String estado = request.getParameter("estado");
        String descripcion = request.getParameter("descripcion");

        List<TblProductocl3> listadoproducto = null;

        // Instanciamos las respectivas entidades y el DAO
        TblProductocl3 producto = new TblProductocl3();
        ClassProductoImp crud = new ClassProductoImp();

        // Asignamos los valores al objeto producto
        producto.setNombrecl3(nombre);
        producto.setPrecioventacl3(Double.parseDouble(pventa)); // Convertimos a Double
        producto.setPreciocompcl3(Double.parseDouble(pcompra)); // Convertimos a Double
        producto.setEstadocl3(estado);
        producto.setDescripcl3(descripcion);

        // Determinamos si es una operación de actualización o inserción
        if (codigo != null && !codigo.isEmpty()) {
            // Actualizamos el producto existente
            int cod = Integer.parseInt(codigo);
            producto.setIdproductoscl3(cod);
            crud.ActualizarProducto(producto);
            // Actualizamos el listado de productos
            listadoproducto = crud.ListadoProducto();
        } else {
            // Registramos un nuevo producto
            crud.RegistrarProducto(producto);
            // Actualizamos el listado de productos
            listadoproducto = crud.ListadoProducto();
        }

        // Enviamos el listado actualizado de productos a la vista
        request.setAttribute("listadoproductos", listadoproducto);
        // Redireccionamos a la página de listado de productos
        request.getRequestDispatcher("/listadoProductos.jsp").forward(request, response);
    }
}
