package com.simuladorfinanciamento.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.br.CPF;

import com.simuladorfinanciamento.abstractEntity.AbstractId;

@Entity
@Table(name = "CLIENTE")
public class Cliente extends AbstractId implements Serializable {
	private static final long serialVersionUID = 1L;
	private BigDecimal cpf;
	private String nome;
	private String email;
	private SimuladorEmprestimo simuladorEmprestimo;

	public BigDecimal getCPF() {
		return cpf;
	}

	public void setCPF(BigDecimal cPF) {
		cpf = cPF;
	}

	@Column(name = "NOME")
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Column(name = "EMAIL")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@OneToOne(cascade = CascadeType.ALL)
	public SimuladorEmprestimo getSimuladorEmprestimo() {
		return simuladorEmprestimo;
	}

	public void setSimuladorEmprestimo(SimuladorEmprestimo simuladorEmprestimo) {
		this.simuladorEmprestimo = simuladorEmprestimo;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Cliente(BigDecimal i, String nome, String email, SimuladorEmprestimo simuladorEmprestimo) {
		super();
		cpf = i;
		this.nome = nome;
		this.email = email;
		this.simuladorEmprestimo = simuladorEmprestimo;
	}

	public Cliente() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Cliente [cpf=" + cpf + ", nome=" + nome + ", email=" + email + ", simuladorEmprestimo="
				+ simuladorEmprestimo + ", getCPF()=" + getCPF() + ", getNome()=" + getNome() + ", getEmail()="
				+ getEmail() + ", getSimuladorEmprestimo()=" + getSimuladorEmprestimo() + ", hashCode()=" + hashCode()
				+ ", getId()=" + getId() + ", getClass()=" + getClass() + ", toString()=" + super.toString() + "]";
	}
	
	

}
