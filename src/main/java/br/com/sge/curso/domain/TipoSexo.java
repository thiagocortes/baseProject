package br.com.sge.curso.domain;

import java.util.ArrayList;
import java.util.List;

public enum TipoSexo implements BaseEnum {
	
	Feminino("Feminino"),
	Masculino("Masculino");
	
	private String descricao;
	
	private TipoSexo(String descricao){
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public int getCodigo() {
		return this.ordinal();
	}
	
	public static TipoSexo getTipoSexo(String descricao){
		switch(descricao) {
			case "Feminino":
				return Feminino;
			case "Masculino":
				return Masculino;
			default:
				return Masculino;
		}
	}
	
	public static List<String> listarTipoSexosDescricao() {
		List<String> sexos = new ArrayList<String>();
		for(TipoSexo sexo : values()) {
			sexos.add(sexo.getDescricao());
		}
		return sexos;
	}
	
	@Override
	public String toString() {
		return super.toString();
	}
	

}
