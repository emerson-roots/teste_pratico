package teste_pratico.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import teste_pratico.domain.enums.Categoria;
import teste_pratico.domain.enums.StatusEspacoInterior;
import teste_pratico.domain.enums.TipoConteiner;

@Entity
public class Conteiner implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull(message = "Preenchimento obrigório")
	private String cliente;
	
	@NotNull(message = "Preenchimento obrigório")
	@Column(unique = true)
	@Size(min = 11, max = 11, message = "O código do conteiner deve ter {max} caracteres")
	private String codigoConteiner;
	
	@NotNull(message = "Preenchimento obrigório")
	private Integer tipoConteiner;
	
	@NotNull(message = "Preenchimento obrigório")
	private Integer status;
	
	@NotNull(message = "Preenchimento obrigório")
	private Integer categoria;
	
	@JsonIgnoreProperties("conteiner")
	@OneToMany(mappedBy = "conteiner")
	private List<MovimentacaoConteiner> movimentacoesConteiner;

	public Conteiner() {
	}
	
	public Conteiner(Long id, String cliente, String codigoConteiner, TipoConteiner tipoConteiner,
			StatusEspacoInterior status, Categoria categoria) {
		super();
		this.id = id;
		this.cliente = cliente;
		this.codigoConteiner = codigoConteiner;
		this.tipoConteiner = (tipoConteiner == null) ? null : tipoConteiner.getCod();
		this.status = (status == null) ? null : status.getCod();;
		this.categoria = (categoria == null) ? null : categoria.getCod();;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public String getCodigoConteiner() {
		return codigoConteiner;
	}

	public void setCodigoConteiner(String codigoConteiner) {
		this.codigoConteiner = codigoConteiner;
	}

	public TipoConteiner getTipoConteiner() {
		return TipoConteiner.toEnum(tipoConteiner);
	}

	public void setTipoConteiner(TipoConteiner tipoConteiner) {
		this.tipoConteiner = tipoConteiner.getCod();
	}

	public StatusEspacoInterior getStatus() {
		return StatusEspacoInterior.toEnum(status);
	}

	public void setStatus(StatusEspacoInterior status) {
		this.status = status.getCod();
	}

	public Categoria getCategoria() {
		return Categoria.toEnum(categoria);
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria.getCod();
	}

	public List<MovimentacaoConteiner> getMovimentacoesConteiner() {
		return movimentacoesConteiner;
	}

	public void setMovimentacoesConteiner(List<MovimentacaoConteiner> movimentacoesConteiner) {
		this.movimentacoesConteiner = movimentacoesConteiner;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Conteiner other = (Conteiner) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}
