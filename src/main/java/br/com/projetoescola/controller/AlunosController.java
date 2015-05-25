package br.com.projetoescola.controller;

import java.util.List;

import br.com.caelum.vraptor.Resource;
import br.com.projetoescola.banco.dao.AlunoDAO;
import br.com.projetoescola.banco.entidades.Aluno;

@Resource
public class AlunosController {
	
	private String nome;
	
	private AlunoDAO alunoDAO;

	public AlunosController(AlunoDAO alunoDAO) {
		this.alunoDAO = alunoDAO;
	}
	
	public List<Aluno> lista() {
		return alunoDAO.buscaTodos();
	}
	

	public String nome() {
		nome = "José";
		
		System.out.println(nome);
		return nome;
	}
	

}
