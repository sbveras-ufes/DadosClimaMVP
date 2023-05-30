/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pss.dadosclima.presenter;

import com.pss.dadosclima.enums.FormatosLog;
import com.pss.dadosclima.enums.Operacao;
import com.pss.dadosclima.model.DadoClima;
import com.pss.dadosclima.presenter.Paineis.GraficoPresenter;
import com.pss.dadosclima.presenter.Paineis.MediaPresenter;
import com.pss.dadosclima.presenter.Paineis.Painel;
import com.pss.dadosclima.presenter.Paineis.RegistrosPresenter;
import com.pss.dadosclima.presenter.Paineis.UltimoPresenter;
import com.pss.dadosclima.service.LogService;
import com.pss.dadosclima.view.PrincipalView;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author UFES
 */
public final class PrincipalPresenter {
    private PrincipalView view;
    private ArrayList<Painel> paineis= new ArrayList<>();
    private LogService log =new LogService();

    private int numregistros=0;

    public PrincipalPresenter() {
    view=new PrincipalView();
        view.getDesktopPane().add(new IncluirPresenter(this).getFrame());
        RegistarPainel(new MediaPresenter());
        RegistarPainel(new UltimoPresenter());
        RegistarPainel(new RegistrosPresenter(this));
        RegistarPainel(new GraficoPresenter());
        paineis.forEach((n)-> view.getDesktopPane().add(n.getFrame()) );
        
        view.getConfigurarItem().addActionListener((e) -> {
        
        FormatosLog selecionado = (FormatosLog) JOptionPane.showInternalInputDialog(view.getDesktopPane(),"Log:", "Configuração",JOptionPane.QUESTION_MESSAGE, null,FormatosLog.values(), FormatosLog.values()[0]);
        
        if (selecionado != null) {
            this.log=new LogService(selecionado);
            JOptionPane.showInternalMessageDialog(view.getDesktopPane(),"A saída do log será em " + selecionado,"Aviso",1);
            
         }
        
        
            
        });
        
    view.repaint();
    
    }
    public void RegistarPainel(Painel painel){
        paineis.add(painel);
        
    }
    
    public void addMedicao(float temperatura,  float pressao, float umidade, LocalDate data){
        notificarPaineis(new DadoClima(temperatura,pressao,umidade,data), Operacao.INCLUIR);
        
    }
    public void remMedicao(DadoClima dado){
        notificarPaineis(dado, Operacao.EXCLUIR);
    }
    
    private void notificarPaineis(DadoClima dado, Operacao op){
        paineis.forEach((n) -> n.atualizar(dado, op));
        log.handle(dado, op);
        
        switch(op){
            case INCLUIR:
                numregistros++;
                break;
            case EXCLUIR:
                numregistros--;
                break;
        }    
        view.getQuantidadeLabel().setText(String.valueOf(numregistros));
    }
    
   
    
}
