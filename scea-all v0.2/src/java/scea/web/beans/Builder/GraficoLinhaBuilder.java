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
    
    private LineChartModel graficoLinha;
    
    public GraficoLinhaBuilder()
    {
        graficoLinha = new LineChartModel();
    }
    
     public GraficoLinhaBuilder  initModelo(List<EntidadeDominio> entidades) {
        
         List<EntidadeRelatorio> listRelatorios = new ArrayList<EntidadeRelatorio>();
         
         for(EntidadeDominio e: entidades)
         {
             EntidadeRelatorio relatorio = (EntidadeRelatorio)e;
             listRelatorios.add(relatorio);
         }
        
        if(listRelatorios.size() != 0)
        {
            ChartSeries entradas = new ChartSeries();
            ChartSeries saidas = new ChartSeries();
            entradas.setLabel("Total de Entradas");
            saidas.setLabel("Total de Saídas");    
            graficoLinha.setLegendPosition("se");
            for(int i=0; i < listRelatorios.size(); i++)
            {
                
                if(listRelatorios.get(i).getTransacao().getTipoDeTransacao().equals("ENTRADA"))
                {
                    entradas.set(listRelatorios.get(i).getMes(), listRelatorios.get(i).getTransacao().getQtdeDoTipo());
                   
                }else
                {
                    saidas.set(listRelatorios.get(i).getMes(), listRelatorios.get(i).getTransacao().getQtdeDoTipo());
                    
                }
            }
             graficoLinha.addSeries(entradas);
             graficoLinha.addSeries(saidas);
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
            //graficoLinha.setZoom(true);
            graficoLinha.setAnimate(true);
            //graficoLinha.getAxis(AxisType.Y).setLabel(listRelatorios.get(0).getTituloEixoY());
            //graficoLinha.getAxis(AxisType.X).setLabel(listRelatorios.get(0).getTituloEixoX());
            graficoLinha.setTitle("Total de Entradas e Saídas entre o período" + listRelatorios.get(0).getDtInicial()
            + " á " + listRelatorios.get(0).getDtFinal());
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
            DateAxis axis = new DateAxis("Periodo");
            axis.setTickAngle(-50);
            axis.setTickFormat("%B");
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
