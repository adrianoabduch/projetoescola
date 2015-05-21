package br.com.projetoescola.banco.dao;

import java.lang.reflect.ParameterizedType;

import org.hibernate.Session;

import br.com.caelum.vraptor.ioc.Component;


/**
 * DAO Genérico com os métodos básicos de um DAO. Todo DAO do sistema deve estender este DAO.
 * @author Adriano
 *
 * @param <T>
 */
public interface GenericDAO<T> {

	public T buscaPorId(Long id);
	
	public Class getPersistentClass();

	public Session getSession();
	
	public T salvar(T entidade);
	
}
