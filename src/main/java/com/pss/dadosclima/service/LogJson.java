/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pss.dadosclima.service;
import com.pss.dadosclima.enums.Operacao;
import com.pss.dadosclima.model.DadoClima;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author UFES
 */
public class LogJson implements Log{



    private static final Logger logger = LoggerFactory.getLogger(LogJson.class);

    
    public void logar(DadoClima dado, Operacao op){
        logger.info(op.toString() +"  " + dado.toString());
    }

    
}
