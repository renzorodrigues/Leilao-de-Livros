package servico;

import java.util.List;
import dao.DaoFactory;
import dao.LanceDao;
import dao.Transaction;
import dominio.Lance;

public class LanceServico {

	private LanceDao dao;
	
	public LanceServico() {
		dao = DaoFactory.criarLanceDao();
	}
	
	public void inserir(Lance x) throws ServicoException {
		try{
			Lance aux = dao.verificaValor(x.getValor());
			if(x.getValor().compareTo(aux.getValor()) < 0){
				throw new ServicoException("Já existe um valor maior registrado para este leilão!", 1);
			}
			
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
	
	public void atualizar(Lance x) {
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
	
	public void excluir(Lance x) {
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
	
	public Lance buscar(int cod) {
		return dao.buscar(cod);
	}
	
	public List<Lance> buscarTodos() {
		return dao.buscarTodos();
	}
}
