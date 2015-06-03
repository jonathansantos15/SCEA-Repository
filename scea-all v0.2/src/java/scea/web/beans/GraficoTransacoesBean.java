/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package scea.web.beans;

import javax.faces.bean.ManagedBean;
import org.primefaces.model.chart.LineChartModel;
import scea.core.aplicacao.relatorio.EntidadeRelatorio;
import scea.web.beans.Builder.GraficoLinhaBuilder;

/**
 *
 * @author Main User
 */

@ManagedBean ( name = "graficoEntradaSaidaBean")
public class GraficoTransacoesBean {
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
        GraficoLinhaBuilder grafico = new GraficoLinhaBuilder()
                .initModelo()
                .informacoesGrafico()
                .alocarEixos();
        
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
