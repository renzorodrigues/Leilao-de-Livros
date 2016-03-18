package servico;

import java.util.List;

import dao.DaoFactory;
import dao.LivroDao;
import dao.impl.EM;
import dominio.Livro;

public class LivroServico {

	private LivroDao dao;
	
	public LivroServico() {
		dao = DaoFactory.criarLivroDao();
	}
	
	public void inserirAtualizar(Livro x) {
		EM.getLocalEm().getTransaction().begin();
		dao.inserirAtualizar(x);
		EM.getLocalEm().getTransaction().commit();
	}
	
	public void excluir(Livro x) {
		EM.getLocalEm().getTransaction().begin();
		dao.excluir(x);
		EM.getLocalEm().getTransaction().commit();
	}
	
	public Livro buscar(int cod) {
		return dao.buscar(cod);
	}
	
	public List<Livro> buscarTodos() {
		return dao.buscarTodos();
	}
}
