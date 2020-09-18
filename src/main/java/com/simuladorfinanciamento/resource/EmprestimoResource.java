package com.simuladorfinanciamento.resource;
import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.simuladorfinanciamento.DTO.SimuladorEmprestimoDTO;
import com.simuladorfinanciamento.service.EmprestimoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "Fornece serviços de emprestimos")
@RestController
@RequestMapping("/emprestimo")
public class EmprestimoResource {
	
	@Autowired
	private EmprestimoService emprestimoservice;
	
	
	@ApiOperation(value="Realiza simulação de emprestimo")
	@RequestMapping(method = RequestMethod.GET, path = "/simular")
	public ResponseEntity<?> simular(SimuladorEmprestimoDTO paylod) throws ParseException {
		return new ResponseEntity<>(this.emprestimoservice.simular(paylod), HttpStatus.OK);
	}
	
}