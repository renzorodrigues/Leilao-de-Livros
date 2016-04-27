package servico;

import java.util.List;

import dao.DaoFactory;
import dao.LeilaoDao;
import dao.Transaction;
import dominio.Leilao;
import dominio.Livro;

public class LeilaoServico {

	private LeilaoDao dao;
	
	public LeilaoServico() {
		dao = DaoFactory.criarLeilaoDao();
	}
	
	public void inserirAtualizar(Leilao x) {
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
	
	public void excluir(Leilao x) {
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
	
	public Leilao buscar(int cod) {
		return dao.buscar(cod);
	}
	
	public List<Leilao> buscarTodos() {
		return dao.buscarTodos();
	}
	
	public List<Leilao> buscarLeiloesNaoEncerrados(Livro x){
		return dao.buscarLeiloesNaoEncerrados(x);
	}
}
