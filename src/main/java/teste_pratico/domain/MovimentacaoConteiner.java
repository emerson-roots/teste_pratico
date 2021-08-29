package teste_pratico.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import teste_pratico.domain.enums.TipoMovimentacao;

@Entity
public class MovimentacaoConteiner implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull(message = "Preenchimento obrigório")
	private Integer tipoMovimentacao;
	
	@NotNull(message = "Preenchimento obrigório")
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private Date dataHoraInicio;
	
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private Date dataHoraFim;
	
	@JsonIgnoreProperties("movimentacoesConteiner")
	@ManyToOne
	@JoinColumn(name = "conteiner_id")
	private Conteiner conteiner;

	public MovimentacaoConteiner() {
	}
	
	public MovimentacaoConteiner(Long id, TipoMovimentacao tipoMovimentacao, Date dataHoraInicio, Date dataHoraFim,
			Conteiner conteiner) {
		super();
		this.id = id;
		this.tipoMovimentacao = (tipoMovimentacao == null) ? null : tipoMovimentacao.getCod();;
		this.dataHoraInicio = dataHoraInicio;
		this.dataHoraFim = dataHoraFim;
		this.conteiner = conteiner;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public TipoMovimentacao getTipoMovimentacao() {
		return TipoMovimentacao.toEnum(tipoMovimentacao);
	}

	public void setTipoMovimentacao(TipoMovimentacao tipoMovimentacao) {
		this.tipoMovimentacao = tipoMovimentacao.getCod();
	}

	public Date getDataHoraInicio() {
		return dataHoraInicio;
	}

	public void setDataHoraInicio(Date dataHoraInicio) {
		this.dataHoraInicio = dataHoraInicio;
	}

	public Date getDataHoraFim() {
		return dataHoraFim;
	}

	public void setDataHoraFim(Date dataHoraFim) {
		this.dataHoraFim = dataHoraFim;
	}

	public Conteiner getConteiner() {
		return conteiner;
	}

	public void setConteiner(Conteiner conteiner) {
		this.conteiner = conteiner;
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
		MovimentacaoConteiner other = (MovimentacaoConteiner) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	

}
