package teste_pratico.domain.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum TipoConteiner {
	
	PES_20(20, "20 Pés"),
	PES_40(40, "40 Pés");
	
	private int cod;
	private String descricao;
	
	private TipoConteiner(int cod, String descricao) {
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
	
	public static TipoConteiner toEnum(Integer cod) {
		
		if(cod == null) {
			return null;
		}
		
		for (TipoConteiner tipoConteiner : TipoConteiner.values()) {
			if(cod.equals(tipoConteiner.getCod())) {
				return tipoConteiner;
			}
			
		}
		throw new IllegalArgumentException("Codigo inválido: " + cod + " | Enum: " + TipoConteiner.class.getName());
		
		
	}
}
