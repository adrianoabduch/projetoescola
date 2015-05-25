package br.com.projetoescola.controller;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.projetoescola.banco.dao.UsuarioDAO;
import br.com.projetoescola.banco.entidades.Usuario;
import br.com.projetoescola.seguranca.UsuarioLogado;

@Resource
public class LoginController {
	
	private UsuarioDAO usuarioDAO;
	private UsuarioLogado usuarioLogado;
	private Result result;

	public LoginController(UsuarioDAO usuarioDAO, UsuarioLogado usuarioLogado, Result result) {
		this.usuarioDAO = usuarioDAO;
		this.usuarioLogado = usuarioLogado;
		this.result = result;
	}
	
	public void autentica(Usuario usuario) {
		Usuario autenticado = usuarioDAO.buscaUsuarioPorEmailESenha(usuario);
		if(autenticado != null) {
			usuarioLogado.efetuaLogin(autenticado);
//			result.redirectTo(PaginaPrincipal)
		} else {
			result.redirectTo(this).formulario();
		}
	}
	
	public void formulario () {
	}
	
	@Get("/logout")
    public void logout() {
        usuarioLogado.logout();
        result.redirectTo(this).formulario();
    }
	

}
