package br.com.restwithspringboot.data.vo.v2;

import java.util.Date;

public class PessoaVOV2 {

	private Long id;
	
	private String nome;
	
	private String sobrenome;
	
	private String genero;
	
	private String endereco;
	
	private Date datNascimento;
	
	
	public PessoaVOV2() {}
	
	
	

	public PessoaVOV2(Long id, String nome, String sobrenome, String genero, String endereco) {
		this.id = id;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.genero = genero;
		this.endereco = endereco;
	}
	
	
	public PessoaVOV2(Long id, String nome, String sobrenome, String genero, String endereco, Date datNascimento) {
		super();
		this.id = id;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.genero = genero;
		this.endereco = endereco;
		this.datNascimento = datNascimento;
	}




	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}
	
	public String getEndereco() {
		return endereco;
	}
	
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	
	

	public Date getDatNascimento() {
		return datNascimento;
	}




	public void setDatNascimento(Date datNascimento) {
		this.datNascimento = datNascimento;
	}




	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((datNascimento == null) ? 0 : datNascimento.hashCode());
		result = prime * result + ((endereco == null) ? 0 : endereco.hashCode());
		result = prime * result + ((genero == null) ? 0 : genero.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((sobrenome == null) ? 0 : sobrenome.hashCode());
		return result;
	}




	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PessoaVOV2 other = (PessoaVOV2) obj;
		if (datNascimento == null) {
			if (other.datNascimento != null)
				return false;
		} else if (!datNascimento.equals(other.datNascimento))
			return false;
		if (endereco == null) {
			if (other.endereco != null)
				return false;
		} else if (!endereco.equals(other.endereco))
			return false;
		if (genero == null) {
			if (other.genero != null)
				return false;
		} else if (!genero.equals(other.genero))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (sobrenome == null) {
			if (other.sobrenome != null)
				return false;
		} else if (!sobrenome.equals(other.sobrenome))
			return false;
		return true;
	}




	
}
