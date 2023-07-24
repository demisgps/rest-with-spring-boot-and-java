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
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;



@RestController
@RequestMapping("/pessoa/v1")
@Tag(name = "Pessoa", description = "Endpoints de Pessoa")
public class PessoaController {
	
	
	@Autowired
	private PessoaService pessoaService;

	@GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	@Operation(summary = "Buscar todas as pessoas", description = "Buscar todas as pessoas", tags = "Pessoa", 
		responses = {
				@ApiResponse(description = "Success", responseCode = "200",
						content = {
								@Content(mediaType = "application-json", array = 
										@ArraySchema(schema = 
												@Schema(implementation = PessoaVO.class)))}),
				@ApiResponse(description = "BadRequest", responseCode = "400", content = @Content),
				@ApiResponse(description = "NotFound", 	responseCode = "401", content = @Content),
				@ApiResponse(description = "InternalServerError", responseCode = "500", content = @Content)
	})
	public List<PessoaVO> findAll() {
		return pessoaService.findAll();
	}
	
	@GetMapping(value = "/{id}",produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	@Operation(summary = "Buscar uma pessoa", description = "Buscar uma pessoa", tags = "Pessoa", 
	responses = {
			@ApiResponse(description = "Success", responseCode = "200",
					content = @Content(mediaType = "application-json", 
									  schema = @Schema(implementation = PessoaVO.class))),
			@ApiResponse(description = "NoContent", responseCode = "204", content = @Content),
			@ApiResponse(description = "BadRequest", responseCode = "400", content = @Content),
			@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
			@ApiResponse(description = "NotFound", 	responseCode = "404", content = @Content),
			@ApiResponse(description = "InternalServerError", responseCode = "500", content = @Content)
})
	public PessoaVO findById(@PathVariable(value = "id") Long id) {
		return pessoaService.findById(id);
	}
	
	
	@PostMapping( produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	@Operation(summary = "Adiciona uma pessoa", description = "Adiciona uma pessoa, passando um json ou um XML", tags = "Pessoa", 
	responses = {
			@ApiResponse(description = "Success", responseCode = "200",
					content = @Content(mediaType = "application-json", 
									  schema = @Schema(implementation = PessoaVO.class))),
			@ApiResponse(description = "BadRequest", responseCode = "400", content = @Content),
			@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
			@ApiResponse(description = "InternalServerError", responseCode = "500", content = @Content)
})
	public PessoaVO create(@RequestBody PessoaVO pessoa) {
		return pessoaService.create(pessoa);
	}
	
	@Operation(summary = "Adiciona uma pessoa", description = "Adiciona uma pessoa, passando um json ou um XML", tags = "Pessoa", 
	responses = {
			@ApiResponse(description = "Success", responseCode = "200",
					content = @Content(mediaType = "application-json", 
									  schema = @Schema(implementation = PessoaVOV2.class))),
			@ApiResponse(description = "BadRequest", responseCode = "400", content = @Content),
			@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
			@ApiResponse(description = "InternalServerError", responseCode = "500", content = @Content)
})
	@PostMapping(value = "/v2" , produces ={MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}, consumes = MediaType.APPLICATION_JSON_VALUE)
	public PessoaVOV2 createV2(@RequestBody PessoaVOV2 pessoaVo2) {
		return pessoaService.createV2(pessoaVo2);
	}
	
	@PutMapping(produces ={MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}, consumes = MediaType.APPLICATION_JSON_VALUE)
	@Operation(summary = "Atualiza uma pessoa", description = "Atualiza uma pessoa, passando um json ou um XML", tags = "Pessoa", 
	responses = {
			@ApiResponse(description = "Success", responseCode = "200",
					content = @Content(mediaType = "application-json", 
									  schema = @Schema(implementation = PessoaVO.class))),
			@ApiResponse(description = "BadRequest", responseCode = "400", content = @Content),
			@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
			@ApiResponse(description = "NotFound", 	responseCode = "404", content = @Content),
			@ApiResponse(description = "InternalServerError", responseCode = "500", content = @Content)
})
	public PessoaVO update(@RequestBody PessoaVO pessoa) {
		return pessoaService.update(pessoa);
	}
	
	@DeleteMapping(value = "/{id}")
	@Operation(summary = "Deleta uma pessoa", description = "Atualiza uma pessoa, passando o ID de uma pessoa", tags = "Pessoa", 
	responses = {
			@ApiResponse(description = "No Content", responseCode = "204", content = @Content),
			@ApiResponse(description = "BadRequest", responseCode = "400", content = @Content),
			@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
			@ApiResponse(description = "NotFound", 	responseCode = "404", content = @Content),
			@ApiResponse(description = "InternalServerError", responseCode = "500", content = @Content)
})
	public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) {
		pessoaService.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	
}
