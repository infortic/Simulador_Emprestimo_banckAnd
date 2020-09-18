package com.simuladorfinanciamento.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.simuladorfinanciamento.abstractEntity.AbstractEmprestimo;

@Entity
@Table(name = "SIMULADOR_EMPRESTIMO")
public class SimuladorEmprestimo extends AbstractEmprestimo {
	private static final long serialVersionUID = 1L;

	private Date dataSimulacao;
	private Date dataValidadeSimulacao;
	private BigDecimal valorContrato;
	private BigDecimal quantidadeParcelas;
	private BigDecimal valorParcela;
	private BigDecimal taxaJurosEmprestimo;
	private ContratarEmprestimo contratarEmprestimo;

	@Column(name = "DATA_SIMULACAO")
	public 	Date getDataSimulacao() {
		return dataSimulacao;
	}

	public 	void setDataSimulacao(Date dataSimulacao) {
		this.dataSimulacao = dataSimulacao;
	}

	@Column(name = "DATA_VALIDADE_SIMULACAO")
	public 	Date getDataValidadeSimulacao() {
		return dataValidadeSimulacao;
	}

	public 	void setDataValidadeSimulacao(Date dataValidadeSimulacao) {
		this.dataValidadeSimulacao = dataValidadeSimulacao;
	}

	@Column(name = "VALOR_CONTRATO")
	public 	BigDecimal getValorContrato() {
		return valorContrato;
	}

	public 	void setValorContrato(BigDecimal valorContrato) {
		this.valorContrato = valorContrato;
	}

	@Column(name = "QUANTIDADE_PARCELAS")
	public 	BigDecimal getQuantidadeParcelas() {
		return quantidadeParcelas;
	}

	public 	void setQuantidadeParcelas(BigDecimal quantidadeParcelas) {
		this.quantidadeParcelas = quantidadeParcelas;
	}

	@Column(name = "VALOR_PARCELA")
	public 	BigDecimal getValorParcela() {
		return valorParcela;
	}

	public void setValorParcela(BigDecimal valorParcela) {
		this.valorParcela = valorParcela;
	}

	@Column(name = "TAXA_JUROS_EMPRESTIMO")
	public 	BigDecimal getTaxaJurosEmprestimo() {
		return taxaJurosEmprestimo;
	}

	public void setTaxaJurosEmprestimo(BigDecimal taxaJurosEmprestimo) {
		this.taxaJurosEmprestimo = taxaJurosEmprestimo;
	}

	@OneToOne(cascade = CascadeType.ALL)
	public ContratarEmprestimo getContratarEmprestimo() {
		return contratarEmprestimo;
	}

	public 	void setContratarEmprestimo(ContratarEmprestimo contratarEmprestimo) {
		this.contratarEmprestimo = contratarEmprestimo;
	}

	public SimuladorEmprestimo(Date dataSimulacao, Date dataValidadeSimulacao, BigDecimal valorContrato,
			BigDecimal quantidadeParcelas, BigDecimal valorParcela, BigDecimal taxaJurosEmprestimo,
			ContratarEmprestimo contratarEmprestimo) {
		super();
		this.dataSimulacao = dataSimulacao;
		this.dataValidadeSimulacao = dataValidadeSimulacao;
		this.valorContrato = valorContrato;
		this.quantidadeParcelas = quantidadeParcelas;
		this.valorParcela = valorParcela;
		this.taxaJurosEmprestimo = taxaJurosEmprestimo;
		this.contratarEmprestimo = contratarEmprestimo;
	}

	public SimuladorEmprestimo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
