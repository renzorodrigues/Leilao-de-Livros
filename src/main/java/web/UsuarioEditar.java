package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dominio.Usuario;
import servico.UsuarioServico;

@WebServlet("/usuarios/editar")
public class UsuarioEditar extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static String DESTINO = "/usuarios/formEditar.jsp";

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UsuarioServico uS = new UsuarioServico();
		int cod = Integer.parseInt(request.getParameter("cod"));
		Usuario user = uS.buscar(cod);
		
		request.setAttribute("item", user);
		request.getRequestDispatcher(DESTINO).forward(request, response);
	}
}
