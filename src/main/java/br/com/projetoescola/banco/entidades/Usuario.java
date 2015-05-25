package br.com.projetoescola.banco.entidades;

import javax.persistence.Entity;

import br.com.projetoescola.tipo.TipoPerfil;

@Entity
public class Usuario extends BaseEntidadeEscola {

	private String email;
	
	private String senha;
	
	private TipoPerfil perfil;
	
	private Integer tentativaserradas;
	
	private Boolean bloqueado;

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

	public TipoPerfil getPerfil() {
		return perfil;
	}

	public void setPerfil(TipoPerfil perfil) {
		this.perfil = perfil;
	}

	public Integer getTentativaserradas() {
		return tentativaserradas;
	}

	public void setTentativaserradas(Integer tentativaserradas) {
		this.tentativaserradas = tentativaserradas;
	}

	public Boolean getBloqueado() {
		return bloqueado;
	}

	public void setBloqueado(Boolean bloqueado) {
		this.bloqueado = bloqueado;
	}
	
}
