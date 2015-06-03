/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package scea.web.beans;

import javax.faces.bean.ManagedBean;
import org.primefaces.model.chart.LineChartModel;
import scea.web.beans.Builder.GraficoLinhaBuilder;

/**
 *
 * @author Main User
 */

@ManagedBean ( name = "graficoEntradaSaidaBean")
public class GraficoEntradaBean {
    
    public LineChartModel initGrafico()
    {
        GraficoLinhaBuilder grafico = new GraficoLinhaBuilder()
                .initModelo()
                .informacoesGrafico()
                .alocarEixos();
        
        return grafico.getGraficoLinha();
    }
    
}
