package com.simuladorfinanciamento.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.simuladorfinanciamento.abstractEntity.AbstractEmprestimo;

@Entity
@Table(name = "CONTRATAR_EMPRESTIMO")
public class ContratarEmprestimo extends AbstractEmprestimo implements Serializable {

	private static final long serialVersionUID = 1L;

	private Date dataContratacao;
	private BigDecimal valorContratado;
	private BigDecimal quantidadeParcela;
	private BigDecimal taxaJurosEmprestimo;
	private BigDecimal iofContrato;
	private ParcelaEmprestimo parcelaEmprestimo;

	@Column(name = "DATA_CONTRATACAO")
	public Date getDataContratacao() {
		return dataContratacao;
	}

	public void setDataContratacao(Date dataContratacao) {
		this.dataContratacao = dataContratacao;
	}

	@Column(name = "VALOR_CONTRATADO")
	public BigDecimal getValorContratado() {
		return valorContratado;
	}

	public void setValorContratado(BigDecimal valorContratado) {
		this.valorContratado = valorContratado;
	}

	@Column(name = "QUANTIDADE_PARCELA")
	public BigDecimal getQuantidadeParcela() {
		return quantidadeParcela;
	}

	public void setQuantidadeParcela(BigDecimal quantidadeParcela) {
		this.quantidadeParcela = quantidadeParcela;
	}

	@Column(name = "TAXA_JUROS_EMPRESTIMO")
	public BigDecimal getTaxaJurosEmprestimo() {
		return taxaJurosEmprestimo;
	}

	public void setTaxaJurosEmprestimo(BigDecimal taxaJurosEmprestimo) {
		this.taxaJurosEmprestimo = taxaJurosEmprestimo;
	}

	@Column(name = "IOF_CONTRATO")
	public BigDecimal getIofContrato() {
		return iofContrato;
	}

	public void setIofContrato(BigDecimal iofContrato) {
		this.iofContrato = iofContrato;
	}

	@OneToOne(cascade = CascadeType.ALL)
	public ParcelaEmprestimo getParcelaEmprestimo() {
		return parcelaEmprestimo;
	}

	public void setParcelaEmprestimo(ParcelaEmprestimo parcelaEmprestimo) {
		this.parcelaEmprestimo = parcelaEmprestimo;
	}

	public ContratarEmprestimo(Date dataContratacao, BigDecimal valorContratado, BigDecimal quantidadeParcela,
			BigDecimal taxaJurosEmprestimo, BigDecimal iofContrato, ParcelaEmprestimo parcelaEmprestimo) {
		super();
		this.dataContratacao = dataContratacao;
		this.valorContratado = valorContratado;
		this.quantidadeParcela = quantidadeParcela;
		this.taxaJurosEmprestimo = taxaJurosEmprestimo;
		this.iofContrato = iofContrato;
		this.parcelaEmprestimo = parcelaEmprestimo;
	}

	public ContratarEmprestimo() {
		super();
		// TODO Auto-generated constructor stub
	}

}
