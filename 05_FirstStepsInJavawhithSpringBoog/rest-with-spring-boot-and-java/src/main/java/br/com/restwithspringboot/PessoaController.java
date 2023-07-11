package br.com.restwithspringboot;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.restwithspringboot.model.Pessoa;
import br.com.restwithspringboot.services.PessoaService;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {
	
//	@Autowired
//	private PessoaService pessoaService;
	
	@Autowired
	private PessoaService pessoaService;

	
	@GetMapping(value = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
	public Pessoa findById(@PathVariable(value = "id") Long id) {
		return pessoaService.findById(id);
	}
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Pessoa> findAll() {
		return pessoaService.findAll();
	}
	
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Pessoa create(@RequestBody Pessoa pessoa) {
		return pessoaService.create(pessoa);
	}
	
	@PutMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Pessoa update(@RequestBody Pessoa pessoa) {
		return pessoaService.update(pessoa);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) {
		pessoaService.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	
	
	

	
	
}
