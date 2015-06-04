/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package scea.web.beans;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import org.primefaces.model.chart.CartesianChartModel;
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
    private LineChartModel graficoRetornado;

      @PostConstruct
      public void init() {
         initGrafico();
      }
 
    public void initGrafico()
    {
        EntidadeRelatorio rel = new EntidadeRelatorio();
        resultado = new Resultado();

        rel.setDtInicial("01/01/2015");
        rel.setDtFinal(("31/06/2016"));
        fachada = new Fachada();
        resultado = fachada.transacoesPeriodo(rel);
        
        GraficoLinhaBuilder grafico = new GraficoLinhaBuilder()
                .initModelo(resultado.getEntidades())
                .informacoesGrafico(resultado.getEntidades())
                .alocarEixos(resultado.getEntidades());
        setGraficoRetornado(grafico.getGraficoLinha());
        

    }
    public LineChartModel teste(){
        return null;
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
     * @return the graficoRetornado
     */
    public LineChartModel getGraficoRetornado() {
        return graficoRetornado;
    }

    /**
     * @param graficoRetornado the graficoRetornado to set
     */
    public void setGraficoRetornado(LineChartModel graficoRetornado) {
        this.graficoRetornado = graficoRetornado;
    }

    /**
     * @return the grafico
     */

    
}
