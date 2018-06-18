/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import model.Funcionario;

/**
 *
 * @author Leonardo Faêda
 */
public class CtrlFuncionario {

    public void listar(DefaultTableModel modelo) {
        Funcionario f = new Funcionario();
        f.listar(modelo);
    }

    public void pesquisar(DefaultTableModel modelo, String digitado) {
        Funcionario f = new Funcionario();
        f.pesquisar(modelo, digitado);
    }

    public void update(ArrayList<String> registro) {
        Funcionario f = new Funcionario();
        f.setSalarioFuncionaro(registro.get(0));
        f.setCpfFuncionario(registro.get(1));
        f.setNomeFuncionario(registro.get(2));
        f.setTelefoneFuncionario(registro.get(3));
        f.setCodFuncionario(Integer.valueOf(registro.get(4)));
        f.update(f);
    }

    public void delete(String id) {
        Funcionario f = new Funcionario();
        f.delete(id);
    }

    public void insert(ArrayList<String> registro) {
        Funcionario f = new Funcionario();
        f.setSalarioFuncionaro(registro.get(0));
        f.setCpfFuncionario(registro.get(1));
        f.setNomeFuncionario(registro.get(2));
        f.setTelefoneFuncionario(registro.get(3));
        f.insert(f);
    }

}
