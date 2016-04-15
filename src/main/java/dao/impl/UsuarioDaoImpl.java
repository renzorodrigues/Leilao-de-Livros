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
		String jpql = "SELECT x FROM Usuario x ORDER BY x.nome";
		Query query = em.createQuery(jpql);
		return query.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Usuario buscaNomeExato(String nome){
		String jpql = "SELECT x FROM Usuario x WHERE x.nome = :p1";
		Query query = em.createQuery(jpql);
		query.setParameter("p1", nome);
		List<Usuario> aux = query.getResultList();
		return (aux.size() > 0) ? aux.get(0) : null;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Usuario buscaNomeExatoDiferente(Integer codigo, String nome){
		String jpql = "SELECT x FROM Usuario x WHERE x.codArtista <> :p0 AND x.nome = :p1";
		Query query = em.createQuery(jpql);
		query.setParameter("p1", nome);
		query.setParameter("p0", nome);
		List<Usuario> aux = query.getResultList();
		return (aux.size() > 0) ? aux.get(0) : null;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Usuario> buscarPorNome(String trecho){
		String jpql = "SELECT x FROM Usuario x WHERE x.nome LIKE :p1";
		Query query = em.createQuery(jpql);
		query.setParameter("p1", "%"+trecho+"%");
		return query.getResultList();
		
	}

}
