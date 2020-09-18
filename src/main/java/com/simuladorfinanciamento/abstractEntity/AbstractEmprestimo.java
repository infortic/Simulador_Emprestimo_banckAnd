package com.simuladorfinanciamento.abstractEntity;

import java.io.Serializable;
import java.math.BigInteger;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class AbstractEmprestimo extends AbstractId implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private BigInteger numeroContrato;
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((numeroContrato == null) ? 0 : numeroContrato.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		AbstractEmprestimo other = (AbstractEmprestimo) obj;
		if (numeroContrato == null) {
			if (other.numeroContrato != null)
				return false;
		} else if (!numeroContrato.equals(other.numeroContrato))
			return false;
		return true;
	}

	public BigInteger getNumeroContrato() {
		return numeroContrato;
	}

	public void setNumeroContrato(BigInteger numeroContrato) {
		this.numeroContrato = numeroContrato;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
