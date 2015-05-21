package br.com.projetoescola.banco.entidades;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * Superclasse para as todas as entidades que não sejam filhas de uma escola.
 * @author Adriano
 *
 */
@MappedSuperclass
public class BaseEntidade {

	@Id
	@GeneratedValue
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	
}
