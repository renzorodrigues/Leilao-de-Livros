package dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import dao.CategoriaDao;
import dominio.Categoria;

public class CategoriaDaoImpl implements CategoriaDao {

	private EntityManager em;

	public CategoriaDaoImpl() {
		this.em = EM.getLocalEm();
	}
	
	@Override
	public void inserirAtualizar(Categoria x) {
		if (x.getCodCategoria() != null) {
			x = em.merge(x);
		}
		em.persist(x);
	}

	@Override
	public void excluir(Categoria x) {
		x = em.merge(x);
		em.remove(x);
	}

	@Override
	public Categoria buscar(int cod) {
		return em.find(Categoria.class, cod);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Categoria> buscarTodos() {
		String jpql = "SELECT x FROM Categoria x";
		Query query = em.createQuery(jpql);
		return query.getResultList();
	}

}
