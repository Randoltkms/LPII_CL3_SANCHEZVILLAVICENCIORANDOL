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
        // TODO Auto-generated constructor stub
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
		TblProductocl3 producto=new TblProductocl3();
		ClassProductoImp crud=new ClassProductoImp();
		
		List<TblProductocl3> listadoproducto=crud.ListadoProducto();
		//invocamos el listado de productos para la vista
		request.setAttribute("listadoproductos", listadoproducto);
		//redirecionamos
		request.getRequestDispatcher("/listadoProductos.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
	    if (session == null || session.getAttribute("usuario") == null) {
	        response.sendRedirect("login.jsp");
	        return;
	    }
		String nombre=request.getParameter("nombre");
		String pventa=request.getParameter("venta");
		String pcompra=request.getParameter("compra");
		String estado=request.getParameter("estado");
		String descripcion=request.getParameter("descripcion");
		
		Double venta = null;
		Double compra = null;
		try{
			venta=Double.parseDouble(pventa);
			compra=Double.parseDouble(pcompra);
		}
		catch(Exception e){
			e.fillInStackTrace();
			
			request.setAttribute("erroMessage", "Los valores de venta y compra deben ser números válidos.");
			request.getRequestDispatcher("/RegistrarProducto.jsp").forward(request, response);
	        return;
		}
		
		//instanciar las respectivas entidades
		TblProductocl3 productos=new TblProductocl3();
		ClassProductoImp crud=new ClassProductoImp();
		//asignamos valores
		productos.setNombrecl3(nombre);
		productos.setPrecioventacl3(venta);
		productos.setPreciocompcl3(compra);
		productos.setEstadocl3(estado);
		productos.setDescripcl3(descripcion);
		//invocamos al metodo registrar
		crud.RegistrarProducto(productos);
		
		List<TblProductocl3> listadoproducto=crud.ListadoProducto();
		//invocamos el listado de productos para la vista
		request.setAttribute("listadoproductos", listadoproducto);
		//redirecionamos
		request.getRequestDispatcher("/listadoProductos.jsp").forward(request, response);
		
		
	}

}