package br.com.projetoescola.seguranca;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import br.com.projetoescola.tipo.TipoPerfil;

@Retention(RetentionPolicy.RUNTIME)
@Target( {ElementType.TYPE, ElementType.METHOD} )
public @interface Permissao {

	TipoPerfil[] value();
	
}
