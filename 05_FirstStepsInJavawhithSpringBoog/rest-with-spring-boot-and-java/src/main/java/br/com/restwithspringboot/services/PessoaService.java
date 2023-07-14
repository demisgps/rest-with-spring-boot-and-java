package br.com.restwithspringboot.services;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.restwithspringboot.controllers.PessoaController;
import br.com.restwithspringboot.data.vo.v1.PessoaVO;
import br.com.restwithspringboot.data.vo.v2.PessoaVOV2;
import br.com.restwithspringboot.exceptions.ResourceNotFoundException;
import br.com.restwithspringboot.mapper.vo1.MapperPessoaToPessoaVO;
import br.com.restwithspringboot.mapper.vo1.MapperPessoaVOToPessoa;
import br.com.restwithspringboot.mapper.vo2.MapperPessoaToVo2;
import br.com.restwithspringboot.model.Pessoa;
import br.com.restwithspringboot.repositories.PessoaRepository;

@Service
public class PessoaService {
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	private Logger logger = Logger.getLogger(PessoaService.class.getName());
	
	
	public PessoaVO findById(Long id) {
		logger.info("Procurando pessoa...");

		var entidadePessoa = pessoaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Nenhum valor encontrado..."));
		
		var vo = MapperPessoaToPessoaVO.pessoaToPessoaVO(entidadePessoa);
		
		vo.add(linkTo(methodOn(PessoaController.class).findById(id)).withSelfRel());
		
		return vo;
	}
	
	
	public PessoaVO create(PessoaVO pessoaVo) {
		logger.info("Criando pessoa...");
		
		Pessoa pessoaEntidade = MapperPessoaVOToPessoa.pessoaVoToPessoa(pessoaVo);
		
		var vo = MapperPessoaToPessoaVO.pessoaToPessoaVO(pessoaRepository.save(pessoaEntidade));
		
		vo.add(linkTo(methodOn(PessoaController.class).findById(vo.getKey())).withSelfRel());
		 
		 return vo;
		
	}
	
	
	public PessoaVOV2 createV2(PessoaVOV2 pessoaVo2) {
		logger.info("Criando pessoa... (versão 2)");
		
		Pessoa pessoaEntidade = MapperPessoaToVo2.mapperVoV2ToPessoa(pessoaVo2);
		
		
		var vo2 = MapperPessoaToVo2.mapperPessoaToVoV2(pessoaRepository.save(pessoaEntidade));
		
		 
		 return vo2;
		
	}
	
	
	public PessoaVO update(PessoaVO pessoa) {
		logger.info("Atualizando pessoa...");
		
		var pessoaEncontrada = pessoaRepository.findById(pessoa.getKey()).orElseThrow(() -> new ResourceNotFoundException("Nenhum valor encontrado..."));
		
		pessoaEncontrada.setNome(pessoa.getNome());
		pessoaEncontrada.setSobrenome(pessoa.getSobrenome());
		pessoaEncontrada.setGenero(pessoa.getGenero());
		pessoaEncontrada.setEndereco(pessoa.getEndereco());
		
		
		var vo = MapperPessoaToPessoaVO.pessoaToPessoaVO(pessoaRepository.save(pessoaEncontrada));
		
		vo.add(linkTo(methodOn(PessoaController.class).findById(vo.getKey())).withSelfRel());
		
		return vo;
	}
	
	public void delete(Long id) {
		logger.info("Deletando pessoa");
		
		var pessoaEncontrada = pessoaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Nenhum valor encontrado..."));
		
		pessoaRepository.delete(pessoaEncontrada);
	}
	
	
	public List<PessoaVO> findAll() {
		logger.info("Procurando pessoas...");
		List<Pessoa> pessoas = new ArrayList<>();
		pessoas = pessoaRepository.findAll();
		
		List<PessoaVO> listVo = new ArrayList<>();
		
		for (Pessoa pessoa : pessoas) {
			PessoaVO pessoaVO = new PessoaVO(pessoa.getId(), pessoa.getNome(), pessoa.getSobrenome(), pessoa.getEndereco(), pessoa.getGenero());
			listVo.add(pessoaVO);
		}
		
		listVo.stream().forEach(p -> p.add(linkTo(methodOn(PessoaController.class).findById(p.getKey())).withSelfRel()));
		return listVo;
		
	}
	
// teste meu primeiro commit utilizando o Eclise
	
}
