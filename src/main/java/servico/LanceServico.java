package servico;

import java.util.List;

import dao.DaoFactory;
import dao.LanceDao;
import dao.LeilaoDao;
import dao.Transaction;
import dominio.Lance;
import dominio.Leilao;

public class LanceServico {

	private LanceDao dao;
	private LeilaoDao leilaoDao;
	
	public LanceServico() {
		dao = DaoFactory.criarLanceDao();
		leilaoDao = DaoFactory.criarLeilaoDao();
	}
	
	public void inserir(Lance x) throws ServicoException {
		try{
			Leilao le = leilaoDao.buscar(x.getLeilao().getCodLeilao());
			
			if(le.getLances().isEmpty()){
				if(le.getValorMinimo().compareTo(x.getValor()) > 0){
					throw new ServicoException("O valor do lance é menor que o valor mínimo do leilão", 1);
				}
			}			
			else {
				Lance aux = le.maiorLance();
				System.out.println(x.getValor()+", "+aux.getValor());
				if(x.getValor().compareTo(aux.getValor()) < 0){
					throw new ServicoException("Já existe um valor maior registrado para este leilão!", 1);
				}
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
