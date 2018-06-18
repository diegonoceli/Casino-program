/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import model.Gerente;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Leonardo Faêda
 */
public class CtrlGerente {
    private Gerente objGerente;
    
    public CtrlGerente(){
        this.objGerente = new Gerente();
    }
    
     public void inserir(ArrayList<String> pLista){
        this.objGerente.setSalarioGerente(pLista.get(0)); 
        this.objGerente.setNomeGerente(pLista.get(1));
        this.objGerente.setCpfGerente(pLista.get(2));
        this.objGerente.setTelefoneGerente(pLista.get(3));
        this.objGerente.salvar();
    }

      public void listar(DefaultTableModel modelo) {
        Gerente g = new Gerente();
        g.listar(modelo);
    }

    public void pesquisar(DefaultTableModel modelo, String digitado) {
        Gerente g = new Gerente();
        g.pesquisar(modelo, digitado);
    }

    public void update(ArrayList<String> registro) {
        Gerente g = new Gerente();
        g.setSalarioGerente(registro.get(0));
        g.setCpfGerente(registro.get(1));
        g.setNomeGerente(registro.get(2));
        g.setTelefoneGerente(registro.get(3));
        g.setCodGerente(Integer.valueOf(registro.get(4)));
        g.update(g);
    }

    public void delete(String id) {
        Gerente g = new Gerente();
        g.delete(id);
    }

  
}
