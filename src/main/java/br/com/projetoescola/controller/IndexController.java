package br.com.projetoescola.controller;

import br.com.caelum.stella.boleto.Banco;
import br.com.caelum.stella.boleto.Beneficiario;
import br.com.caelum.stella.boleto.Boleto;
import br.com.caelum.stella.boleto.Datas;
import br.com.caelum.stella.boleto.Endereco;
import br.com.caelum.stella.boleto.Pagador;
import br.com.caelum.stella.boleto.bancos.Bradesco;
import br.com.caelum.stella.boleto.transformer.GeradorDeBoleto;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Resource;
import br.com.projetoescola.banco.dao.UsuarioDAOImpl;

import com.lowagie.text.pdf.codec.Base64;

@Resource
public class IndexController {

	private UsuarioDAOImpl usuarioDAO;
	
	public IndexController(UsuarioDAOImpl usuarioDAO) {
		this.usuarioDAO = usuarioDAO;
	}
	
//	@Get("/{id}")
	public String teste() {
		Long id = 1L;
		
		String y = usuarioDAO.buscaPorId(id).getEmail();
		if(y != null)
			return y;
		
		Datas datas = Datas.novasDatas()
                .comDocumento(1, 5, 2008)
                .comProcessamento(1, 5, 2008)
                .comVencimento(2, 5, 2008);  

        Endereco enderecoBeneficiario = Endereco.novoEndereco()
                .comLogradouro("Av das Empresas, 555")  
                .comBairro("Bairro Grande")  
                .comCep("01234-555")  
                .comCidade("São Paulo")  
                .comUf("SP");  

        //Quem emite o boleto
        Beneficiario beneficiario = Beneficiario.novoBeneficiario()  
                .comNomeBeneficiario("José Alves de Souza Neto")  
                .comAgencia("0133").comDigitoAgencia("3")  
                .comCodigoBeneficiario("1007220")  
                .comDigitoCodigoBeneficiario("4")  
                .comNumeroConvenio("1207113")  
                .comCarteira("18")  
                .comEndereco(enderecoBeneficiario)
                .comNossoNumero("9000206");  

        Endereco enderecoPagador = Endereco.novoEndereco()
                .comLogradouro("Av dos testes, 111 apto 333")  
                .comBairro("Bairro Teste")  
                .comCep("01234-111")  
                .comCidade("São Paulo")  
                .comUf("SP");  

        //Quem paga o boleto
        Pagador pagador = Pagador.novoPagador()  
                .comNome("Adriano Amado Abduch")  
                .comDocumento("111.222.333-12")
                .comEndereco(enderecoPagador);

        Banco banco = new Bradesco();  
        
        Boleto boleto = Boleto.novoBoleto()  
                .comBanco(banco)  
                .comDatas(datas)  
                .comBeneficiario(beneficiario)  
                .comPagador(pagador)  
                .comValorBoleto("50.00")  
                .comNumeroDoDocumento("1234")  
                .comInstrucoes("instrucao 1", "instrucao 2", "instrucao 3", "instrucao 4", "instrucao 5")  
                .comLocaisDePagamento("local 1", "local 2");  
		
		
		
		
		GeradorDeBoleto g = new GeradorDeBoleto(boleto);
		String x = Base64.encodeBytes(g.geraPNG());
		
		
		return x;
	}
	
}

