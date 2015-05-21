package br.com.projetoescola.banco.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Usuario extends BaseEntidadeEscola {

	private String email;
	
	private String senha;
	
	private boolean administrativo = false;
	
	private boolean secretaria = false;
	
	private boolean aluno = false;
	
	private boolean docente = false;
	
	private int tentativaserradas;
	
	private boolean bloqueado = false;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public boolean isAdministrativo() {
		return administrativo;
	}

	public void setAdministrativo(boolean administrativo) {
		this.administrativo = administrativo;
	}

	public boolean isSecretaria() {
		return secretaria;
	}

	public void setSecretaria(boolean secretaria) {
		this.secretaria = secretaria;
	}

	public boolean isAluno() {
		return aluno;
	}

	public void setAluno(boolean aluno) {
		this.aluno = aluno;
	}

	public boolean isDocente() {
		return docente;
	}

	public void setDocente(boolean docente) {
		this.docente = docente;
	}

	public int getTentativaserradas() {
		return tentativaserradas;
	}

	public void setTentativaserradas(int tentativaserradas) {
		this.tentativaserradas = tentativaserradas;
	}

	public boolean isBloqueado() {
		return bloqueado;
	}

	public void setBloqueado(boolean bloqueado) {
		this.bloqueado = bloqueado;
	}

}
