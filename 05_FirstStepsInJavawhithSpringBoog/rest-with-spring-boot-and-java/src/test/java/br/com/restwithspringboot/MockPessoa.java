package br.com.restwithspringboot;

import java.util.ArrayList;
import java.util.List;

import br.com.restwithspringboot.data.vo.v1.PessoaVO;
import br.com.restwithspringboot.model.Pessoa;

public class MockPessoa {

	public Pessoa mockEntity() {
		return mockEntity(0);
	}
	
	public PessoaVO mockVO() {
		return mockVO(0);
	}
	
	
	public List<Pessoa> criarListaPessoas() {
		List<Pessoa> listaPessoas = new ArrayList<Pessoa>();
		
		for (int i = 0; i < 10; i++) {
			mockEntity(i);
		}
		return listaPessoas;
	}
	
	
	public List<PessoaVO> criarListaPessoasVO() {
		List<PessoaVO> listaPessoasVO = new ArrayList<PessoaVO>();
		
		for (int i = 0; i < 10; i++) {
			mockVO(i);
		}
		return listaPessoasVO;
	}
	
	
	

	public Pessoa mockEntity(Integer numero) {
		Pessoa pessoa = new Pessoa();
		pessoa.setId(numero.longValue());
		pessoa.setNome("nome" + numero);
		pessoa.setSobrenome("sobrenome"+ numero);
		pessoa.setGenero("genero"+ numero);
		pessoa.setEndereco("endereco"+ numero);
		return pessoa;
	}
	
	private PessoaVO mockVO(Integer numero) {
		PessoaVO vo = new PessoaVO();
		vo.setKey(numero.longValue());
		vo.setNome("nome"+ numero);
		vo.setSobrenome("sobrenome"+ numero);
		vo.setGenero("genero"+ numero);
		vo.setEndereco("endereco"+ numero);
		
		return vo;
		
	}
}
