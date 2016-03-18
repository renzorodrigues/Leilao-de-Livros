package dao;

import java.util.List;

import dominio.Usuario;

public interface UsuarioDao {

	public void inserirAtualizar(Usuario x);
	public void excluir(Usuario x);
	public Usuario buscar(int cod);
	public List<Usuario> buscarTodos();
}
