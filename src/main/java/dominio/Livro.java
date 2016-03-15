package dominio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Livro implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer codLivro;
	private String titulo;
	private String descricao;
	private Integer edicao;
	
	private List<Leilao> leiloes;
	
	private Categoria categoria;
	
	public Livro() {
		this.leiloes = new ArrayList<>();
	}

	public Livro(Integer codLivro, String titulo, String descricao, Integer edicao, Categoria categoria) {
		this.codLivro = codLivro;
		this.titulo = titulo;
		this.descricao = descricao;
		this.edicao = edicao;
		this.categoria = categoria;
		categoria.addLivro(this);
		this.leiloes = new ArrayList<>();
	}

	public Integer getCodLivro() {
		return codLivro;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public Integer getEdicao() {
		return edicao;
	}

	public List<Leilao> getLeiloes() {
		return leiloes;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCodLivro(Integer codLivro) {
		this.codLivro = codLivro;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public void setEdicao(Integer edicao) {
		this.edicao = edicao;
	}

	public void setLeiloes(List<Leilao> leiloes) {
		this.leiloes = leiloes;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	public void addLeilao(Leilao x) {
		this.leiloes.add(x);
		x.setLivro(this);
	}
	
	public void removeLeilao(Leilao x) {
		this.leiloes.remove(x);
	}

	@Override
	public String toString() {
		return "Livro [codLivro=" + codLivro + ", titulo=" + titulo + ", descricao=" + descricao + ", edicao=" + edicao
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codLivro == null) ? 0 : codLivro.hashCode());
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
		Livro other = (Livro) obj;
		if (codLivro == null) {
			if (other.codLivro != null)
				return false;
		} else if (!codLivro.equals(other.codLivro))
			return false;
		return true;
	}
}
