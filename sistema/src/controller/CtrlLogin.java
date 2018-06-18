/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import model.Cliente;
import model.Login;

/**
 *
 * @author Leonardo Faêda
 */
public class CtrlLogin {
    public void listar(DefaultTableModel modelo) {
        Login l = new Login();
        l.listar(modelo);
    }

    public void pesquisar(DefaultTableModel modelo, String digitado) {
        Login l = new Login();
        l.pesquisar(modelo, digitado);
    }

    public void update(ArrayList<String> registro) {
        Login l = new Login();
        l.setNomeLogin(registro.get(0));
        l.setLogin(registro.get(1));
        l.setSenhaLogin(registro.get(2));
        l.setNivel(registro.get(3));
        l.setCodLogin(Integer.valueOf(registro.get(4)));
        l.update(l);
    }

    public void delete(String id) {
        Login l = new Login();
        l.delete(id);
    }
    
     public void salvar(ArrayList<String> registro){
        Login l = new Login();
        l.setNomeLogin(registro.get(0));
        l.setLogin(registro.get(1));
        l.setSenhaLogin(registro.get(2));
        l.setNivel(registro.get(3));    
        l.salvar(l);
    }
}
