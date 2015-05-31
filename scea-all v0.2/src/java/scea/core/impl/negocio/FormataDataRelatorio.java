/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package scea.core.impl.negocio;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import scea.core.aplicacao.Resultado;
import scea.core.aplicacao.relatorio.RelTransacoesPeriodo;
import scea.core.interfaces.IStrategy;
import scea.dominio.modelo.EntidadeDominio;

/**
 *
 * @author Felipe
 */
public class FormataDataRelatorio implements IStrategy{

	@Override
	public Resultado processar(EntidadeDominio entidade) {
        /*
            SITUAÇÃO: Fase experimental:
            
        */
      /*      
        Date dt;
            //String dataString = ((RelTransacoesPeriodo)entidade).getDtInicial().getTime();
        try {
            DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
            dt = df.parse(dataString);
            //return dt;
        } catch (ParseException e) {
            e.printStackTrace();
        }*/
    return null;
    }
    
}
