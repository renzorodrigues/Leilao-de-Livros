package dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import dao.LeilaoDao;
import dominio.Leilao;

public class LeilaoDaoImpl implements LeilaoDao {

	private EntityManager em;

	public LeilaoDaoImpl() {
		this.em = EM.getLocalEm();
	}
	
	@Override
	public void inserirAtualizar(Leilao x) {
		if (x.getCodLeilao() != null) {
			x = em.merge(x);
		}
		em.persist(x);
	}

	@Override
	public void excluir(Leilao x) {
		x = em.merge(x);
		em.remove(x);
	}

	@Override
	public Leilao buscar(int cod) {
		return em.find(Leilao.class, cod);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Leilao> buscarTodos() {
		String jpql = "SELECT x FROM Leilao x";
		Query query = em.createQuery(jpql);
		return query.getResultList();
	}

}
