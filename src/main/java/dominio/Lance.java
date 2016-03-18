package dominio;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="tb_lance")
public class Lance implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer codLance;
	private BigDecimal valor;
	
	@ManyToOne
	@JoinColumn(name="usuario")
	private Usuario usuario;
	
	@ManyToOne
	@JoinColumn(name="leilao")
	private Leilao leilao;
	
	public Lance() {	
	}

	public Lance(Integer codLance, BigDecimal valor, Usuario usuario, Leilao leilao) {
		this.codLance = codLance;
		this.valor = valor;
		this.usuario = usuario;
		usuario.addLance(this);
		this.leilao = leilao;
		leilao.addLance(this);
	}

	public Integer getCodLance() {
		return codLance;
	}

	public void setCodLance(Integer codLance) {
		this.codLance = codLance;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Leilao getLeilao() {
		return leilao;
	}

	public void setLeilao(Leilao leilao) {
		this.leilao = leilao;
	}

	@Override
	public String toString() {
		return "Lance [codLance=" + codLance + ", valor=" + valor + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codLance == null) ? 0 : codLance.hashCode());
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
		Lance other = (Lance) obj;
		if (codLance == null) {
			if (other.codLance != null)
				return false;
		} else if (!codLance.equals(other.codLance))
			return false;
		return true;
	}
}
