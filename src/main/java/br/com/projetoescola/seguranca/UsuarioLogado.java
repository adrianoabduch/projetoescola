package br.com.projetoescola.seguranca;

import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.SessionScoped;
import br.com.projetoescola.banco.entidades.Usuario;

@Component
@SessionScoped
public class UsuarioLogado {
	
	private Usuario usuario;
	
	public void efetuaLogin(Usuario usuario) {
		this.usuario = usuario;
	}

	public Usuario getUsuarioLogado() {
		return usuario;
	}

	public void logout() {
		this.usuario = null;
	}


}
