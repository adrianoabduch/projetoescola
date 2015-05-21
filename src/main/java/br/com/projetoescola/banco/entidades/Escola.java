package br.com.projetoescola.banco.entidades;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Escola extends BaseEntidade {
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "contratoid", nullable=false, updatable = false)
	private Contrato contrato;

	public Contrato getContrato() {
		return contrato;
	}

	public void setContrato(Contrato contrato) {
		this.contrato = contrato;
	}

}
