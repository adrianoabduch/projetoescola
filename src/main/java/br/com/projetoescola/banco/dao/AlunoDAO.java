package br.com.projetoescola.banco.dao;

import java.util.List;

import br.com.projetoescola.banco.entidades.Aluno;

public interface AlunoDAO extends GenericDAO<Aluno> {
	
	public List<Aluno> buscaTodos();
	
}
