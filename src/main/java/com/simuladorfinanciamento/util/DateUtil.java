package com.simuladorfinanciamento.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.springframework.stereotype.Service;

@Service
public class DateUtil extends CpfUtil {
	public Date getAgora() throws ParseException {
		Calendar calendar = Calendar.getInstance();
		int ano = calendar.get(Calendar.YEAR);
		int mes = calendar.get(Calendar.MONTH) + 1;
		int dia = calendar.get(Calendar.DAY_OF_MONTH);
		String date = dia + "/" + mes + "/" + ano;
		return this.formatarData(date);
	}

	public Date formatarData(String string) throws ParseException {
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		Date date = formato.parse(string);
		return date;
	}
	
	public Date getValidadeContrato() throws ParseException {
		Date hoje = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(hoje);
		calendar.add(Calendar.DATE, 30);
		int ano = calendar.get(Calendar.YEAR);
		int mes = calendar.get(Calendar.MONTH) + 1;
		int dia = calendar.get(Calendar.DAY_OF_MONTH);
		String date = dia + "/" + mes + "/" + ano;
		return this.formatarData(date);
		
	}

}
