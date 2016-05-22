package web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dominio.Usuario;
import servico.ServicoException;
import servico.UsuarioServico;
import servico.ValidacaoException;

@WebServlet("/usuarios/inserir")
public class UsuarioInserir extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static String DESTINO = "/usuarios/listar.jsp";
	private static String FORM = "/usuarios/formInserir.jsp";
	private static String ERRO = "/publico/erro.jsp";
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UsuarioServico uS = new UsuarioServico();
		Usuario x = Instanciar.usuario(request);
		try {
			uS.validar(x);
			uS.inserir(x);
			List<Usuario> itens = uS.buscarTodos();
			request.setAttribute("itens", itens);
			request.getRequestDispatcher(DESTINO).forward(request, response);
		} catch (ServicoException e) {
			// TODO Auto-generated catch block
			request.setAttribute("msg", e.getMessage());
			request.getRequestDispatcher(ERRO).forward(request, response);
		} catch (ValidacaoException e) {
			// TODO Auto-generated catch block
			request.setAttribute("erros", e.getErros());
			request.setAttribute("item", x);
			request.getRequestDispatcher(FORM).forward(request, response);
		}
	}
}
