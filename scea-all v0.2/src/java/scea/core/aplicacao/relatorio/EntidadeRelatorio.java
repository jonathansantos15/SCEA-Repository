/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package scea.core.aplicacao.relatorio;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import scea.dominio.modelo.EntidadeDominio;
import scea.dominio.modelo.Transacao;

/**
 *
 * @author Felipe
 */
public class EntidadeRelatorio extends EntidadeDominio{
    private Date dtInicial;           // Operação
    private Date dtFinal;             // Qde
    private String mes;
    private Transacao transacao;
    


    /**
     * @return the mes
     */
    public String getMes() {
        return mes;
    }

    /**
     * @param mes the mes to set
     */
    public void setMes(String mes) {
        this.mes = mes;
    }

    /**
     * @return the dtInicial
     */
    public Date getDtInicial() {
        return dtInicial;
    }

    /**
     * @param dtInicial the dtInicial to set
     */
    public void setDtInicial(Date dtInicial) {
        this.dtInicial = dtInicial;
    }
    
    public void setDtInicial(String dtInicial) {
        //this.dtInicial = dtInicial;
        Date dt;
        try {
            DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
            dt = df.parse(dtInicial);
            //return dt;
            this.dtInicial = dt;
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    /**
     * @return the dtFinal
     */
    public Date getDtFinal() {
        return dtFinal;
    }

    /**
     * @param dtFinal the dtFinal to set
     */
    public void setDtFinal(Date dtFinal) {
        this.dtFinal = dtFinal;
    }

    public void setDtFinal(String dtFinal){
     Date dt;
        try {
            DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
            dt = df.parse(dtFinal);
            //return dt;
            this.dtFinal = dt;
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * @return the transacao
     */
    public Transacao getTransacao() {
        return transacao;
    }

    /**
     * @param transacao the transacao to set
     */
    public void setTransacao(Transacao transacao) {
        this.transacao = transacao;
    }
    
    
    
}
