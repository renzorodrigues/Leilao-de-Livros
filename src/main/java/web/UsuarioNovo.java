package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dominio.Usuario;

@WebServlet("/usuarios/novo")
public class UsuarioNovo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static String DESTINO = "/usuarios/formInserir.jsp";

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setAttribute("item", new Usuario());
		request.getRequestDispatcher(DESTINO).forward(request, response);
	}
}
