package dominio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Categoria implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer codCategoria;
	private String descricao;
	
	private List<Livro> livros;
	
	public Categoria() {
		this.livros = new ArrayList<>();
	}

	public Categoria(Integer codCategoria, String descricao) {
		this.codCategoria = codCategoria;
		this.descricao = descricao;
		this.livros = new ArrayList<>();
	}

	public Integer getCodCategoria() {
		return codCategoria;
	}

	public void setCodCategoria(Integer codCategoria) {
		this.codCategoria = codCategoria;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<Livro> getLivros() {
		return livros;
	}

	public void setLivros(List<Livro> livros) {
		this.livros = livros;
	}
	
	public void addLivro(Livro x) {
		this.livros.add(x);
		x.setCategoria(this);
	}
	
	public void removeLivro(Livro x) {
		this.livros.remove(x);
	}

	@Override
	public String toString() {
		return "Categoria [codCategoria=" + codCategoria + ", descricao=" + descricao + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codCategoria == null) ? 0 : codCategoria.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Categoria other = (Categoria) obj;
		if (codCategoria == null) {
			if (other.codCategoria != null)
				return false;
		} else if (!codCategoria.equals(other.codCategoria))
			return false;
		return true;
	}
}
