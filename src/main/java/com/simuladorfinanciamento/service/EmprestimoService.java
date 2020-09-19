package com.simuladorfinanciamento.service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.math.RoundingMode;
import java.text.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simuladorfinanciamento.DTO.SimuladorEmprestimoDTO;
import com.simuladorfinanciamento.entity.Cliente;
import com.simuladorfinanciamento.entity.SimuladorEmprestimo;
import com.simuladorfinanciamento.repository.ClienteRepository;
import com.simuladorfinanciamento.util.ContractUtil;

@Service
public class EmprestimoService {

	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private ContractUtil contractUtil;

	public Object simular(SimuladorEmprestimoDTO payload) throws ParseException {
		if (this.validaPayLoad(payload) == "TRUE") {
			return this.criarCiente(payload);
		} else {
			return this.validaPayLoad(payload);
		}
	}

	public Cliente criarCiente(SimuladorEmprestimoDTO payload) throws ParseException {
		Cliente cliente = new Cliente();
		cliente = this.clienteRepository.findByCpf(new BigDecimal(payload.getCpf()));
		if (cliente != null)
			return cliente;
		else
			cliente = new Cliente();
		cliente.setCPF(new BigDecimal(payload.getCpf()));
		cliente.setEmail(payload.getEmail());
		cliente.setNome(payload.getNome());
		SimuladorEmprestimo simuladorEmprestimo = this.calcularEmprestimo(payload.getValorContrato(),
				this.contractUtil.toBigDecimal(payload.getQuantidadeParcelas()), cliente);
		cliente.setSimuladorEmprestimo(simuladorEmprestimo);
		this.clienteRepository.save(cliente);
		return cliente;
	}

	public SimuladorEmprestimo calcularEmprestimo(BigDecimal valorContrato, BigDecimal quantidadeParcelas,
			Cliente cliente) throws ParseException {
		SimuladorEmprestimo simuladorEmprestimo = new SimuladorEmprestimo();
		String numeroContrato = contractUtil.gerarNumeroContrato();
		simuladorEmprestimo.setNumeroContrato(new BigInteger(numeroContrato));
		simuladorEmprestimo.setValorContrato(valorContrato);
		simuladorEmprestimo.setQuantidadeParcelas(quantidadeParcelas);
		simuladorEmprestimo.setValorParcela(this.caucularValorParcela(valorContrato, quantidadeParcelas));
		simuladorEmprestimo.setDataSimulacao(this.contractUtil.getAgora());
		simuladorEmprestimo.setDataValidadeSimulacao(this.contractUtil.getValidadeContrato());
		simuladorEmprestimo.setTaxaJurosEmprestimo(new BigDecimal(this.taxaDeJuros(valorContrato, quantidadeParcelas)));
		return simuladorEmprestimo;
	}

	public BigDecimal caucularValorParcela(BigDecimal valorContrato, BigDecimal quantidadeParcelas) {
		// Exemple: valorContato*(1+(quantideParcelas*taxajuros))/quantidadeParcelas
		double taxaJuros = this.taxaDeJuros(valorContrato, quantidadeParcelas);
		BigDecimal faseUmCalculoParcela = quantidadeParcelas.multiply(new BigDecimal(taxaJuros)).add(new BigDecimal(1));
		BigDecimal faseDoisCalculoParcela = faseUmCalculoParcela.multiply(valorContrato);
		BigDecimal valorParcela = faseDoisCalculoParcela.divide(quantidadeParcelas,
				new MathContext(8, RoundingMode.HALF_EVEN));
		return valorParcela;
	}

	public double taxaDeJuros(BigDecimal valorContrato, BigDecimal quantidadeParcelas) {
		double taxaJuros = valorContrato.doubleValue() <= 1000 ? 0.018 : 0.03;
		taxaJuros = quantidadeParcelas.doubleValue() > 12 ? taxaJuros + 0.005 : taxaJuros;
		return taxaJuros;
	}

	public String validaPayLoad(SimuladorEmprestimoDTO payload) {
		String msg = "TRUE";
		Double numParc = Double.parseDouble(payload.getQuantidadeParcelas());
		msg = numParc > 24 ? "O número máximo de parcelas é 24" : msg;
		msg = this.contractUtil.isCPF(payload.getCpf()) ? msg : "CPF inválido!";
		msg = this.contractUtil.validarEmail(payload.getEmail()) ? msg : "EMAIL invalido!";
		System.out.println(msg);
		return msg;
	}

}
