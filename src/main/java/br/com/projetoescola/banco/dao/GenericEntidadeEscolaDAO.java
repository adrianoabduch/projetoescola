package br.com.projetoescola.banco.dao;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Session;


/**
 * DAO Genérico com os métodos básicos de um DAO. Todo DAO do sistema deve estender este DAO.
 * @author Adriano
 *
 * @param <T>
 */
public interface GenericEntidadeEscolaDAO<T> {

	public T buscaPorId(Long id);
	
	@SuppressWarnings("rawtypes")
	public Class getPersistentClass();

	public Session getSession();
	
	/**
	 * Salva com transação controlada pelo VRaptor. Deve ser usado por classes controladas
	 * com o vraptor (controllers, components etc)
	 */
	public T salvar(T entidade);
	
	/**
	 * Salva com transação criada manualmente. Deve ser usado para testes e afins.
	 * @param entidade
	 * @return
	 */
	public T _salvar(T entidade);
	
	/**
	 * Devolve uma criteria já filtrando com o ID da escola do usuário logado.
	 * @return Criteria
	 */
	public Criteria createCriteria();
	
	
	
}
