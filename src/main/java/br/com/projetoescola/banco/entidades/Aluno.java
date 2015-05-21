package br.com.projetoescola.banco.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

@Entity
public class Aluno extends BaseEntidadeEscola {
	
	@JoinColumn(name = "usuarioid")
	private Usuario usuario;

	private String primeiroNome;
	
	private String sobrenome;
	
	
	
	public String getPrimeiroNome() {
		return primeiroNome;
	}

	public void setPrimeiroNome(String primeiroNome) {
		this.primeiroNome = primeiroNome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	
	public String getNomeCompleto() {
		return primeiroNome + " " + sobrenome;
	}
}
