package scea.core.testes;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import scea.core.aplicacao.EmailAplicacao;
import scea.core.aplicacao.Estoque;
import scea.core.aplicacao.Resultado;
import scea.core.aplicacao.relatorio.RelTransacoesPeriodo;
import scea.core.impl.controle.Fachada;
import scea.core.impl.controle.FachadaTransacao;
import scea.core.impl.dao.RelatoriosDAO;
import scea.core.impl.dao.SimulacaoDAO;
import scea.core.impl.negocio.SimularEstoque;
import scea.core.impl.negocio.ValidarAcesso;
import scea.core.impl.negocio.ValidarDadosProduto;
import scea.core.impl.negocio.ValidarExistenciaFornecedor;
import scea.core.impl.negocio.ValidarExistenciaTipoDeProduto;
import scea.core.impl.negocio.ValidarLimiteEntrada;
import scea.core.testes.testesDAO.testaDAOAcesso;
import scea.core.testes.testesDAO.testeDAODFornecedor;
import scea.core.testes.testesDAO.testeDAOProduto;
import scea.core.testes.testesDAO.testeValidadorLimiteEntrada;
import scea.core.testes.testesDAO.testeValidadorLimiteSaida;
import scea.dominio.modelo.Acesso;
import scea.dominio.modelo.EntidadeDominio;
import scea.dominio.modelo.Fornecedor;
import scea.dominio.modelo.Produto;
import scea.dominio.modelo.Simulacao;
import scea.dominio.modelo.TipoDeProduto;
import scea.dominio.modelo.Transacao;

