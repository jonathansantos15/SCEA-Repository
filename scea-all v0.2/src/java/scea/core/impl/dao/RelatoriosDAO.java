package scea.core.impl.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import scea.core.aplicacao.relatorio.RelTransacoesPeriodo;

import scea.core.impl.dao.AbstractJdbcDAO;
import scea.dominio.modelo.EntidadeDominio;
import scea.dominio.modelo.Fornecedor;
import scea.dominio.modelo.Produto;
import scea.dominio.modelo.TipoDeProduto;
import scea.dominio.modelo.Transacao;

public class RelatoriosDAO extends AbstractJdbcDAO{
	public RelatoriosDAO() {
		super("tb_produto", "id_produto");		
	}
	
	
	public List<EntidadeDominio> consultar(EntidadeDominio entidade) {
		PreparedStatement pst = null;
		
		RelTransacoesPeriodo relTransPeriodo = (RelTransacoesPeriodo)entidade;
		String sql=null;
		
                if(entidade instanceof RelTransacoesPeriodo){
			sql = "SELECT  transacao, sum(quantidade) AS 'quantidade', monthname(dt_transacao) AS 'mes' FROM tb_transacao  WHERE dt_transacao BETWEEN ? AND ? GROUP BY transacao, month(dt_transacao) ORDER BY month(dt_transacao)";
		}
                
		
		
		
	//	else if(produto.getId() == null && produto.getNome() != null ){
			//System.out.println("\n\n\n\n\n\n\n\n\n\n terceiro  \n\n\n\n\n\n\n\n");
			//sql = "SELECT * FROM tb_produto   JOIN tb_tipodeproduto    USING(id_tipodeproduto) JOIN tb_fornecedor   USING(id_fornecedor) WHERE   nome like '"+produto.getNome()+"%' ORDER BY id_produto";
          //                sql = "SELECT * FROM tb_produto p JOIN tb_tipodeproduto  t USING(id_tipodeproduto) JOIN tb_fornecedor f USING(id_fornecedor) WHERE p.nome like '"+produto.getNome()+"%' ORDER BY p.id_produto"; 
           //     }
		
	try {
		openConnection();
		pst = connection.prepareStatement(sql);
		
		pst.setDate(1, relTransPeriodo.getDtInicial().getTime());
                pst.setDate(2, relTransPeriodo.getDtFinal().getTime());
		
		ResultSet rs = pst.executeQuery();
		List<EntidadeDominio> produtos = new ArrayList<EntidadeDominio>();
		while (rs.next()) {
                Produto p = new Produto();
			
			
			p.setId(rs.getInt("id_produto"));
			p.setNome(rs.getString("nome"));
			p.setQuantidade(rs.getInt("quantidade"));
			p.setValor(rs.getDouble("vlr"));
			p.getFornecedor().setId((rs.getInt("id_fornecedor")));
			p.getTipoDeProduto().setId(rs.getInt("id_tipodeproduto"));
			p.getTipoDeProduto().setDescricao(rs.getString("descricao"));
			p.getTipoDeProduto().setQtdeMax(rs.getInt("qtdeMax"));
			p.getTipoDeProduto().setQtdeMin(rs.getInt("qtdeMin"));
			p.getTipoDeProduto().setTipo((rs.getString("tipo")));
			
			p.getFornecedor().setId(rs.getInt("id_fornecedor"));
			p.getFornecedor().setNome(rs.getString("nome"));
			p.getFornecedor().setEmail(rs.getString("email"));
			p.getFornecedor().setNomeFantasia(rs.getString("nome_fantasia"));
			p.getFornecedor().setRazaoSocial(rs.getString("rzsocial"));
			p.getFornecedor().setCNPJ(rs.getString("cnpj"));
						
			produtos.add(p);
		}
		return produtos;
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return null;

	}
        
        
        public List<EntidadeDominio> consultarRelatorioInicial(EntidadeDominio entidade) {
		PreparedStatement pst = null;
		
		Produto produto = (Produto)entidade;
		String sql=null;
		
                sql = "SELECT * FROM tb_produto p JOIN tb_tipodeproduto tp USING(id_tipodeproduto) JOIN tb_fornecedor  f USING(id_fornecedor) WHERE p.quantidade <= tp.qtdeMin OR p.quantidade = 0  ORDER BY p.id_produto";
			
		
	try {
		openConnection();
		pst = connection.prepareStatement(sql);
		
		
		ResultSet rs = pst.executeQuery();
		List<EntidadeDominio> produtos = new ArrayList<EntidadeDominio>();
		while (rs.next()) {
                        Produto p = new Produto();
			
			p.setId(rs.getInt("id_produto"));
			p.setNome(rs.getString("nome"));
			p.setQuantidade(rs.getInt("quantidade"));
			p.setValor(rs.getDouble("vlr"));
			p.getFornecedor().setId((rs.getInt("id_fornecedor")));
			p.getTipoDeProduto().setId(rs.getInt("id_tipodeproduto"));
			p.getTipoDeProduto().setDescricao(rs.getString("descricao"));
			p.getTipoDeProduto().setQtdeMax(rs.getInt("qtdeMax"));
			p.getTipoDeProduto().setQtdeMin(rs.getInt("qtdeMin"));
			p.getTipoDeProduto().setTipo((rs.getString("tipo")));
			
			p.getFornecedor().setId(rs.getInt("id_fornecedor"));
			p.getFornecedor().setNome(rs.getString("nome"));
			p.getFornecedor().setEmail(rs.getString("email"));
			p.getFornecedor().setNomeFantasia(rs.getString("nome_fantasia"));
			p.getFornecedor().setRazaoSocial(rs.getString("rzsocial"));
			p.getFornecedor().setCNPJ(rs.getString("cnpj"));
						
			produtos.add(p);
		}
		return produtos;
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return null;

	}

        
    @Override
    public void salvar(EntidadeDominio entidade) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void alterar(EntidadeDominio entidade) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void excluir(EntidadeDominio entidade) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

	
}


