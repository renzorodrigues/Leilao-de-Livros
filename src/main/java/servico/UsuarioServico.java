package servico;

import java.util.List;

import dao.UsuarioDao;
import dao.DaoFactory;
import dao.impl.EM;
import dominio.Usuario;

public class UsuarioServico {

	private UsuarioDao dao;
	
	public UsuarioServico() {
		dao = DaoFactory.criarUsuarioDao();
	}
	
	public void inserirAtualizar(Usuario x) {
		EM.getLocalEm().getTransaction().begin();
		dao.inserirAtualizar(x);
		EM.getLocalEm().getTransaction().commit();
	}
	
	public void excluir(Usuario x) {
		EM.getLocalEm().getTransaction().begin();
		dao.excluir(x);
		EM.getLocalEm().getTransaction().commit();
	}
	
	public Usuario buscar(int cod) {
		return dao.buscar(cod);
	}
	
	public List<Usuario> buscarTodos() {
		return dao.buscarTodos();
	}
}
