package web;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;

import dominio.Usuario;

public class Instanciar {

	public static Usuario usuario(HttpServletRequest request){
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Usuario aux = new Usuario();
		String str;
		
		str = request.getParameter("codUsuario");
		if(str != null && !str.isEmpty()){
			try {
				aux.setCodUsuario(Integer.parseInt(str));
			}
			catch (NumberFormatException e){
				e.printStackTrace();
			}
		}
		
		str = request.getParameter("nome");
		if(str != null && !str.isEmpty()){
			aux.setNome(str);
		}
		
		str = request.getParameter("email");
		if(str != null && !str.isEmpty()){
			aux.setEmail(str);
		}
		
		str = request.getParameter("cpf");
		if(str != null && !str.isEmpty()){
			aux.setCpf(str);
		}
		
		str = request.getParameter("nascimento");
		if(str != null && !str.isEmpty()){
			try {
				aux.setNascimento(sdf.parse(str));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		str = request.getParameter("renda");
		if(str != null && !str.isEmpty()){
			try {
				aux.setRenda(new BigDecimal(str));
			}
			catch (NumberFormatException e){
				e.printStackTrace();
			}
		}
		
		return aux;
	}
	
}
