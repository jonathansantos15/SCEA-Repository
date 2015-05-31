/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package scea.core.aplicacao.relatorio;

import java.util.Date;

import scea.dominio.modelo.EntidadeDominio;

/**
 *
 * @author Felipe
 */
public class RelTransacoesPeriodo extends EntidadeDominio{
    private String dtInicial;           // Operação
    private String dtFinal;             // Qde
    private String Transacao;                 // Mes do intervalo
    private int quantidade;
    private String mes;

    /**
     * @return the dtInicil
     */
    public String getDtInicial() {
        return dtInicial;
    }

    /**
     * @param dtInicil the dtInicil to set
     */
    public void setDtInicial(String dtInicil) {
        this.dtInicial = dtInicil;
    }

    /**
     * @return the dtFinal
     */
    public String getDtFinal() {
        return dtFinal;
    }

    /**
     * @param dtFinal the dtFinal to set
     */
    public void setDtFinal(String dtFinal) {
        this.dtFinal = dtFinal;
    }

    /**
     * @return the Transacao
     */
    public String getTransacao() {
        return Transacao;
    }

    /**
     * @param Transacao the Transacao to set
     */
    public void setTransacao(String Transacao) {
        this.Transacao = Transacao;
    }

    /**
     * @return the quantidade
     */
    public int getQuantidade() {
        return quantidade;
    }

    /**
     * @param quantidade the quantidade to set
     */
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

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
    
    
    
}
