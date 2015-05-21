package br.com.projetoescola.banco.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;

import br.com.caelum.vraptor.ioc.Component;
import br.com.projetoescola.banco.entidades.Escola;
import br.com.projetoescola.banco.entidades.Usuario;

@Component
public class EscolaDAOImpl extends GenericDAOImpl<Escola> implements EscolaDAO {

	public EscolaDAOImpl(Session session) {
		super(session);
	}
	
	@SuppressWarnings("unchecked")
	public List<Escola> findAll() {
		Criteria c = getSession().createCriteria(Usuario.class);
		
		return c.list();
	}
	
	
	
}
