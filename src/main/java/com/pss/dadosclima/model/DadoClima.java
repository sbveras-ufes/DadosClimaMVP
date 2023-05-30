/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pss.dadosclima.model;

import java.time.LocalDate;

/**
 *
 * @author UFES
 */
public class DadoClima {
    private float Temperatura;
    private float Pressao;
    private float umidade;
    private LocalDate data;

    public DadoClima(float Temperatura, float Pressao, float umidade, LocalDate data) {
        this.Temperatura = Temperatura;
        this.Pressao = Pressao;
        this.umidade = umidade;
        this.data=data;
     
    }

    public float getTemperatura() {
        return Temperatura;
    }

    public float getPressao() {
        return Pressao;
    }

    public float getUmidade() {
        return umidade;
    }

    public LocalDate getData() {
        return data;
    }

    @Override
    public String toString() {
        return "Temperatura=" + Temperatura + ", Pressao=" + Pressao + ", umidade=" + umidade + ", data=" + data;
    }
    
    
    
}
