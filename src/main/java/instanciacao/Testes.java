package instanciacao;

import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dominio.Leilao;
import servico.CategoriaServico;
import servico.LanceServico;
import servico.LeilaoServico;
import servico.LivroServico;
import servico.UsuarioServico;

@WebServlet("/Testes")
public class Testes extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		CategoriaServico catS = new CategoriaServico();
		LanceServico lanS = new LanceServico();
		LeilaoServico leiS = new LeilaoServico();
		LivroServico livS = new LivroServico();
		UsuarioServico usuS = new UsuarioServico();
				
		Leilao x = leiS.buscar(1);
		System.out.println(x);
		System.out.println(x.getLances().size());
		if (x.vencedor() == null) {
			System.out.println("Nao tem vencedor");
		}
		else {
			System.out.println("Vencedor: " + x.vencedor());
		}
		
		
		/*CategoriaServico catS = new CategoriaServico();
		LanceServico lanS = new LanceServico();
		LeilaoServico leiS = new LeilaoServico();
		LivroServico livS = new LivroServico();
		UsuarioServico usuS = new UsuarioServico();
		
		Leilao x = leiS.buscar(4);
		response.getWriter().println(x.vencedor());
		
		Usuario user = usuS.buscar(1);
		response.getWriter().println(user.leiloesQueVenceu());*/
		
	}

}
