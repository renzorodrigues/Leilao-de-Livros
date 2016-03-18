package servico;

import java.util.List;

import dao.CategoriaDao;
import dao.DaoFactory;
import dao.impl.EM;
import dominio.Categoria;

public class CategoriaServico {

	private CategoriaDao dao;
	
	public CategoriaServico() {
		dao = DaoFactory.criarCategoriaDao();
	}
	
	public void inserirAtualizar(Categoria x) {
		EM.getLocalEm().getTransaction().begin();
		dao.inserirAtualizar(x);
		EM.getLocalEm().getTransaction().commit();
	}
	
	public void excluir(Categoria x) {
		EM.getLocalEm().getTransaction().begin();
		dao.excluir(x);
		EM.getLocalEm().getTransaction().commit();
	}
	
	public Categoria buscar(int cod) {
		return dao.buscar(cod);
	}
	
	public List<Categoria> buscarTodos() {
		return dao.buscarTodos();
	}
}
