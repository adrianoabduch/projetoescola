package br.com.projetoescola.banco.dao;

import java.util.List;

import br.com.projetoescola.banco.entidades.Aluno;

public interface AlunoDAO extends GenericEntidadeEscolaDAO<Aluno> {
	
	public List<Aluno> buscaTodos();

	public Aluno buscaPorUsuarioId(Long usuarioId);
	
}
