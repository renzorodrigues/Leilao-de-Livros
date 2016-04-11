package servico;

import java.util.List;

import dao.CategoriaDao;
import dao.DaoFactory;
import dao.Transaction;
import dominio.Categoria;

public class CategoriaServico {

	private CategoriaDao dao;
	
	public CategoriaServico() {
		dao = DaoFactory.criarCategoriaDao();
	}
	
	public void inserirAtualizar(Categoria x) {
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
	
	public void excluir(Categoria x) {
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
	
	public Categoria buscar(int cod) {
		return dao.buscar(cod);
	}
	
	public List<Categoria> buscarTodos() {
		return dao.buscarTodos();
	}
}
