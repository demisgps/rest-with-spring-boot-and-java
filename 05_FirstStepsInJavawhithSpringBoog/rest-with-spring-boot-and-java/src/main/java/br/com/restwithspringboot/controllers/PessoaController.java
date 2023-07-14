package br.com.restwithspringboot.controllers;

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

import br.com.restwithspringboot.data.vo.v1.PessoaVO;
import br.com.restwithspringboot.data.vo.v2.PessoaVOV2;
import br.com.restwithspringboot.services.PessoaService;



@RestController
@RequestMapping("/pessoa/v1")
public class PessoaController {
	
	
	@Autowired
	private PessoaService pessoaService;

	
	@GetMapping(value = "/{id}",produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE} )
	public PessoaVO findById(@PathVariable(value = "id") Long id) {
		return pessoaService.findById(id);
	}
	
	@GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public List<PessoaVO> findAll() {
		return pessoaService.findAll();
	}
	
	@PostMapping( produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public PessoaVO create(@RequestBody PessoaVO pessoa) {
		return pessoaService.create(pessoa);
	}
	
	
	@PostMapping(value = "/v2" , produces ={MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}, consumes = MediaType.APPLICATION_JSON_VALUE)
	public PessoaVOV2 createV2(@RequestBody PessoaVOV2 pessoaVo2) {
		return pessoaService.createV2(pessoaVo2);
	}
	
	@PutMapping(produces ={MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}, consumes = MediaType.APPLICATION_JSON_VALUE)
	public PessoaVO update(@RequestBody PessoaVO pessoa) {
		return pessoaService.update(pessoa);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) {
		pessoaService.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	
}
