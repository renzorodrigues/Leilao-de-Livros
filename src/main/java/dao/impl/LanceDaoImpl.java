package dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import dao.LanceDao;
import dominio.Lance;

public class LanceDaoImpl implements LanceDao {

	private EntityManager em;

	public LanceDaoImpl() {
		this.em = EM.getLocalEm();
	}
	
	@Override
	public void inserirAtualizar(Lance x) {
		if (x.getCodLance() != null) {
			x = em.merge(x);
		}
		em.persist(x);
	}

	@Override
	public void excluir(Lance x) {
		x = em.merge(x);
		em.remove(x);
	}

	@Override
	public Lance buscar(int cod) {
		return em.find(Lance.class, cod);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Lance> buscarTodos() {
		String jpql = "SELECT x FROM Lance x";
		Query query = em.createQuery(jpql);
		return query.getResultList();
	}
}
