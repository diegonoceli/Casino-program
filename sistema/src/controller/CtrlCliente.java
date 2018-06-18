/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import model.*;

/**
 *
 * @author Leonardo Faêda
 */
public class CtrlCliente {
     
    
    public void listar(DefaultTableModel modelo) {
        Cliente c = new Cliente();
        c.listar(modelo);
    }

    public void pesquisar(DefaultTableModel modelo, String digitado) {
        Cliente c = new Cliente();
        c.pesquisar(modelo, digitado);
    }

    public void update(ArrayList<String> registro) {
        Cliente c = new Cliente();
        c.setCpfCliente(registro.get(0));
        c.setNomeCliente(registro.get(1));
        c.setTelefoneCliente(registro.get(2));
        c.setCodCliente(Integer.valueOf(registro.get(3)));
        c.update(c);
    }

    public void delete(String id) {
        Cliente c = new Cliente();
        c.delete(id);
    }
    
     public void salvar(ArrayList<String> pLista){
        Cliente c = new Cliente();
        c.setNomeCliente(pLista.get(0));
        c.setCpfCliente(pLista.get(1));
        c.setTelefoneCliente(pLista.get(2));        
        c.salvar(c);
    }
}
