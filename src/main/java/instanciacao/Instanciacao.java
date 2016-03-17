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

@WebServlet("/Instanciacao")
public class Instanciacao extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
				
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
			
			Lance lance1 = new Lance(null,new BigDecimal("20.00"),user3,leilao1);
			Lance lance2 = new Lance(null,new BigDecimal("25.00"),user2,leilao1);
			Lance lance3 = new Lance(null,new BigDecimal("30.00"),user1,leilao1);
			Lance lance4 = new Lance(null,new BigDecimal("35.00"),user2,leilao1);
			
			Lance lance5 = new Lance(null,new BigDecimal("16.00"),user1,leilao2);
			Lance lance6 = new Lance(null,new BigDecimal("23.00"),user3,leilao2);
			Lance lance7 = new Lance(null,new BigDecimal("25.00"),user2,leilao2);
			Lance lance8 = new Lance(null,new BigDecimal("35.00"),user1,leilao2);
			
			Lance lance9 = new Lance(null,new BigDecimal("28.00"),user2,leilao3);
			Lance lance10 = new Lance(null,new BigDecimal("35.00"),user3,leilao3);
			Lance lance11 = new Lance(null,new BigDecimal("40.00"),user1,leilao3);
			Lance lance12 = new Lance(null,new BigDecimal("45.00"),user3,leilao3);
			
			Lance lance13 = new Lance(null,new BigDecimal("20.00"),user1,leilao4);
			Lance lance14 = new Lance(null,new BigDecimal("24.00"),user3,leilao4);
			Lance lance15 = new Lance(null,new BigDecimal("28.00"),user2,leilao4);
			Lance lance16 = new Lance(null,new BigDecimal("30.00"),user1,leilao4);
			
			Lance lance17 = new Lance(null,new BigDecimal("12.00"),user3,leilao5);
			Lance lance18 = new Lance(null,new BigDecimal("15.00"),user1,leilao5);
			Lance lance19 = new Lance(null,new BigDecimal("20.00"),user2,leilao5);
			Lance lance20 = new Lance(null,new BigDecimal("30.00"),user3,leilao5);
						
			response.getWriter().append("Pronto!");
			
		} catch (ParseException e) {
			response.getWriter().append("Erro ao instanciar data. Instância não criada.");
		}
	}

}