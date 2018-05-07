package br.com.sge.curso.converter;

import org.springframework.core.convert.converter.Converter;

import br.com.sge.curso.domain.TipoSexo;

public class TipoSexoConverter implements Converter<String, TipoSexo>{

	@Override
	public TipoSexo convert(String descricao) {
		return TipoSexo.getTipoSexo(descricao);
	}

}
