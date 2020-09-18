package com.simuladorfinanciamento.DTO;

import java.math.BigDecimal;

public class SimuladorEmprestimoDTO {

	private String nome;
	private String cpf;
	private String email;
	private BigDecimal valorContrato;
	private String quantidadeParcelas;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public BigDecimal getValorContrato() {
		return valorContrato;
	}

	public void setValorContrato(BigDecimal valorContrato) {
		this.valorContrato = valorContrato;
	}

	public String getQuantidadeParcelas() {
		return quantidadeParcelas;
	}

	public void setQuantidadeParcelas(String quantidadeParcelas) {
		this.quantidadeParcelas = quantidadeParcelas;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public SimuladorEmprestimoDTO(String nome, String cpf, String email, BigDecimal valorContrato,
			String quantidadeParcelas) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.valorContrato = valorContrato;
		this.quantidadeParcelas = quantidadeParcelas;
	}

	public SimuladorEmprestimoDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

}
