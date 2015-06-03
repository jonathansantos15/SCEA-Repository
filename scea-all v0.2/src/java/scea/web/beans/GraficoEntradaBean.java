/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package scea.web.beans;

import javax.faces.bean.ManagedBean;
import org.primefaces.model.chart.LineChartModel;
import scea.core.aplicacao.Resultado;
import scea.core.aplicacao.relatorio.EntidadeRelatorio;
import scea.core.impl.controle.Fachada;
import static scea.core.testes.MainTestes.fachada;
import static scea.core.testes.MainTestes.resultado;
import scea.web.beans.Builder.GraficoLinhaBuilder;

/**
 *
 * @author Main User
 */

@ManagedBean ( name = "graficoEntradaSaidaBean")
public class GraficoEntradaBean {
    private EntidadeRelatorio relatorio;
    
    public EntidadeRelatorio createRelatorio()
    {
        EntidadeRelatorio rel = new EntidadeRelatorio();
        relatorio.setDtInicial(getRelatorio().getDtInicial());
        relatorio.setDtFinal(getRelatorio().getDtFinal());   
        return relatorio;
    }
    
    public LineChartModel initGrafico()
    {
        EntidadeRelatorio rel = new EntidadeRelatorio();
        Resultado res = new Resultado();

        rel.setDtInicial("01/03/2015");
        rel.setDtFinal(("31/06/2015"));
        Fachada fac = new Fachada();
        res = fac.transacoesPeriodo(rel);
        GraficoLinhaBuilder grafico = new GraficoLinhaBuilder()
                .initModelo(res.getEntidades())
                .informacoesGrafico(res.getEntidades())
                .alocarEixos(res.getEntidades());
        
        return grafico.getGraficoLinha();
    }

    /**
     * @return the relatorio
     */
    public EntidadeRelatorio getRelatorio() {
        return relatorio;
    }

    /**
     * @param relatorio the relatorio to set
     */
    public void setRelatorio(EntidadeRelatorio relatorio) {
        this.relatorio = relatorio;
    }
    
}
