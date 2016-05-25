package web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dominio.Livro;
import servico.LivroServico;

@WebServlet("/livro/resultado")
public class LivroResultado extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static String DESTINO = "/livro/resultadoBusca.jsp";

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		LivroServico lS = new LivroServico();
		String titulo = request.getParameter("titulo");
		int edicaoMin = Integer.parseInt(request.getParameter("edicaoMin"));
		int edicaoMax = Integer.parseInt(request.getParameter("edicaoMax"));
		List<Livro> itens = lS.buscarPorTituloEdicao(titulo, edicaoMin, edicaoMax);
		request.setAttribute("itens", itens);
		request.getRequestDispatcher(DESTINO).forward(request, response);	
	}
}
