package com.simuladorfinanciamento.util;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

@Service
public class StringUril {
	
	public BigDecimal toBigDecimal(String numero) {
		return  new BigDecimal(numero);
		
	}
	
	public Integer toInteger(String numero) {
		Integer interger = Integer.parseInt(numero);
		return  new Integer(interger);
	}

}
