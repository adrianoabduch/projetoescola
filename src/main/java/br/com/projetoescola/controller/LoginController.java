package br.com.projetoescola.controller;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.projetoescola.banco.dao.AlunoDAO;
import br.com.projetoescola.banco.dao.ColaboradorDAO;
import br.com.projetoescola.banco.dao.UsuarioDAO;
import br.com.projetoescola.banco.entidades.Aluno;
import br.com.projetoescola.banco.entidades.Colaborador;
import br.com.projetoescola.banco.entidades.Usuario;
import br.com.projetoescola.seguranca.Publico;
import br.com.projetoescola.seguranca.UsuarioLogado;

@Resource
public class LoginController {
	
	private UsuarioDAO usuarioDAO;
	private UsuarioLogado usuarioLogado;
	private Result result;
	private AlunoDAO alunoDAO;
	private ColaboradorDAO colaboradorDAO;

	public LoginController(UsuarioDAO usuarioDAO, AlunoDAO alunoDAO, ColaboradorDAO colaboradorDAO, 
			UsuarioLogado usuarioLogado, Result result) {
		this.usuarioDAO = usuarioDAO;
		this.alunoDAO = alunoDAO;
		this.colaboradorDAO = colaboradorDAO;
		this.usuarioLogado = usuarioLogado;
		this.result = result;
	}
	
	@Publico
	@Post("/autentica")
	public void autentica(Usuario usuario) {
		Usuario autenticado = usuarioDAO.buscaUsuarioPorEmailESenha(usuario);
		if(autenticado != null) {
			usuarioLogado.efetuaLogin(autenticado);
			Aluno aluno = alunoDAO.buscaPorUsuarioId(autenticado.getId());
			if(aluno != null) {
				usuarioLogado.setAluno(aluno);
			} else {
				Colaborador colaborador = colaboradorDAO.buscaPorUsuarioId(autenticado.getId());
				usuarioLogado.setColaborador(colaborador);
			}
			result.redirectTo(IndexController.class).home();
		} else {
			result.redirectTo(this).formulario();
		}
	}
	
	@Publico
	@Get("/sistema")
	public void formulario () {
	}
	
	@Get("/logout")
    public void logout() {
        usuarioLogado.logout();
        result.redirectTo(this).formulario();
    }
	

}
