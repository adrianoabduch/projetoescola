package br.com.projetoescola.seguranca;

import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.SessionScoped;
import br.com.projetoescola.banco.entidades.Aluno;
import br.com.projetoescola.banco.entidades.Colaborador;
import br.com.projetoescola.banco.entidades.Usuario;

@Component
@SessionScoped
public class UsuarioLogado {
	
	private Usuario usuario;
	private Aluno aluno;
	private Colaborador colaborador;
	
	public void efetuaLogin(Usuario usuario) {
		this.usuario = usuario;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void logout() {
		this.usuario = null;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public Colaborador getColaborador() {
		return colaborador;
	}

	public void setColaborador(Colaborador colaborador) {
		this.colaborador = colaborador;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
	//-- Fim dos getters & setters
	
	public boolean isAluno() {
		return aluno != null;
	}
	
	public boolean isColaboradr() {
		return colaborador != null;
	}
	
	public String getNomeCompleto() {
		if(isAluno())
			return getAluno().getNomeCompleto();
		
		return getColaborador().getNomeCompleto();
	}


}
