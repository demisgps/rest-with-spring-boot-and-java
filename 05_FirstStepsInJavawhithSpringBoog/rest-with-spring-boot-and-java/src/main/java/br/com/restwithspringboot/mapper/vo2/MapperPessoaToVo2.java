package br.com.restwithspringboot.mapper.vo2;

import java.util.Date;

import org.springframework.stereotype.Service;

import br.com.restwithspringboot.data.vo.v2.PessoaVOV2;
import br.com.restwithspringboot.model.Pessoa;

@Service
public class MapperPessoaToVo2 {

	public static PessoaVOV2 mapperPessoaToVoV2(Pessoa entidadePessoa) {
		PessoaVOV2 vo2 = new PessoaVOV2();
		vo2.setNome(entidadePessoa.getNome());
		vo2.setSobrenome(entidadePessoa.getSobrenome());
		vo2.setGenero(entidadePessoa.getGenero());
		vo2.setEndereco(entidadePessoa.getEndereco());
		vo2.setDatNascimento(new Date());
		
		return vo2;
	}
	
	
	public static Pessoa mapperVoV2ToPessoa(PessoaVOV2 vo2) {
		Pessoa entidadePessoa = new Pessoa();
		entidadePessoa.setNome(vo2.getNome());
		entidadePessoa.setSobrenome(vo2.getSobrenome());
		entidadePessoa.setGenero(vo2.getGenero());
		entidadePessoa.setEndereco(vo2.getEndereco());
		
		return entidadePessoa;
	}
	
}
