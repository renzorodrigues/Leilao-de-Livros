package servico;

import java.util.List;

import dao.DaoFactory;
import dao.Transaction;
import dao.UsuarioDao;
import dominio.Usuario;

public class UsuarioServico {

	private UsuarioDao dao;
	
	public UsuarioServico() {
		dao = DaoFactory.criarUsuarioDao();
	}
	
	public void inserirAtualizar(Usuario x) {
		try{
			Transaction.begin();
			dao.inserirAtualizar(x);
			Transaction.commit();
		}
		catch(RuntimeException e){
			if(Transaction.isActive()){
				Transaction.rollback();
			}
			System.out.println("Erro: " + e.getMessage());
		}
	}
	
	public void excluir(Usuario x) {
		try{
			Transaction.begin();
			dao.excluir(x);
			Transaction.commit();
		}
		catch(RuntimeException e){
			if(Transaction.isActive()){
				Transaction.rollback();
			}
			System.out.println("Erro: " + e.getMessage());
		}
	}
	
	public Usuario buscar(int cod) {
		return dao.buscar(cod);
	}
	
	public List<Usuario> buscarTodos() {
		return dao.buscarTodos();
	}
}
