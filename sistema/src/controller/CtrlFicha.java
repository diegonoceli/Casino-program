/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.DAOFicha;
import java.util.ArrayList;
import model.Ficha;

/**
 *
 * @author Leonardo Faêda
 */
public class CtrlFicha {

    public void buscaPreco(ArrayList<String> preco) {
        Ficha ficha = new Ficha();
        ficha.pegaPreco(preco);
    }

    public void update(ArrayList<String> registro) {
         Ficha ficha = new Ficha();
         ficha.update(registro);
    }
}
