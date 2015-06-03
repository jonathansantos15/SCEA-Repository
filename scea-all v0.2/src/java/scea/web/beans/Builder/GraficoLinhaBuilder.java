/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package scea.web.beans.Builder;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.CartesianChartModel;
import org.primefaces.model.chart.CategoryAxis;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.DateAxis;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;
import scea.core.aplicacao.relatorio.EntidadeRelatorio;
import scea.core.aplicacao.relatorio.RelatorioESEstoque;
import scea.dominio.modelo.EntidadeDominio;
import scea.web.beans.Builder.*;

public class GraficoLinhaBuilder implements Serializable{
    
    private LineChartModel graficoLinha = new LineChartModel();
    
     public GraficoLinhaBuilder  initModelo(List<EntidadeDominio> entidades) {
        
         List<EntidadeRelatorio> listRelatorios = new ArrayList<EntidadeRelatorio>();
         
         for(EntidadeDominio e: entidades)
         {
             EntidadeRelatorio relatorio = (EntidadeRelatorio)e;
             listRelatorios.add(relatorio);
         }
        
        if(listRelatorios.size() != 0)
        {
            for(int i=0; i <= listRelatorios.size(); i++)
            {
                LineChartSeries series = new LineChartSeries();
                //series1.setLabel();
                graficoLinha.setLegendPosition("e");
                series.set(listRelatorios.get(i).getMes(), listRelatorios.get(i).getTransacao().getQtdeDoTipo());
                
                graficoLinha.addSeries(series);
            }
        }
        return this;
     }
         
    public GraficoLinhaBuilder informacoesGrafico(List<EntidadeDominio> entidades)
    {
        List<EntidadeRelatorio> listRelatorios = new ArrayList<EntidadeRelatorio>();
         
         for(EntidadeDominio e: entidades)
         {
             EntidadeRelatorio relatorio = (EntidadeRelatorio)e;
             listRelatorios.add(relatorio);
         }
        
        if(listRelatorios.size() != 0)
        {
            graficoLinha.setTitle(listRelatorios.get(0).getTituloRelatorio());
            graficoLinha.setZoom(true);
            graficoLinha.setAnimate(true);
            graficoLinha.getAxis(AxisType.Y).setLabel(listRelatorios.get(0).getTituloEixoY());
            //graficoLinha.getAxis(AxisType.X).setLabel(listRelatorios.get(0).getTituloEixoX());
        }
        return this;
    }

    public GraficoLinhaBuilder alocarEixos(List<EntidadeDominio> entidades)
    {
        List<EntidadeRelatorio> listRelatorios = new ArrayList<EntidadeRelatorio>();
         
         for(EntidadeDominio e: entidades)
         {
             EntidadeRelatorio relatorio = (EntidadeRelatorio)e;
             listRelatorios.add(relatorio);
         }
        
        if(listRelatorios.size() != 0)
        {
            DateAxis axis = new DateAxis(listRelatorios.get(0).getTituloEixoX());
            axis.setTickAngle(-50);
            //axis.setTickFormat("%d %#b, %y");    
            graficoLinha.getAxes().put(AxisType.X, axis);
        }
        return this;
    }
     
    
    /**
     * @return the graficoLinha
     */
    public LineChartModel getGraficoLinha() {
        return graficoLinha;
    }

    /**
     * @param graficoLinha the graficoLinha to set
     */
    public void setGraficoLinha(LineChartModel graficoLinha) {
        this.graficoLinha = graficoLinha;
    }
    
    
}
