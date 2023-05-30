/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pss.dadosclima.presenter;

import com.pss.dadosclima.view.IncluirFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import javax.swing.JInternalFrame;

/**
 *
 * @author UFES
 */

public class IncluirPresenter {
    private IncluirFrame view;
    
    
    public IncluirPresenter(PrincipalPresenter presenter) {
        
        view=new IncluirFrame();
        view.setVisible(true);
        
        view.getIncluirButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
           
                try{
                    presenter.addMedicao(Float.parseFloat(view.getTemperaturaField().getText()), Float.parseFloat(view.getPressaoField().getText()), Float.parseFloat(view.getUmidadeField().getText()),LocalDate.parse(view.getDataField().getText(), DateTimeFormatter.ofPattern("dd/MM/yyyy")));
                }
                catch(DateTimeParseException dx){
                    presenter.addMedicao(Float.parseFloat(view.getTemperaturaField().getText()), Float.parseFloat(view.getPressaoField().getText()), Float.parseFloat(view.getUmidadeField().getText()),LocalDate.now());    
                }
            }
        });
    }
    
    
     public JInternalFrame getFrame(){
        return view;
    }
}
