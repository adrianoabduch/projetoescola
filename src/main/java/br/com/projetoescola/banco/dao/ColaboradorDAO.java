package br.com.projetoescola.banco.dao;

import java.util.List;

import br.com.projetoescola.banco.entidades.Colaborador;

public interface ColaboradorDAO extends GenericDAO<Colaborador> {
	
	public List<Colaborador> buscaTodos();
	
}
