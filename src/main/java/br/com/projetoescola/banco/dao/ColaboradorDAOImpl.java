package br.com.projetoescola.banco.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;

import br.com.caelum.vraptor.ioc.Component;
import br.com.projetoescola.banco.entidades.Colaborador;

@Component
public class ColaboradorDAOImpl extends GenericDAOImpl<Colaborador> implements ColaboradorDAO {

	public ColaboradorDAOImpl(Session session) {
		super(session);
	}
	
	@SuppressWarnings("unchecked")
	public List<Colaborador> buscaTodos() {
		Criteria c = getSession().createCriteria(Colaborador.class);
		
		return c.list();
	}
	
	
	
}
