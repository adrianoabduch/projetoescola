package br.com.projetoescola.testes;

import org.hibernate.Session;

import br.com.projetoescola.banco.dao.ContratoDAO;
import br.com.projetoescola.banco.dao.ContratoDAOImpl;
import br.com.projetoescola.banco.dao.EscolaDAO;
import br.com.projetoescola.banco.dao.EscolaDAOImpl;
import br.com.projetoescola.banco.dao.UsuarioDAO;
import br.com.projetoescola.banco.dao.UsuarioDAOImpl;
import br.com.projetoescola.banco.entidades.Contrato;
import br.com.projetoescola.banco.entidades.Escola;
import br.com.projetoescola.banco.entidades.Usuario;

public class GeraContratoTeste {

	public static void main(String[] args) {
		Contrato c = new Contrato();
		
		Escola e = new Escola();;
//		e.setContrato(c);

		Usuario u = new Usuario();
//		u.setEscola(e);
		
		Session s = CriadorDeSessionParaTeste.abreSession();
		ContratoDAO contratoDAO = new ContratoDAOImpl(s);
		contratoDAO.salvar(c);
		e.setContrato(c);
		EscolaDAO escolaDAO = new EscolaDAOImpl(s);
		escolaDAO.salvar(e);
		u.setEscola(e);
		UsuarioDAO usuarioDAO = new UsuarioDAOImpl(s);
		usuarioDAO.salvar(u);
		
	}
	
}
