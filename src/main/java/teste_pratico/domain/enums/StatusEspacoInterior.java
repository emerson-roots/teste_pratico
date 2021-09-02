package teste_pratico.domain.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum StatusEspacoInterior {

	VAZIO(1,"Vazio"),
	CHEIO(2,"Cheio");
	
	private int cod;
	private String descricao;
	
	private StatusEspacoInterior(int cod, String descricao) {
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
	
	public static StatusEspacoInterior toEnum(Integer cod) {
		
		if(cod == null) {
			return null;
		}
		
		for (StatusEspacoInterior statusEspacoInterior : StatusEspacoInterior.values()) {
			if(cod.equals(statusEspacoInterior.getCod())) {
				return statusEspacoInterior;
			}
			
		}
		throw new IllegalArgumentException("Codigo inválido: " + cod + " | Enum: " + StatusEspacoInterior.class.getName());
		
		
	}
}