public class MainTestes {
        public static Resultado resultado;

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		//testeConexao();
		//testeTransacao
		//testeDAOProduto.testeCadastrarProduto();
		//testeSalvarFachada();
		//testeDAODFornecedor.testeConsultaTodosOsFornecedores();
		//testeAcesso();
		//testVerificaFachadaParaSimulacao();
                //testeRelatorioInicialFachada();
                //ValidarExistenciaFornece();
                //testeValidarDadosProduto();
                //testeValidarExistenciaTipo();
                //testeDeveEnviarEmail();
                testeRelatorioTransaPeriodo();
                //testeconvercaodata();
	}//MAIN
        
        
        public static void convertendoStringPData(){
            
        
        }
        
        public static void testeconvercaodata(){
                Calendar c = Calendar.getInstance();
		Date data = c.getTime();
		DateFormat f = DateFormat.getDateInstance();
		
		Date data2;
            try {
                data2 = f.parse("12/01/1995");
                System.out.println(data2);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		System.out.println("Data formatada: "+sdf.format(data));
                
                System.out.println("Data convertida: "+sdf.parse("02/08/1970"));
            } catch (ParseException ex) {
                Logger.getLogger(MainTestes.class.getName()).log(Level.SEVERE, null, ex);
            }
		
		
		
		//Converte Objetos
		


        }
        
        public static void testeRelatorioTransaPeriodo(){
            RelatoriosDAO dao = new RelatoriosDAO();
            RelTransacoesPeriodo r = new RelTransacoesPeriodo();
            resultado = new Resultado();
            
            //String dtIni = "20140101";
            //String dtFim = "20151201";
            String dtIni = "01/01/2015";
            String dtFim = "01/12/2015";
            r.setDtInicial(r.formatData(dtIni, "dd/MM/yyyy"));
            r.setDtFinal(r.formatData(dtFim, "dd/MM/yyyy"));
            // System.out.println(r.getDtInicial().getTime());
            // r.setDtFinal(dtFim);
            
            //System.out.println(r.getDtInicial());
            //System.out.println(r.getDtFinal());
            
            resultado.setEntidades(dao.consultarRelTransacoesPeriodo(r));
            
            for(EntidadeDominio e: resultado.getEntidades())
            {
                RelTransacoesPeriodo s = (RelTransacoesPeriodo)e;
                System.out.print("Transção: " + s.getTransacao() + " " +
                "Quantidade: " + s.getQuantidade() + " " +
                "Mês: " + s.getMes());
                
                System.out.println();
            }
            
            

            
            
            
        }
        
        public static void testeDeveEnviarEmail(){
            EmailAplicacao emailEnviado = new EmailAplicacao();
            emailEnviado.setAssunto("Teste Email");
            emailEnviado.setDestinatario("jonathan.santos15a@gmail.com");
            emailEnviado.setMensagem("Meu teste");
            
            Fachada f = new Fachada();
            Resultado r = f.enviarEmail(emailEnviado);
            System.out.println(r.getMsg());
        }
        
        public static void testeValidarExistenciaTipo(){
         Resultado r; //= new Resultado();
         ValidarExistenciaTipoDeProduto validador = new ValidarExistenciaTipoDeProduto();
         TipoDeProduto f = new TipoDeProduto();
         f.setId(1);
         
         r = validador.processar(f);
         //if(r.getMsg() != null){
             System.out.println(r.getMsg());
         //}
         
        }
        
	public static void testeValidarExistenciaFornecedor(){
         Resultado r; //= new Resultado();
         ValidarExistenciaFornecedor validador = new ValidarExistenciaFornecedor();
         Fornecedor f = new Fornecedor();
         f.setId(1);
         
         r = validador.processar(f);
         //if(r.getMsg() != null){
             System.out.println(r.getMsg());
         //}
         
        }
        
        public static void testeRelatorioInicialFachada(){
            Fachada f = new Fachada();
            Resultado r = new Resultado();
            r = f.RelatorioInicial(new Produto());
            
            
            for(EntidadeDominio e : r.getEntidades()){
                System.out.println(e.getId());
            
            }
            
        
        
        
        }
        
        
	public static void testeAcesso(){
		Fachada f = new Fachada();
		Acesso ac = new Acesso();
		Resultado r = new Resultado();
		ac.setLogin("f");
		ac.setSenha("1");
		r = f.acessar(ac);
		
		System.out.println(r.getMsg());
		
	}
	
        public static void testVerificaFachadaParaSimulacao()
        {
            Fachada f = new Fachada();
            
            Simulacao s = new Simulacao();
            SimulacaoDAO sdao = new SimulacaoDAO();
            Date d = new Date();
            s.setDtTransacaoFutura(d);
            s.setQtdeItens(3);
            s.setTipoDeTransacao("ENTRADA");
            Produto p = new Produto();;
            p.setId(1);
            s.setProduto(p);
            f.salvar(s);
            Resultado r = f.consultar(s);
            for(EntidadeDominio e: r.getEntidades())
            {
                Simulacao s2 = new Simulacao();
                s2 = (Simulacao) e;
                System.out.println("ID:" + s2.getId() + " Data: " + s2.getDtTransacaoFutura() + " Quantidade: " + s2.getQtdeItens() + " Tipo de Transação: " +
                        s2.getTipoDeTransacao() + " ID PRODUTO "+ s2.getProduto().getId());
            }
        }
	
	public static void testeValidarDadosProduto(){
		ValidarDadosProduto validador = new ValidarDadosProduto();
		Produto p = new Produto();
		Resultado r = new Resultado();
		
		p.setNome("Lapis SB");
		p.getTipoDeProduto().setId(2);
		p.setQuantidade(2);
		p.setValor(0.50);
		p.getFornecedor().setId(1);
		r = validador.processar(p);
		System.out.println(r.getMsg());
	}
	
	public static void testeSalvarFachada(){
		Fachada f = new Fachada();
		Produto p = new Produto();
		Resultado r = new Resultado();
		
		p.setNome("Lapis com tabuada");
		p.getTipoDeProduto().setId(2);
		p.setQuantidade(10);
		p.setValor(0.50);
                p.getFornecedor().setId(1);
		r = f.salvar(p);
		
		System.out.println(r.getMsg());
	}
	
	public static void testeTransacao(){
		FachadaTransacao f = new FachadaTransacao();
		Produto p = new Produto();		
		
		
		p.setId(1);
		p.setQuantidade(1000);
		p.setTipoDeProduto(new TipoDeProduto());
		p.getTipoDeProduto().setTipo("");
		
		Transacao ts = new Transacao();
		ts.setAcesso(new Acesso());
		ts.getAcesso().setId(1);
		ts.setTipoDeTransacao("ENTRADA");
		ts.setProduto(p);
		ts.setQtdeDoTipo(p.getQuantidade());
		Resultado r = f.entrada(ts);
		
		System.out.println();
		;
		if(r.getMsg() != null){
			System.out.println(r.getMsg());
		}
		else{
			System.out.println(((Estoque)r.getEntidades().get(0)).getObs());
			System.out.println("ID: " + ((Estoque)r.getEntidades().get(0)).getProduto().getId());
			System.out.println("NOME: " + ((Estoque)r.getEntidades().get(0)).getProduto().getNome().toUpperCase());
			System.out.println("QUANTIDADE: " + ((Estoque)r.getEntidades().get(0)).getProduto().getQuantidade());
			System.out.println("MAX: " + ((Estoque)r.getEntidades().get(0)).getProduto().getTipoDeProduto().getQtdeMax());
			System.out.println("DESCRICAO: " + ((Estoque)r.getEntidades().get(0)).getProduto().getTipoDeProduto().getDescricao().toUpperCase());
			System.out.println("DISPONIVEL: " + ((Estoque)r.getEntidades().get(0)).getQtdeDisponivel());
			System.out.println("FUTURA: " + ((Estoque)r.getEntidades().get(0)).getQtdeFutura());
			System.out.println("TENTATIVA: " + ((Estoque)r.getEntidades().get(0)).getQtdeTentativa());
		}
	}
	
	
	public static void testeConexao(){
		TesteConexao st = new TesteConexao();
		try {
			try {
				st.testeDeveRealizarConexaoComOBanco();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
        
        public static void testeSimulacao() throws SQLException
        {
            Simulacao s = new Simulacao();
            SimulacaoDAO sdao = new SimulacaoDAO();
            Date d = new Date();
            s.setDtTransacaoFutura(d);
            s.setQtdeItens(3);
            s.setTipoDeTransacao("ENTRADA");
            Produto p = new Produto();;
            p.setId(1);
            s.setProduto(p);
            
            sdao.salvar(s);
            List<EntidadeDominio> entidades = sdao.consultar(s);
            for(EntidadeDominio e: entidades)
            {
                Simulacao s2 = new Simulacao();
                s2 = (Simulacao) e;
                System.out.println("ID:" + s2.getId() + " Data: " + s2.getDtTransacaoFutura() + " Quantidade: " + s2.getQtdeItens() + " Tipo de Transação: " +
                        s2.getTipoDeTransacao() + " ID PRODUTO "+ s2.getProduto().getId());
            }
        }
}
