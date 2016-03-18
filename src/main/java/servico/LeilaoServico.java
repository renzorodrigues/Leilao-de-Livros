package servico;

import java.util.List;

import dao.LeilaoDao;
import dao.DaoFactory;
import dao.impl.EM;
import dominio.Leilao;

public class LeilaoServico {

	private LeilaoDao dao;
	
	public LeilaoServico() {
		dao = DaoFactory.criarLeilaoDao();
	}
	
	public void inserirAtualizar(Leilao x) {
		EM.getLocalEm().getTransaction().begin();
		dao.inserirAtualizar(x);
		EM.getLocalEm().getTransaction().commit();
	}
	
	public void excluir(Leilao x) {
		EM.getLocalEm().getTransaction().begin();
		dao.excluir(x);
		EM.getLocalEm().getTransaction().commit();
	}
	
	public Leilao buscar(int cod) {
		return dao.buscar(cod);
	}
	
	public List<Leilao> buscarTodos() {
		return dao.buscarTodos();
	}
}
