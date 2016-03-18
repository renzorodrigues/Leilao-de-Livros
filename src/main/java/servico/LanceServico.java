package servico;

import java.util.List;

import dao.LanceDao;
import dao.DaoFactory;
import dao.impl.EM;
import dominio.Lance;

public class LanceServico {

	private LanceDao dao;
	
	public LanceServico() {
		dao = DaoFactory.criarLanceDao();
	}
	
	public void inserirAtualizar(Lance x) {
		EM.getLocalEm().getTransaction().begin();
		dao.inserirAtualizar(x);
		EM.getLocalEm().getTransaction().commit();
	}
	
	public void excluir(Lance x) {
		EM.getLocalEm().getTransaction().begin();
		dao.excluir(x);
		EM.getLocalEm().getTransaction().commit();
	}
	
	public Lance buscar(int cod) {
		return dao.buscar(cod);
	}
	
	public List<Lance> buscarTodos() {
		return dao.buscarTodos();
	}
}
