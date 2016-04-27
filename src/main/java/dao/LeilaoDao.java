package dao;

import java.util.List;

import dominio.Leilao;
import dominio.Livro;

public interface LeilaoDao {

	public void inserirAtualizar(Leilao x);
	public void excluir(Leilao x);
	public Leilao buscar(int cod);
	public List<Leilao> buscarTodos();
	
	public List<Leilao> buscarLeiloesNaoEncerrados(Livro x);
}
