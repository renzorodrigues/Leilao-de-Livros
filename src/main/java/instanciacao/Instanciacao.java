package instanciacao;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dominio.Categoria;
import dominio.Lance;
import dominio.Leilao;
import dominio.Livro;
import dominio.Usuario;
import servico.CategoriaServico;
import servico.LanceServico;
import servico.LeilaoServico;
import servico.LivroServico;
import servico.ServicoException;
import servico.UsuarioServico;

@WebServlet("/Instanciacao")
public class Instanciacao extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		CategoriaServico catS = new CategoriaServico();
		LanceServico lanS = new LanceServico();
		LeilaoServico leiS = new LeilaoServico();
		LivroServico livS = new LivroServico();
		UsuarioServico usuS = new UsuarioServico();
				
		try {
		
			Usuario user1 = new Usuario(null,"Renzo","renzors@gmail.com","05015444613",sdf.parse("09/01/1981"),new BigDecimal("1500.00"));
			Usuario user2 = new Usuario(null,"José","jose@gmail.com","03412055590",sdf.parse("19/10/1984"),new BigDecimal("1000.00"));
			Usuario user3 = new Usuario(null,"Ana","ana@yahoo.com","08032166740",sdf.parse("12/05/1983"),new BigDecimal("2000.00"));
			
			Categoria cat1 = new Categoria(null,"Romance");
			Categoria cat2 = new Categoria(null,"Aventura");
			
			Livro livro1 = new Livro(null,"Guerra e Paz","Um clássico russo",3,cat1);
			Livro livro2 = new Livro(null,"O Pequeno Príncipe","Um livro que inspirou milhões",3,cat2);
			Livro livro3 = new Livro(null,"O Senhor dos Anéis","A obra completa",1,cat2);
			
			Leilao leilao1 = new Leilao(null,sdf.parse("05/03/2016"),new BigDecimal("20.00"),true,livro2);
			Leilao leilao2 = new Leilao(null,sdf.parse("09/03/2016"),new BigDecimal("15.00"),true,livro1);
			Leilao leilao3 = new Leilao(null,sdf.parse("11/03/2016"),new BigDecimal("25.00"),true,livro3);
			Leilao leilao4 = new Leilao(null,sdf.parse("12/03/2016"),new BigDecimal("20.00"),false,livro1);
			Leilao leilao5 = new Leilao(null,sdf.parse("14/03/2016"),new BigDecimal("10.00"),false,livro3);

			usuS.inserir(user1);
			usuS.inserir(user2);
			usuS.inserir(user3);
			
			catS.inserirAtualizar(cat1);
			catS.inserirAtualizar(cat2);

			livS.inserirAtualizar(livro1);
			livS.inserirAtualizar(livro2);
			livS.inserirAtualizar(livro3);
			
			leiS.inserirAtualizar(leilao1);
			leiS.inserirAtualizar(leilao2);
			leiS.inserirAtualizar(leilao3);
			leiS.inserirAtualizar(leilao4);
			leiS.inserirAtualizar(leilao5);			
			
			Lance lance;
			lance = new Lance(null,new BigDecimal("20.00"),user3,leilao1);
			lanS.inserir(lance);
			lance = new Lance(null,new BigDecimal("25.00"),user2,leilao1);
			lanS.inserir(lance);
			lance = new Lance(null,new BigDecimal("30.00"),user1,leilao1);
			lanS.inserir(lance);
			lance = new Lance(null,new BigDecimal("35.00"),user2,leilao1);
			lanS.inserir(lance);
			
			lance = new Lance(null,new BigDecimal("16.00"),user1,leilao2);
			lanS.inserir(lance);
			lance = new Lance(null,new BigDecimal("23.00"),user3,leilao2);
			lanS.inserir(lance);
			lance = new Lance(null,new BigDecimal("25.00"),user2,leilao2);
			lanS.inserir(lance);
			lance = new Lance(null,new BigDecimal("35.00"),user1,leilao2);
			lanS.inserir(lance);
			
			lance = new Lance(null,new BigDecimal("28.00"),user2,leilao3);
			lanS.inserir(lance);
			lance = new Lance(null,new BigDecimal("35.00"),user3,leilao3);
			lanS.inserir(lance);
			lance = new Lance(null,new BigDecimal("40.00"),user1,leilao3);
			lanS.inserir(lance);
			lance = new Lance(null,new BigDecimal("45.00"),user3,leilao3);
			lanS.inserir(lance);
			
			lance = new Lance(null,new BigDecimal("20.00"),user1,leilao4);
			lanS.inserir(lance);
			lance = new Lance(null,new BigDecimal("24.00"),user3,leilao4);
			lanS.inserir(lance);
			lance = new Lance(null,new BigDecimal("28.00"),user2,leilao4);
			lanS.inserir(lance);
			lance = new Lance(null,new BigDecimal("30.00"),user1,leilao4);
			lanS.inserir(lance);
			
			lance = new Lance(null,new BigDecimal("12.00"),user3,leilao5);
			lanS.inserir(lance);
			lance = new Lance(null,new BigDecimal("15.00"),user1,leilao5);
			lanS.inserir(lance);
			lance = new Lance(null,new BigDecimal("20.00"),user2,leilao5);
			lanS.inserir(lance);
			lance = new Lance(null,new BigDecimal("30.00"),user3,leilao5);
			lanS.inserir(lance);
			
			response.getWriter().append("Pronto!");
			
			/*
			response.getWriter().println("O vencedor do leilão foi "+leilao1.vencedor().getNome());
			response.getWriter().println("O maior lance do leilão foi de R$"+leilao2.maiorLance().getValor());
			response.getWriter().println("Leilões que o usuário "+user1.getNome()+" venceu: "+user1.leiloesQueVenceu());
			*/
			
			/*Usuario user4 = new Usuario(null,"Gabriel","gabriel@yahoo.com","04023454320",sdf.parse("23/06/1985"),new BigDecimal("4000.00"));
			Categoria cat1Teste = new Categoria(null,"Romance");
			Livro livro1Teste = new Livro(null,"Guerra e Paz","Um clássico russo",3,cat1);
			Leilao leilao2Teste = new Leilao(null,sdf.parse("09/03/2016"),new BigDecimal("15.00"),true,livro1);
			Lance lance21Teste = new Lance(null,new BigDecimal("20.00"),user4,leilao2);
			lanS.inserir(lance21Teste);*/
			
			
		} 
		catch (ParseException e) {
			response.getWriter().append("Erro ao instanciar data. Instância não criada.");
		} 
		catch (ServicoException e){
			response.getWriter().append("Erro! " + e.getMessage());
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
