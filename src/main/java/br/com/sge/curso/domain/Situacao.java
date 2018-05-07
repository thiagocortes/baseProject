package br.com.sge.curso.domain;

public enum Situacao implements BaseEnum {
	
	ATIVO("ATIVO"),
	INATIVO("INATIVO");
	
	private String descricao;
	
	private Situacao(String descricao){
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public static Situacao getTipoSexo(String descricao){
		switch(descricao) {
			case "ATIVO":
				return ATIVO;
			case "INATIVO":
				return INATIVO;
			default:
				return ATIVO;
		}
	}
	
	@Override
	public String toString() {
		return super.toString();
	}

}
