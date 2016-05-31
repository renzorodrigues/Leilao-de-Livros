package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dominio.Livro;
import servico.LivroServico;

@WebServlet("/livro/detalhes")
public class LivroDetalhes extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static String DESTINO = "/livro/detalhes.jsp";
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		LivroServico lS = new LivroServico();
		int cod = Integer.parseInt(request.getParameter("cod"));
		Livro livro = lS.buscar(cod);
			
		request.setAttribute("item", livro);
		request.getRequestDispatcher(DESTINO).forward(request, response);		
	}
}
