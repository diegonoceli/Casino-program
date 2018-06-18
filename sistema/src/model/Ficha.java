/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import DAO.DAOFicha;
import controller.CtrlFicha;
import java.util.ArrayList;

/**
 *
 * @author Leonardo Faêda
 */
public class Ficha {

    private String preco;

    /**
     * @return the preco
     */
    public String getPreco() {
        return preco;
    }

    /**
     * @param preco the preco to set
     */
    public void setPreco(String preco) {
        this.preco = preco;
    }

    public void pegaPreco(ArrayList<String> preco) {
        DAOFicha daof = new DAOFicha();
        daof.listar(preco);
    }

    public void update(ArrayList<String> registro) {
         DAOFicha daof = new DAOFicha();
         this.preco=registro.get(0);
         daof.update(this);
    }

}
