package br.com.restwithspringboot;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.restwithspringboot.exceptions.UnsupportedMathOperationException;

@RestController
public class MathController {

	
	@RequestMapping(value = "/sum/{numberOne}/{numberTwo}",
			method = RequestMethod.GET)
	public Double sum(
			@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo) throws Exception {
		
		if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Por favor informe um valor numérico");
		}
		return convertToDouble(numberOne) + convertToDouble(numberTwo);
	}
	
	
	//converte String para Double
	private Double convertToDouble(String strNumber) {
		String number = strNumber.replaceAll(",", ".");
		if(isNumeric(number)) return Double.parseDouble(number);
		return 0D;
	}

	//Verificação se a String é uma String numérica
	public boolean isNumeric(String strNumber) {
		if(strNumber == null) return false;
		
		String number = strNumber.replaceAll(",", ".");
		return number.matches("-?\\d+(\\.\\d+)?");
	}
	
	
}
