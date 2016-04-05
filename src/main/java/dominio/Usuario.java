package dominio;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="tb_usuario")
public class Usuario implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer codUsuario;
	private String nome;
	private String email;
	private String cpf;
	private Date nascimento;
	private BigDecimal renda;
	
	@OneToMany(mappedBy="usuario")
	private List<Lance> lances;

	public Usuario() {
		this.lances = new ArrayList<>();
	}

	public Usuario(Integer codUsuario, String nome, String email, String cpf, Date nascimento, BigDecimal renda) {
		this.codUsuario = codUsuario;
		this.nome = nome;
		this.email = email;
		this.cpf = cpf;
		this.nascimento = nascimento;
		this.renda = renda;
		this.lances = new ArrayList<>();
	}

	public Integer getCodUsuario() {
		return codUsuario;
	}

	public void setCodUsuario(Integer codUsuario) {
		this.codUsuario = codUsuario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Date getNascimento() {
		return nascimento;
	}

	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
	}

	public BigDecimal getRenda() {
		return renda;
	}

	public void setRenda(BigDecimal renda) {
		this.renda = renda;
	}

	public List<Lance> getLances() {
		return lances;
	}

	public void setLances(List<Lance> lances) {
		this.lances = lances;
	}
	
	public void addLance(Lance x) {
		this.lances.add(x);
		x.setUsuario(this);
	}
	
	public void removeLance(Lance x) {
		this.lances.remove(x);
	}

	@Override
	public String toString() {
		return "Usuario [codUsuario=" + codUsuario + ", nome=" + nome + ", email=" + email + ", cpf=" + cpf
				+ ", nascimento=" + nascimento + ", renda=" + renda + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codUsuario == null) ? 0 : codUsuario.hashCode());
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
		Usuario other = (Usuario) obj;
		if (codUsuario == null) {
			if (other.codUsuario != null)
				return false;
		} else if (!codUsuario.equals(other.codUsuario))
			return false;
		return true;
	}
	
	public List<Leilao> leiloesQueVenceu() {

		List<Leilao> lista = new ArrayList<>();
		
		for(int i = 0; i < getLances().size(); i++){
			if(getLances().get(i).getLeilao().vencedor().getCodUsuario().equals(getCodUsuario())){
				if (!lista.contains(getLances().get(i).getLeilao())) {
					lista.add(getLances().get(i).getLeilao());
				}					
			}
		}			
		return lista;
	}
}
