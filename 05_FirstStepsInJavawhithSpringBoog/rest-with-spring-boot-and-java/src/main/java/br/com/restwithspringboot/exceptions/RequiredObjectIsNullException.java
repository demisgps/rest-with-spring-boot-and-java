package br.com.restwithspringboot.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class RequiredObjectIsNullException  extends RuntimeException{
	public RequiredObjectIsNullException(String mensagem) {
		super(mensagem);
	}
	
	
	public RequiredObjectIsNullException() {
		super("Não é possível persistir um objeto Nulo");
	}

	private static final long serialVersionUID = 1L;

}
