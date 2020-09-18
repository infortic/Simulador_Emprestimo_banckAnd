package com.simuladorfinanciamento.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.simuladorfinanciamento.abstractEntity.AbstractEmprestimo;


@Entity
@Table(name="PARCELA_EMPRESTIMO")
public class ParcelaEmprestimo extends AbstractEmprestimo implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer numeroDaParcela;
	private BigDecimal valorParcela;
	private Date dataVencimento;
	
	
	@Column(name="NUMERO_DA_PARCELA")
	public Integer getNumeroDaParcela() {
		return numeroDaParcela;
	}
	public void setNumeroDaParcela(Integer numeroDaParcela) {
		this.numeroDaParcela = numeroDaParcela;
	}
	
	@Column(name="VALOR_PARCELA")
	public 	BigDecimal getValorParcela() {
		return valorParcela;
	}
	public 	void setValorParcela(BigDecimal valorParcela) {
		this.valorParcela = valorParcela;
	}
	
	@Column(name="DATA_VENCIMENTO")
	public 	Date getDataVencimento() {
		return dataVencimento;
	}
	public 	void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}
	public ParcelaEmprestimo(Integer numeroDaParcela, BigDecimal valorParcela, Date dataVencimento) {
		super();
		this.numeroDaParcela = numeroDaParcela;
		this.valorParcela = valorParcela;
		this.dataVencimento = dataVencimento;
	}
	public ParcelaEmprestimo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
