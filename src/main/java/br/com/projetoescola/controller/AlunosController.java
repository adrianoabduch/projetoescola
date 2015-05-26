package br.com.projetoescola.controller;

import java.util.List;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Resource;
import br.com.projetoescola.banco.dao.AlunoDAO;
import br.com.projetoescola.banco.entidades.Aluno;
import br.com.projetoescola.seguranca.Permissao;
import br.com.projetoescola.seguranca.Publico;
import br.com.projetoescola.tipo.TipoPerfil;

@Resource
@Permissao( {TipoPerfil.ADMINISTADOR} )
public class AlunosController {
	
	private String nome;
	
	private AlunoDAO alunoDAO;

	public AlunosController(AlunoDAO alunoDAO) {
		this.alunoDAO = alunoDAO;
	}
	
	@Get("/alunos")
	@Permissao( {TipoPerfil.ADMINISTADOR, TipoPerfil.DOCENTE, TipoPerfil.SECRETARIA_TODOS, TipoPerfil.SECRETARIA_CADASTROS} )
	public List<Aluno> lista() {
		return alunoDAO.buscaTodos();
	}
	
	@Get("/alunos/ver/{id}")
	public Aluno verAluno(Long id) {
		return alunoDAO.buscaPorId(id);
	}
	

}
