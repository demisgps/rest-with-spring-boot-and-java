package br.com.restwithspringboot.mapper.vo1;

import br.com.restwithspringboot.data.vo.v1.PessoaVO;
import br.com.restwithspringboot.model.Pessoa;

public class MapperPessoaVOToPessoa {

	private MapperPessoaVOToPessoa() {}
	
	public static Pessoa pessoaVoToPessoa(PessoaVO vo) {
		
		return new Pessoa(
				vo.getKey(),
				vo.getNome(),
				vo.getSobrenome(),
				vo.getGenero(),
				vo.getEndereco()
				);
	}
	
}
