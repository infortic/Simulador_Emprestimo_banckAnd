package com.simuladorfinanciamento.util;

import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import org.springframework.stereotype.Service;

@Service
public class ContractUtil extends DateUtil{

	public String gerarNumeroContrato() {
		Calendar calendar = Calendar.getInstance();
		int ano = calendar.get(Calendar.YEAR);
		int mes = calendar.get(Calendar.MONTH) + 1;
		String mesString = mes < 10 ? "0"+mes : ""+mes; 
		int dia = calendar.get(Calendar.DAY_OF_MONTH);
		String diaString = dia < 10 ? "0"+dia : ""+dia; 
		String dataFomatoContrato = ""+ano+mesString+diaString;
		return dataFomatoContrato + this.criarNumeroAleatorioSeisDigitos();
	}

	public Integer criarNumeroAleatorioSeisDigitos() {
		Random random = new Random();
		int numeroInteiroAleatorio_0_a_10 = random.nextInt(9) * 123456;
		return numeroInteiroAleatorio_0_a_10;
	}
	
	public Boolean validarEmail(String email) {
		if (email.indexOf("@") != -1 && email.indexOf(".com") != -1) {
			return true;
		}else {
			return false;	
		}
	}
}