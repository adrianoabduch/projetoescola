package br.com.projetoescola.seguranca;

import java.util.Arrays;
import java.util.Collection;

import br.com.caelum.vraptor.InterceptionException;
import br.com.caelum.vraptor.Intercepts;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.core.InterceptorStack;
import br.com.caelum.vraptor.interceptor.Interceptor;
import br.com.caelum.vraptor.resource.ResourceMethod;
import br.com.caelum.vraptor.view.Results;
import br.com.projetoescola.controller.LoginController;
import br.com.projetoescola.tipo.TipoPerfil;

@Intercepts
public class LoginInterceptor implements Interceptor {
	
	private UsuarioLogado usuarioLogado;
	private Result result;

	public LoginInterceptor(UsuarioLogado usuarioLogado, Result result) {
		this.usuarioLogado = usuarioLogado;
		this.result = result;
	}
	
	public void intercept(InterceptorStack stack, ResourceMethod method, Object instance) throws InterceptionException {
		Permissao methodPermission = method.getMethod().getAnnotation(Permissao.class);
	    Permissao controllerPermission = method.getResource().getType().getAnnotation(Permissao.class);
	    
	    if(usuarioLogado.getUsuario() == null) {
	    	result.redirectTo(LoginController.class).formulario();
	    	return;
	    }
	    
	    if (this.hasAccess(methodPermission) && this.hasAccess(controllerPermission)) {
	       stack.next(method, instance);
	    } else {
	       result.use(Results.http()).sendError(403, "Você não tem permissão para tal ação!");
	    }
	}

	public boolean accepts(ResourceMethod method) {
		return !(method.getMethod().isAnnotationPresent(Publico.class) ||
			               method.getResource().getType().isAnnotationPresent(Publico.class));
	}
	
	private boolean hasAccess(Permissao permissao) {
	    if (permissao == null) {
	       return true;
	    }

	    Collection<TipoPerfil> perfilList = Arrays.asList(permissao.value());

    	return perfilList.contains(usuarioLogado.getUsuario().getPerfil());
    	
	}
	

}
