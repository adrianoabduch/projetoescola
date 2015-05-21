package br.com.projetoescola.banco.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.transform.AliasToBeanResultTransformer;

import br.com.caelum.vraptor.ioc.Component;
import br.com.projetoescola.banco.entidades.Usuario;

@Component
public class UsuarioDAOImpl extends GenericDAOImpl<Usuario> implements UsuarioDAO {

	public UsuarioDAOImpl(Session session) {
		super(session);
	}
	
	@SuppressWarnings("unchecked")
	public List<Usuario> findAll() {
		Criteria c = getSession().createCriteria(Usuario.class);
		
		return c.list();
	}
	
	
	
}
