package br.com.projetoescola.banco.dao;

import br.com.projetoescola.banco.entidades.Colaborador;

public interface ColaboradorDAO extends GenericEntidadeEscolaDAO<Colaborador> {
	
	public Colaborador buscaPorUsuarioId(Long usuarioId);
	
}
