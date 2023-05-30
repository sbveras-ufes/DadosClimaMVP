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
public class LogXML implements Log{
    private static final Logger logger = LoggerFactory.getLogger(LogXML.class);

    public void logar(DadoClima dado, Operacao op) {
        StringBuilder xml = new StringBuilder();
        xml.append("<log>");
        xml.append("<operacao>").append(op.toString()).append("</operacao>");
        xml.append("<dado>").append(dado.toString()).append("</dado>");
        xml.append("</log>");

        logger.info(xml.toString());
    }
}

