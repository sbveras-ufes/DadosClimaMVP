/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.pss.dadosclima.service;

import com.pss.dadosclima.enums.Operacao;
import com.pss.dadosclima.model.DadoClima;

/**
 *
 * @author UFES
 */
public interface Log {
   public void logar(DadoClima dado, Operacao op) ;
}
