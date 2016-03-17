package dominio;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

public class Leilao implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer codLeilao;
	private Date lancamento;
	private BigDecimal valorMinimo;
	private boolean encerrado;
	
	private List<Lance> lances;
	
	private Livro livro;
	
	public Leilao() {
		this.lances = new ArrayList<>();
	}

	public Leilao(Integer codLeilao, Date lancamento, BigDecimal valorMinimo, boolean encerrado, Livro livro) {
		this.codLeilao = codLeilao;
		this.lancamento = lancamento;
		this.valorMinimo = valorMinimo;
		this.encerrado = encerrado;
		this.livro = livro;
		livro.addLeilao(this);
		this.lances = new ArrayList<>();
	}

	public Integer getCodLeilao() {
		return codLeilao;
	}

	public void setCodLeilao(Integer codLeilao) {
		this.codLeilao = codLeilao;
	}

	public Date getLancamento() {
		return lancamento;
	}

	public void setLancamento(Date lancamento) {
		this.lancamento = lancamento;
	}

	public BigDecimal getValorMinimo() {
		return valorMinimo;
	}

	public void setValorMinimo(BigDecimal valorMinimo) {
		this.valorMinimo = valorMinimo;
	}

	public boolean isEncerrado() {
		return encerrado;
	}

	public void setEncerrado(boolean encerrado) {
		this.encerrado = encerrado;
	}

	public List<Lance> getLances() {
		return lances;
	}

	public void setLances(List<Lance> lances) {
		this.lances = lances;
	}

	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}
	
	public void addLance(Lance x) {
		this.lances.add(x);
		x.setLeilao(this);
	}
	
	public void removeLance(Lance x) {
		this.lances.remove(x);
	}

	@Override
	public String toString() {
		return "Leilao [codLeilao=" + codLeilao + ", lancamento=" + lancamento + ", valorMinimo=" + valorMinimo
				+ ", encerrado=" + encerrado + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codLeilao == null) ? 0 : codLeilao.hashCode());
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
		Leilao other = (Leilao) obj;
		if (codLeilao == null) {
			if (other.codLeilao != null)
				return false;
		} else if (!codLeilao.equals(other.codLeilao))
			return false;
		return true;
	}
	
	public Usuario vencedor() {
		return null;
	}
	
	public Lance maiorLance() {
		return null;
	}
}
