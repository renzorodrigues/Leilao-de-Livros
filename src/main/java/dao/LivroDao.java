package dao;

import java.util.List;

import dominio.Livro;

public interface LivroDao {

	public void inserirAtualizar(Livro x);
	public void excluir(Livro x);
	public Livro buscar(int cod);
	public List<Livro> buscarTodos();
	
	public List<Livro> buscarPorTituloEdicao(String titulo, int edicaoMin, int edicaoMax);
}
