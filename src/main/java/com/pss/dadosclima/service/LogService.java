/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pss.dadosclima.service;

import com.pss.dadosclima.enums.FormatosLog;
import com.pss.dadosclima.enums.Operacao;
import com.pss.dadosclima.model.DadoClima;

/**
 *
 * @author UFES
 */
public class LogService {
   private Log servico;

    public void setServico(FormatosLog formato) {
        switch(formato){
                    case JSON:
                        this.servico=new LogJson();
                    break;
                    
                    case XML:
                        this.servico=new LogXML();
                    break;
            }
        
    }
    public void handle(DadoClima dado, Operacao op){
        servico.logar(dado, op);
    }

    public LogService(FormatosLog formato) {
        setServico(formato);
    }

    public LogService() {
        servico=new LogJson();
    }
    
   
}
