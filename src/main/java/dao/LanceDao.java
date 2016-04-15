package dao;

import java.math.BigDecimal;
import java.util.List;

import dominio.Lance;

public interface LanceDao {

	public void inserirAtualizar(Lance x);
	public void excluir(Lance x);
	public Lance buscar(int cod);
	public List<Lance> buscarTodos();
	
	public Lance verificaValor(BigDecimal valor);
}
