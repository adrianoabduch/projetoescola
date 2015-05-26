package br.com.projetoescola.banco.dao;

import org.hibernate.Session;

import br.com.caelum.vraptor.ioc.Component;
import br.com.projetoescola.banco.entidades.Contrato;

@Component
public class ContratoDAOImpl extends GenericDAOImpl<Contrato> implements ContratoDAO {

	public ContratoDAOImpl(Session session) {
		super(session);
	}
	
	
}
