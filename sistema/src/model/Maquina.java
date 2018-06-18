/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import DAO.DAOMaquina;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Leonardo Faêda
 */
public class Maquina {

    private int codMaquina;
    private String nomeMaquina;
    private String statusMaquina;
    
     public void listar(DefaultTableModel modelo) {
        DAOMaquina daof = new DAOMaquina();
        daof.listar(modelo);
    }


    public void pesquisar(DefaultTableModel modelo, String digitado) {
        DAOMaquina daof = new DAOMaquina();
        daof.pesquisar(modelo, digitado);
    }

    public void update(Maquina f) {
        DAOMaquina daof = new DAOMaquina();
        daof.update(f);
    }

    public void delete(String id) {
        DAOMaquina daof = new DAOMaquina();
        daof.delete(id);
    }

    public void insert(Maquina f) {
        DAOMaquina daof = new DAOMaquina();
        daof.insert(f);
    }
    
    public void gerarRelatorio (ArrayList<Maquina> arrayMaquina){
        DAOMaquina daom = new DAOMaquina();
        daom.gerarRelatorio(arrayMaquina);
    }
    
    
    
    /**
     * @return the codMaquina
     */
    public int getCodMaquina() {
        return codMaquina;
    }

    /**
     * @param codMaquina the codMaquina to set
     */
    public void setCodMaquina(int codMaquina) {
        this.codMaquina = codMaquina;
    }

    /**
     * @return the nomeMaquina
     */
    public String getNomeMaquina() {
        return nomeMaquina;
    }

    /**
     * @param nomeMaquina the nomeMaquina to set
     */
    public void setNomeMaquina(String nomeMaquina) {
        this.nomeMaquina = nomeMaquina;
    }

    /**
     * @return the statusMaquina
     */
    public String getStatusMaquina() {
        return statusMaquina;
    }

    /**
     * @param statusMaquina the statusMaquina to set
     */
    public void setStatusMaquina(String statusMaquina) {
        this.statusMaquina = statusMaquina;
    }

}
