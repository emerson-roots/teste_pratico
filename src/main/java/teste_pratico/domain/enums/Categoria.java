package teste_pratico.domain.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Categoria {

	IMPORTACAO(1,"Importacão"),
	EXPORTACAO(2,"Exportação");
	
	private int cod;
	private String descricao;
	
	private Categoria(int cod, String descricao) {
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
	
	public static Categoria toEnum(Integer cod) {
		
		if(cod == null) {
			return null;
		}
		
		for (Categoria categoria : Categoria.values()) {
			if(cod.equals(categoria.getCod())) {
				return categoria;
			}
			
		}
		throw new IllegalArgumentException("Codigo inválido: " + cod + " | Enum: " + Categoria.class.getName());
		
		
	}
}
