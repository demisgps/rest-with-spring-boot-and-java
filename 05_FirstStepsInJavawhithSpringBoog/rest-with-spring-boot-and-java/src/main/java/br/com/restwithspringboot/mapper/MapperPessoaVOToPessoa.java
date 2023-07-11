package br.com.restwithspringboot.mapper;

import br.com.restwithspringboot.data.vo.v1.PessoaVO;
import br.com.restwithspringboot.model.Pessoa;

public class MapperPessoaVOToPessoa {

	private MapperPessoaVOToPessoa() {}
	
	public static Pessoa pessoaVoToPessoa(PessoaVO vo) {
		
		return new Pessoa(
				vo.getId(),
				vo.getNome(),
				vo.getSobrenome(),
				vo.getGenero(),
				vo.getEndereco()
				);
	}
	
}
