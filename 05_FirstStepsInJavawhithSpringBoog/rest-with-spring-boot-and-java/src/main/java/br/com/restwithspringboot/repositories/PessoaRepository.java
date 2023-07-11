package br.com.restwithspringboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.restwithspringboot.model.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

}
