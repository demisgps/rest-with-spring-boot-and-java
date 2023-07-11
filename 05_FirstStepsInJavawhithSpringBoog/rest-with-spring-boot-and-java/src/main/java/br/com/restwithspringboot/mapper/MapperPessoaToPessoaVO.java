package br.com.restwithspringboot.mapper;

import br.com.restwithspringboot.data.vo.v1.PessoaVO;
import br.com.restwithspringboot.model.Pessoa;

public class MapperPessoaToPessoaVO {

	private MapperPessoaToPessoaVO() {}
	
	
	public static PessoaVO pessoaToPessoaVO(Pessoa entidadePessoa) {
		
		return new PessoaVO(
				entidadePessoa.getId(),
				entidadePessoa.getNome(),
				entidadePessoa.getSobrenome(),
				entidadePessoa.getEndereco(),
				entidadePessoa.getGenero());
	}
}
