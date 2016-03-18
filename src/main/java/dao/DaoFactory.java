package dao;

import dao.impl.CategoriaDaoImpl;
import dao.impl.LanceDaoImpl;
import dao.impl.LeilaoDaoImpl;
import dao.impl.LivroDaoImpl;
import dao.impl.UsuarioDaoImpl;

public class DaoFactory {

	public static UsuarioDao criarUsuarioDao() {
		return new UsuarioDaoImpl();
	}

	public static LivroDao criarLivroDao() {
		return new LivroDaoImpl();
	}

	public static CategoriaDao criarCategoriaDao() {
		return new CategoriaDaoImpl();
	}
	
	public static LeilaoDao criarLeilaoDao() {
		return new LeilaoDaoImpl();
	}
	
	public static LanceDao criarLanceDao() {
		return new LanceDaoImpl();
	}
}
