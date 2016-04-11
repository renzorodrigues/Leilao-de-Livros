package servico;

import java.util.List;

import dao.DaoFactory;
import dao.LivroDao;
import dao.Transaction;
import dominio.Livro;

public class LivroServico {

	private LivroDao dao;
	
	public LivroServico() {
		dao = DaoFactory.criarLivroDao();
	}
	
	public void inserirAtualizar(Livro x) {
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
	
	public void excluir(Livro x) {
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
	
	public Livro buscar(int cod) {
		return dao.buscar(cod);
	}
	
	public List<Livro> buscarTodos() {
		return dao.buscarTodos();
	}
}
