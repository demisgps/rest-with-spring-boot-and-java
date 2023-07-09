package br.com.restwithspringboot.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UnsupportedMathOperationException  extends RuntimeException{
	public UnsupportedMathOperationException(String mensagem) {
		super(mensagem);
	}

	private static final long serialVersionUID = 1L;

}
