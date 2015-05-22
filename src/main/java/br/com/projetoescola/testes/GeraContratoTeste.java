package br.com.projetoescola.testes;

import org.hibernate.Session;

import br.com.projetoescola.banco.dao.AlunoDAO;
import br.com.projetoescola.banco.dao.AlunoDAOImpl;
import br.com.projetoescola.banco.dao.ContratoDAO;
import br.com.projetoescola.banco.dao.ContratoDAOImpl;
import br.com.projetoescola.banco.dao.EscolaDAO;
import br.com.projetoescola.banco.dao.EscolaDAOImpl;
import br.com.projetoescola.banco.dao.UsuarioDAO;
import br.com.projetoescola.banco.dao.UsuarioDAOImpl;
import br.com.projetoescola.banco.entidades.Aluno;
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
		
		Aluno a1 = new Aluno();
		a1.setPrimeiroNome("Adriano");
		a1.setSobrenome("Amado Abduch");
		
		Aluno a2 = new Aluno();
		a2.setPrimeiroNome("Alef");
		a2.setSobrenome("Reche Abduch");
		
		Session s = CriadorDeSessionParaTeste.abreSession();
		ContratoDAO contratoDAO = new ContratoDAOImpl(s);
		contratoDAO.salvar(c);
		e.setContrato(c);
		EscolaDAO escolaDAO = new EscolaDAOImpl(s);
		escolaDAO.salvar(e);
		u.setEscola(e);
		UsuarioDAO usuarioDAO = new UsuarioDAOImpl(s);
		usuarioDAO.salvar(u);
		
		a1.setEscola(e);
		a2.setEscola(e);
		
		AlunoDAO alunoDAO = new AlunoDAOImpl(s);
		alunoDAO.salvar(a1);
		alunoDAO.salvar(a2);
	}
	
}
