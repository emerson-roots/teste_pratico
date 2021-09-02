package teste_pratico.domain.enums;

import com.fasterxml.jackson.annotation.JsonValue;


public enum TipoMovimentacao {

	EMBARQUE(1,"Embarque"),
	DESCARGA(2,"Descarga"),
	GATE_IN(3,"Gate In"),
	GATE_OUT(4,"Gate Out"),
	POSICIONAMENTO(5,"Posicionamento"),
	PILHA(6,"Pilha"),
	PESAGEM(7,"Pesagem"),
	SCANNER(8,"Scanner");
	
	private int cod;
	private String descricao;
	
	private TipoMovimentacao(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}
	
	public int getCod() {
		return cod;
	}
	
	@JsonValue
	public String getDescricao() {
		return descricao;
	}
	
	public static TipoMovimentacao toEnum(Integer cod) {
		
		if(cod == null) {
			return null;
		}
		
		for (TipoMovimentacao tipoMovimentacao : TipoMovimentacao.values()) {
			if(cod.equals(tipoMovimentacao.getCod())) {
				return tipoMovimentacao;
			}
			
		}
		throw new IllegalArgumentException("Codigo inválido: " + cod + " | Enum: " + TipoMovimentacao.class.getName());
		
		
	}
}
