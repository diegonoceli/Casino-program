/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.DAOAcesso;
import javax.swing.JOptionPane;
import model.Acesso;

/**
 *
 * @author Leonardo Faêda
 */
public class CtrlAcesso {
    Acesso acesso;
    DAOAcesso daoa;
    
    public CtrlAcesso(){
         acesso=new Acesso();
         daoa=new DAOAcesso(acesso);
    }
    public int verificaLogin(String login,String senha){
        if(daoa.verificaLogin(login, senha)==false){
             JOptionPane.showMessageDialog(null, "Login invalido", "Login o senha invalidos!", JOptionPane.INFORMATION_MESSAGE);
             acesso.setTipo(-3);
            return -3;
        }else{
             JOptionPane.showMessageDialog(null, "Logado com sucesso!", "Login aprovado", JOptionPane.INFORMATION_MESSAGE);
             return Integer.valueOf(acesso.getTipo());
        }
    }

    /**
     * @return the acesso
     */
    public Acesso getAcesso() {
        return acesso;
    }

    /**
     * @param acesso the acesso to set
     */
    public void setAcesso(Acesso acesso) {
        this.acesso = acesso;
    }
}
