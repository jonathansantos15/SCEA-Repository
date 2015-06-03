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

@ManagedBean ( name = "graficoTransacoesBean")
public class GraficoTransacoesBean {
    private EntidadeRelatorio relatorio;
    private boolean carrega = false;
    
    public EntidadeRelatorio createRelatorio()
    {
        EntidadeRelatorio rel = new EntidadeRelatorio();
        getRelatorio().setDtInicial(getRelatorio().getDtInicial());
        getRelatorio().setDtFinal(getRelatorio().getDtFinal());   
        return getRelatorio();
    }
    
    public LineChartModel initGrafico()
    {
        carrega = true;
        
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

    /**
     * @return the carrega
     */
    public boolean isCarrega() {
        return carrega;
    }

    /**
     * @param carrega the carrega to set
     */
    public void setCarrega(boolean carrega) {
        this.carrega = carrega;
    }
    
}
