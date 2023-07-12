package br.com.restwithspringboot.mapper.vo1;

import br.com.restwithspringboot.data.vo.v1.PessoaVO;
import br.com.restwithspringboot.model.Pessoa;

public class MapperPessoaToPessoaVO {

	private MapperPessoaToPessoaVO() {}
	
	
	public static PessoaVO pessoaToPessoaVO(Pessoa entidadePessoa) {
		
		PessoaVO vo = new PessoaVO();
		
		vo.setNome(entidadePessoa.getNome());
		vo.setSobrenome(entidadePessoa.getSobrenome());
		vo.setGenero(entidadePessoa.getGenero());
		vo.setEndereco(entidadePessoa.getEndereco());
		
		return vo;
	}
}
