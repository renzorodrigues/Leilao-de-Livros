package dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import dao.LivroDao;
import dominio.Livro;

public class LivroDaoImpl implements LivroDao {

	private EntityManager em;

	public LivroDaoImpl() {
		this.em = EM.getLocalEm();
	}
	
	@Override
	public void inserirAtualizar(Livro x) {
		if (x.getCodLivro() != null) {
			x = em.merge(x);
		}
		em.persist(x);
	}

	@Override
	public void excluir(Livro x) {
		x = em.merge(x);
		em.remove(x);
	}

	@Override
	public Livro buscar(int cod) {
		return em.find(Livro.class, cod);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Livro> buscarTodos() {
		String jpql = "SELECT x FROM Livro x";
		Query query = em.createNamedQuery(jpql);
		return query.getResultList();
	}

}
