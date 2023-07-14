package br.com.restwithspringboot.services;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.restwithspringboot.MockPessoa;
import br.com.restwithspringboot.model.Pessoa;
import br.com.restwithspringboot.repositories.PessoaRepository;

@TestInstance(Lifecycle.PER_CLASS)
@ExtendWith(MockitoExtension.class)
class PessoaServiceTest {
	
	@InjectMocks
	PessoaService pessoaService;
	
	@Mock
	PessoaRepository pessoaRepository;
	
	MockPessoa mockPessoa;
	
	

	@BeforeEach
	void setUp() throws Exception {
		mockPessoa = new MockPessoa();
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void testFindById() {
		Pessoa pessoa = mockPessoa.mockEntity(1);
		pessoa.setId(1L);
		when(pessoaRepository.findById(1L)).thenReturn(Optional.of(pessoa));
		var resultado = pessoaService.findById(1L);
		assertNotNull(resultado.getEndereco());
		assertNotNull(resultado.getLinks());
		assertTrue(resultado.toString().contains("links: [</pessoa/v1/1>;rel=\"self\"]"));
		assertEquals(resultado.getEndereco(), "endereco1");
		assertEquals(resultado.getNome(), "nome1");
		assertEquals(resultado.getSobrenome(), "sobrenome1");		
	}

	@Test
	void testCreate() {
		fail("Not yet implemented");
	}

	@Test
	void testCreateV2() {
		fail("Not yet implemented");
	}

	@Test
	void testUpdate() {
		fail("Not yet implemented");
	}

	@Test
	void testDelete() {
		fail("Not yet implemented");
	}

	@Test
	void testFindAll() {
		fail("Not yet implemented");
	}

}
