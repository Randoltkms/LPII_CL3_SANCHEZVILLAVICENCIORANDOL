package Controlador;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.ClassUsuario;
import model.TblUsuariocl3;

/**
 * Servlet implementation class LoginServle
 */
public class LoginServle extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        out.println("Hola desde LoginServle!");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String usuario = request.getParameter("usuario");
        String contraseņa = request.getParameter("contraseņa");

        ClassUsuario crud = new ClassUsuario();
        TblUsuariocl3 usu = crud.ValidarUsuario(usuario, contraseņa);

        if (usu != null) {
            HttpSession session = request.getSession();
            session.setAttribute("usuario", usu);
            response.sendRedirect("RegistrarProducto.jsp");
        } else {
            request.setAttribute("errorMessage", "Usuario o contraseņa incorrectos");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
    }
}
