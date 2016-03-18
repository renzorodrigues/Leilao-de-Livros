package dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import dao.UsuarioDao;
import dominio.Usuario;

public class UsuarioDaoImpl implements UsuarioDao {

	private EntityManager em;

	public UsuarioDaoImpl() {
		this.em = EM.getLocalEm();
	}
	
	@Override
	public void inserirAtualizar(Usuario x) {
		if (x.getCodUsuario() != null) {
			x = em.merge(x);
		}
		em.persist(x);
	}

	@Override
	public void excluir(Usuario x) {
		x = em.merge(x);
		em.remove(x);
	}

	@Override
	public Usuario buscar(int cod) {
		return em.find(Usuario.class, cod);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Usuario> buscarTodos() {
		String jpql = "SELECT x FROM Usuario x";
		Query query = em.createNamedQuery(jpql);
		return query.getResultList();
	}

}
