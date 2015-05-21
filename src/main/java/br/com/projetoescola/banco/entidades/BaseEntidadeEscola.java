package br.com.projetoescola.banco.entidades;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

/**
 * Superclasse para as todas as entidades filhas de uma escola.
 * @author Adriano
 *
 */
@MappedSuperclass
public class BaseEntidadeEscola extends BaseEntidade {

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="empresaid", nullable=false, updatable = false)
	private Escola escola;

	public Escola getEscola() {
		return escola;
	}

	public void setEscola(Escola escola) {
		this.escola = escola;
	}
	
}
