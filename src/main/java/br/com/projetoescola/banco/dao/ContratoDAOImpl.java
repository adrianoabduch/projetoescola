package br.com.projetoescola.banco.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;

import br.com.caelum.vraptor.ioc.Component;
import br.com.projetoescola.banco.entidades.Contrato;
import br.com.projetoescola.banco.entidades.Usuario;

@Component
public class ContratoDAOImpl extends GenericDAOImpl<Contrato> implements ContratoDAO {

	public ContratoDAOImpl(Session session) {
		super(session);
	}
	
	@SuppressWarnings("unchecked")
	public List<Contrato> findAll() {
		Criteria c = getSession().createCriteria(Usuario.class);
		
		return c.list();
	}
	
	
	
}
