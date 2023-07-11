package br.com.restwithspringboot.services;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.restwithspringboot.exceptions.ResourceNotFoundException;
import br.com.restwithspringboot.model.Pessoa;
import br.com.restwithspringboot.repositories.PessoaRepository;

@Service
public class PessoaService {
	
	@Autowired
	private PessoaRepository pessoaRepository;

	private final AtomicLong counter = new AtomicLong();
	private Logger logger = Logger.getLogger(PessoaService.class.getName());
	
	public Pessoa findById(Long id) {
		logger.info("Procurando pessoa...");
		
		Pessoa pessoa = new Pessoa();
		pessoa.setId(counter.incrementAndGet());
		pessoa.setNome("Demis");
		pessoa.setSobrenome("Goulart");
		pessoa.setGenero("masculino");
		pessoa.setEndereco("Rua xxxxxx, número 9999, Franca - SP");
		return pessoaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Nenhum valor encontrado..."));
	}
	
	
	public Pessoa create(Pessoa pessoa) {
		logger.info("Criando pessoa...");
		
		return pessoaRepository.save(pessoa);
	}
	
	
	public Pessoa update(Pessoa pessoa) {
		logger.info("Atualizando pessoa...");
		
		var pessoaEncontrada = pessoaRepository.findById(pessoa.getId()).orElseThrow(() -> new ResourceNotFoundException("Nenhum valor encontrado..."));
		
		pessoaEncontrada.setNome(pessoa.getNome());
		pessoaEncontrada.setSobrenome(pessoa.getSobrenome());
		pessoaEncontrada.setGenero(pessoa.getGenero());
		pessoaEncontrada.setEndereco(pessoa.getEndereco());
		
		pessoaRepository.save(pessoaEncontrada);
		
		return pessoa;
	}
	
	public void delete(Long id) {
		logger.info("Deletando pessoa");
		
		var pessoaEncontrada = pessoaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Nenhum valor encontrado..."));
		
		pessoaRepository.delete(pessoaEncontrada);
	}
	
	
	public List<Pessoa> findAll() {
		logger.info("Procurando pessoas...");
		List<Pessoa> pessoas = new ArrayList<>();
		pessoas = pessoaRepository.findAll();
		return pessoas;
	}

	
}
